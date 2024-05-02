package si.mlimedija.service;

import static java.nio.charset.StandardCharsets.UTF_8;

//import com.google.gson.Gson;
//import com.google.gson.stream.JsonReader;
//import com.google.rpc.Code;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.mlimedija.proto.*;
import si.mlimedija.server.StorageNodeRegistry;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


// This class is responsible for sending/retrieving data to/from storage nodes with gRPC calls
public class MasterService extends masterGrpc.masterImplBase {

    private static final Logger logger = LoggerFactory.getLogger(MasterService.class.getSimpleName());

    private StorageNodeRegistry storageNodeRegistry;

    // stores grpc service_config.json
    private Map<String, Object> storageServiceConfig = new HashMap<>();

    private Map<String, Integer> errorCodes = new HashMap<>();

    public MasterService(StorageNodeRegistry storageNodeRegistry) {
        this.storageNodeRegistry = storageNodeRegistry;
        initStorageConfig(); // initialize map with values
        initErrorCodes(); // initialize map with grpc status messages and corresponding http status codes
    }

    private void initStorageConfig() {
        this.storageServiceConfig.put("maxAttempts", 3D);
        this.storageServiceConfig.put("initialBackoff", "1s");
        this.storageServiceConfig.put("maxBackoff", "5s");
        this.storageServiceConfig.put("backoffMultiplier", 2D);
        this.storageServiceConfig.put("retryableStatusCodes", Arrays.<Object>asList("UNAVAILABLE", "RESOURCE_EXHAUSTED", "INTERNAL", "DEADLINE_EXCEEDED"));
    }

    private void initErrorCodes() {
        this.errorCodes.put("OK", 200);
        this.errorCodes.put("CANCELLED", 499);
        this.errorCodes.put("UNKNOWN", 500);
        this.errorCodes.put("INVALID_ARGUMENT", 400);
        this.errorCodes.put("DEADLINE_EXCEEDED", 504);
        this.errorCodes.put("NOT_FOUND", 404);
        this.errorCodes.put("ALREADY_EXISTS", 409);
        this.errorCodes.put("PERMISSION_DENIED", 403);
        this.errorCodes.put("RESOURCE_EXHAUSTED", 429);
        this.errorCodes.put("FAILED_PRECONDITION", 400);
        this.errorCodes.put("ABORTED", 409);
        this.errorCodes.put("OUT_OF_RANGE", 400);
        this.errorCodes.put("UNIMPLEMENTED", 501);
        this.errorCodes.put("INTERNAL", 500);
        this.errorCodes.put("UNAVAILABLE", 503);
        this.errorCodes.put("DATA_LOSS", 500);
        this.errorCodes.put("UNAUTHENTICATED", 401);
    }


    // TODO => split putData method on smaller parts (methods)
    @Override
    public void putData(PutDataRequest clientRequest, StreamObserver<PutDataResponse> responseObserver) {

        // extract client request
        String key = clientRequest.getKey();
        String value = clientRequest.getValue();

        // checks if key already exists in cache, otherwise calls dataPlacement method
        int nodeId = storageNodeRegistry.findKey(key);
        if (nodeId == -1) {
            nodeId = storageNodeRegistry.dataPlacement(key);
        }

        // extract ipAddress and nodePort for node
        String nodeIpAddress = storageNodeRegistry.getNodeInfo(nodeId).getNodeIpAddress();
        int nodePort = storageNodeRegistry.getNodeInfo(nodeId).getNodePort();

        logger.info("PUT_DATA request: key=" + key + "|value=" + value + "|nodeId=" + nodeId + "|ipAddress=" + nodeIpAddress + "|port=" + nodePort);

        // create channel to storage node
        ManagedChannel channel = ManagedChannelBuilder.
                forAddress(nodeIpAddress, nodePort).
                defaultServiceConfig(storageServiceConfig).
                usePlaintext().
                enableRetry().
                build();

        try {
            storageGrpc.storageBlockingStub storageStub = storageGrpc.newBlockingStub(channel);

            // package data for node request
            PutDataNodeRequest nodeRequest = PutDataNodeRequest.newBuilder().
                    setNodeId(nodeId).
                    setKey(key).
                    setValue(value).
                    build();

            // send request, retrieve response from node, set deadline of 5 seconds
            PutDataNodeResponse nodeResponse = storageStub.withDeadlineAfter(5, TimeUnit.SECONDS).putDataNode(nodeRequest);

            // TODO => ?? might delete this ??
            if (nodeResponse.getResponseCode() == 200) {
                // store key to metadata in case request to storage node was successful
                storageNodeRegistry.getNodeInfo(nodeId).putKey(key);
                logger.info("PUT_DATA SUCCESS: key=" + key);
            } else if (nodeResponse.getResponseCode() == 400) {
                // TODO => handle unsuccessful data puts
            }

            // package data for client response - success
            PutDataResponse.Builder clientResponse = PutDataResponse.
                    newBuilder().
                    setKey(nodeResponse.getKey()).
                    setResponseCode(nodeResponse.getResponseCode()).
                    setResponseMessage(nodeResponse.getResponseMessage());

            // send response to the client
            responseObserver.onNext(clientResponse.build());
            responseObserver.onCompleted();

        } catch (StatusRuntimeException e) {
            // handle the exception
            logger.error("PUT_DATA_request timed out for key=" + key);
            Status status = Status.fromThrowable(e);

            if (status != null) {
                // extract information from the status
                Status.Code responseCode = status.getCode();
                String responseMessage = status.getDescription();

                // package data for client response - failure with known status code
                PutDataResponse.Builder clientResponse = PutDataResponse.
                        newBuilder().
                        setKey(key).
                        setResponseCode(errorCodes.get(responseCode.toString())).
                        setResponseMessage(responseCode.toString());

                // send response to the client
                responseObserver.onNext(clientResponse.build());
                responseObserver.onCompleted();
                logger.error("gRPC call failed with status code: " + responseCode + ", description: " + responseMessage);

            } else {
                // package data for client response - failure with unknown status code
                PutDataResponse.Builder clientResponse = PutDataResponse.
                        newBuilder().
                        setKey(key).
                        setResponseCode(400).
                        setResponseMessage("gRPC call failed with unknown status");

                // send response to the client
                responseObserver.onNext(clientResponse.build());
                responseObserver.onCompleted();
                logger.error("gRPC call failed with unknown status");
            }

            // TODO => mark node as unhealthy OR remove it from the map (have to decide the exact procedure)


        } finally {
            // shutdown the channel when done
            channel.shutdown();
        }
    }

