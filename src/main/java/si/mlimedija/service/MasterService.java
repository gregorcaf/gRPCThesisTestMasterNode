package si.mlimedija.service;

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
import si.mlimedija.server.EC2NodeRegistry;
import si.mlimedija.server.LambdaNodeRegistry;

import java.util.*;
import java.util.concurrent.TimeUnit;


// This class is responsible for sending/retrieving data to/from storage nodes with gRPC calls
public class MasterService extends masterGrpc.masterImplBase {

    private static final Logger logger = LoggerFactory.getLogger(MasterService.class.getSimpleName());

    private EC2NodeRegistry ec2NodeRegistry;
    private LambdaNodeRegistry lambdaNodeRegistry;

    private Map<String, Object> storageServiceConfig = new HashMap<>(); // stores grpc service_config.json
    private Map<String, Integer> errorCodes = new HashMap<>(); // stores grpc error codes

    public MasterService(EC2NodeRegistry ec2NodeRegistry, LambdaNodeRegistry lambdaNodeRegistry) {
        this.ec2NodeRegistry = ec2NodeRegistry;
        this.lambdaNodeRegistry = lambdaNodeRegistry;
        initStorageConfig(); // initialize map with values
        initErrorCodes(); // initialize map with grpc status messages and corresponding http status codes
    }

    // retry mechanism (exponential backoff)
    private void initStorageConfig() {
        this.storageServiceConfig.put("maxAttempts", 3D);
        this.storageServiceConfig.put("initialBackoff", "1s");
        this.storageServiceConfig.put("maxBackoff", "5s");
        this.storageServiceConfig.put("backoffMultiplier", 2D);
        this.storageServiceConfig.put("retryableStatusCodes", Arrays.<Object>asList("UNAVAILABLE", "RESOURCE_EXHAUSTED", "INTERNAL", "DEADLINE_EXCEEDED"));
    }

    // list of gRPC error codes
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