    @Override
    public void getData(GetDataRequest clientRequest, StreamObserver<GetDataResponse> responseObserver) {

        // extract client request
        String key = clientRequest.getKey();

        int nodeId = storageNodeRegistry.findKey(key);
        String nodeIpAddress;
        int nodePort;

        // key is stored on one of the nodes
        if (nodeId != -1) {
            nodeIpAddress = storageNodeRegistry.getNodeInfo(nodeId).getNodeIpAddress();
            nodePort = storageNodeRegistry.getNodeInfo(nodeId).getNodePort();

            logger.info("GET_DATA request: key=" + key + "|nodeId=" + nodeId + "|ipAddress=" + nodeIpAddress + "|port=" + nodePort);

            // create channel to storage node
            ManagedChannel channel = ManagedChannelBuilder.
                    forAddress(nodeIpAddress, nodePort).
                    defaultServiceConfig(storageServiceConfig).
                    usePlaintext().
                    enableRetry().
                    build();

            try {
                storageGrpc.storageBlockingStub storageStub = storageGrpc.newBlockingStub(channel);

                // package data for node request
                GetDataNodeRequest nodeRequest = GetDataNodeRequest.
                        newBuilder().
                        setNodeId(nodeId).
                        setKey(key).
                        build();

                // send request, retrieve response from node, set deadline of 5 seconds
                GetDataNodeResponse nodeResponse = storageStub.withDeadlineAfter(5, TimeUnit.SECONDS).getDataNode(nodeRequest);

                // package response for client
                GetDataResponse.Builder clientResponse = GetDataResponse.
                        newBuilder().
                        setKey(nodeResponse.getKey()).
                        setValue(nodeResponse.getValue()).
                        setResponseCode(nodeResponse.getResponseCode()).
                        setResponseMessage(nodeResponse.getResponseMessage());

                // send response to the client
                responseObserver.onNext(clientResponse.build());
                responseObserver.onCompleted();

            } catch (StatusRuntimeException e) {
                // handle the exception
                logger.error("PUT_DATA_request timed out for key=" + key);
                Status status = Status.fromThrowable(e);

                if (status != null) {
                    // extract information from the status
                    Status.Code responseCode = status.getCode();
                    String responseMessage = status.getDescription();

                    // package data for client response - failure with known status code
                    GetDataResponse.Builder clientResponse = GetDataResponse.
                            newBuilder().
                            setKey(key).
                            setValue("").
                            setResponseCode(errorCodes.get(responseCode.toString())).
                            setResponseMessage(responseCode.toString());

                    // send response to the client
                    responseObserver.onNext(clientResponse.build());
                    responseObserver.onCompleted();
                    logger.error("gRPC call failed with status code: " + responseCode + ", description: " + responseMessage);

                } else {
                    // package data for client response - failure with unknown status code
                    GetDataResponse.Builder clientResponse = GetDataResponse.
                            newBuilder().
                            setKey(key).
                            setValue("").
                            setResponseCode(400).
                            setResponseMessage("gRPC call failed with unknown status");

                    // send response to the client
                    responseObserver.onNext(clientResponse.build());
                    responseObserver.onCompleted();
                    logger.error("gRPC call failed with unknown status");
                }
            } finally {
                // shutdown the channel when done
                channel.shutdown();
            }
        }
        else {
            // key is not store on one of the nodes
            logger.warn("GET_DATA request: could not retrieve key=" + key + " from cache");

            // package data for client response - key not found
            GetDataResponse.Builder clientResponse = GetDataResponse.
                    newBuilder().
                    setKey(key).
                    setValue("").
                    setResponseCode(404).
                    setResponseMessage("Key=" + key + " couldn't be found");

            // send response to the client
            responseObserver.onNext(clientResponse.build());
            responseObserver.onCompleted();
        }
    }
}