    // puts the data to EC2 storage node for the given key-value pair
    @Override
    public void putData(PutDataRequest clientRequest, StreamObserver<PutDataResponse> responseObserver) {

        // extract client request
        String key = clientRequest.getKey();
        String value = clientRequest.getValue();

        // checks if key already exists in cache, otherwise calls dataPlacement method
        int nodeId = ec2NodeRegistry.findKey(key);
        if (nodeId == -1) {
            nodeId = ec2NodeRegistry.dataPlacement(key);
        }

        // extract ipAddress and nodePort for node
        String nodeIpAddress = ec2NodeRegistry.getNodeInfo(nodeId).getNodeIpAddress();
        int nodePort = ec2NodeRegistry.getNodeInfo(nodeId).getNodePort();

//        logger.info("PUT_DATA request: key=" + key);
//        logger.info("PUT_DATA request: key=" + key + "|value=" + value + "|nodeId=" + nodeId + "|ipAddress=" + nodeIpAddress + "|port=" + nodePort);

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
                ec2NodeRegistry.getNodeInfo(nodeId).putKey(key, 0);
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
            logger.error("PUT_DATA request timed out for key=" + key);
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


    // retrieve the data from EC2 storage node for the given key
    @Override
    public void getData(GetDataRequest clientRequest, StreamObserver<GetDataResponse> responseObserver) {

        // extract client request
        String key = clientRequest.getKey();

        int nodeId = ec2NodeRegistry.findKey(key);
        String nodeIpAddress;
        int nodePort;

        // key is stored on one of the nodes
        if (nodeId != -1) {
            nodeIpAddress = ec2NodeRegistry.getNodeInfo(nodeId).getNodeIpAddress();
            nodePort = ec2NodeRegistry.getNodeInfo(nodeId).getNodePort();

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
                logger.error("PUT_DATA request timed out for key=" + key);
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
        } else {
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


    // checks where to store the file and send to the client the IP address and port number of corresponding node
    public void putFileEndpoint(PutFileEndpointRequest clientRequest, StreamObserver<PutFileEndpointResponse> responseObserver) {

        // extract client request
        String fileName = clientRequest.getFileName();
        int fileSizeMb = clientRequest.getFileSizeMb();

        // select the node for storing file chunks
        // TODO -> improve & modify data placement technique
        int nodeId = lambdaNodeRegistry.dataPlacement(fileName, fileSizeMb);

        // extract ipAddress and nodePort for node
        String nodeIpAddress = lambdaNodeRegistry.getNodeInfo(nodeId).getNodeIpAddress();
        int nodePort = lambdaNodeRegistry.getNodeInfo(nodeId).getNodePort();

        logger.info("PUT_FILE_ENDPOINT request: fileName=" + fileName + "|fileSizeMb=" + fileSizeMb + "|ipAddress=" + nodeIpAddress + "|port=" + nodePort);

        // package data for client response
        PutFileEndpointResponse.Builder clientResponse = PutFileEndpointResponse.
                newBuilder().
                setNodeIpAddress(nodeIpAddress).
                setNodePort(nodePort);

        // send response to the client
        responseObserver.onNext(clientResponse.build());
        responseObserver.onCompleted();
    }


    @Override
    public void getFileEndpoint(GetFileEndpointRequest request, StreamObserver<GetFileEndpointResponse> responseObserver) {
        // TODO -> check what nodes store the file chunks
        // TODO -> return an array of node IP addresses, node ports, and chunk numbers
        // TODO -> order by chunk number (because it may happen that not all chunks are stored on a single node)
    }


    // add keys stored to Lambda cache node to the Lambda node registry for corresponding node id
    @Override
    public void putKeys(PutKeysRequest request, StreamObserver<PutKeysResponse> responseObserver) {
        // extract request information from Lambda cache node
        int nodeId = request.getNodeId();
        Set<String> keys = new HashSet<>(request.getKeysList());

        // TODO -> handle chunk numbers (MAYBE DELETE CHUNK NUMBER AS IT IS NOT NECESSARY ???)
        // store filenames to lambda registry
        for (String key : keys) {
            lambdaNodeRegistry.getNodeInfo(nodeId).putKey(key, 0); // TODO -> chunk number is not needed ??
        }

        // TODO -> DEBUG (print all keys)
        lambdaNodeRegistry.printKeys();

        // package response
        PutKeysResponse response = PutKeysResponse
                .newBuilder()
                .setResponseCode(200)
                .setResponseMessage("Keys successfully registered with master node.")
                .build();

        // send response back to Lambda cache node
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    // delete keys deleted from Lambda cache node from Lambda node registry for corresponding node id
    @Override
    public void deleteKeys(DeleteKeysRequest request, StreamObserver<DeleteKeysResponse> responseObserver) {
        // extract request information from Lambda cache node
        int nodeId = request.getNodeId();
        Set<String> keys = new HashSet<>(request.getKeysList());

        // TODO -> handle chunk numbers (MAYBE DELETE CHUNK NUMBER AS IT IS NOT NECESSARY ???)
        // delete filenames from lambda registry
        for (String key : keys) {
            lambdaNodeRegistry.getNodeInfo(nodeId).deleteKey(key);
        }

        // TODO -> DEBUG (print all keys)
        lambdaNodeRegistry.printKeys();

        // package response
        DeleteKeysResponse response = DeleteKeysResponse
                .newBuilder()
                .setResponseCode(200)
                .setResponseMessage("Keys successfully deleted from master node.")
                .build();

        // send response back to Lambda cache node
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    // handles initial handshake from each node and initializes the node
    @Override
    public void nodeHandshake(NodeHandshakeRequest request, StreamObserver<NodeHandshakeResponse> responseObserver) {
        // extract request information from node
        String nodeIpAddress = request.getNodeIpAddress();
        int nodePort = request.getNodePort();
        String nodeType = request.getNodeType();

        // prepared for response
        int nodeId = 0;
        int responseCode = 400;
        String responseMessage = "Failed to initialize new node - unrecognized instance type";

        // init EC2 cache node
        if (nodeType.equalsIgnoreCase("EC2")) {
            logger.info("Handshake EC2 request");
            nodeId = ec2NodeRegistry.initStorageNode(nodeIpAddress, nodePort);
            responseCode = 200;
            responseMessage = "Successfully initialized new EC2 cache node";
        }
        // init Lambda cache node
        else if (nodeType.equalsIgnoreCase("Lambda")) {
            logger.info("Handshake Lambda request");
            nodeId = lambdaNodeRegistry.initStorageNode(nodeIpAddress, nodePort);
            responseCode = 200;
            responseMessage = "Successfully initialized new Lambda cache node";
        }
        // failed to initialize cache node
        else {
            logger.info("Handshake request - not recognized instance type");
        }

        // package response
        NodeHandshakeResponse response = NodeHandshakeResponse
                .newBuilder()
                .setNodeId(nodeId)
                .setResponseCode(responseCode)
                .setResponseMessage(responseMessage)
                .build();

        // send response back to the node
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
