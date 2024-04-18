package si.mlimedija.service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.mlimedija.proto.*;
import si.mlimedija.server.StorageNodeRegistry;


// This class is responsible for sending/retrieving data to/from storage nodes with gRPC calls
public class MasterService extends masterGrpc.masterImplBase {

    private static final Logger logger = LoggerFactory.getLogger(MasterService.class.getSimpleName());

    private StorageNodeRegistry storageNodeRegistry;

    public MasterService(StorageNodeRegistry storageNodeRegistry) {
        this.storageNodeRegistry = storageNodeRegistry;
    }

    @Override
    public void putData(PutDataRequest clientRequest, StreamObserver<PutDataResponse> responseObserver) {

        // extract client request
        int nodeId = clientRequest.getNodeId();
        String key = clientRequest.getKey();
        String value = clientRequest.getValue();

        // TODO => data placement logic based on key (get info from StorageNodeInfo class)

        storageNodeRegistry.getNodeInfo(1).putKey(key);


        logger.info("PUT_DATA request: nodeId=" + nodeId + "|key=" + key + "|value=" + value);

        // gRPC call to storage node
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9070).usePlaintext().build();
        storageGrpc.storageBlockingStub storageStub = storageGrpc.newBlockingStub(channel);

        // package data for node request
        PutDataNodeRequest nodeRequest = PutDataNodeRequest.newBuilder().setNodeId(nodeId).setKey(key).setValue(value).build();

        // // retrieve response from node response from node
        PutDataNodeResponse nodeResponse = storageStub.putDataNode(nodeRequest);

        // package response for client
        PutDataResponse.Builder clientResponse = PutDataResponse.newBuilder();
        clientResponse.setKey(nodeResponse.getKey());
        clientResponse.setResponseCode(nodeResponse.getResponseCode());
        clientResponse.setResponseMessage(nodeResponse.getResponseMessage());

        responseObserver.onNext(clientResponse.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getData(GetDataRequest clientRequest, StreamObserver<GetDataResponse> responseObserver) {

        // extract client request
        int nodeId = clientRequest.getNodeId();
        String key = clientRequest.getKey();

        // for storing node information
        String nodeIpAddress;
        int nodePort;


        // TODO => data retrieval logic based on key (get info from StorageNodeInfo class)
        int storageNodeId = storageNodeRegistry.findKey(key);

        logger.info("GET_DATA request: nodeId=" + nodeId + "|key=" + key);


        // key is stored on one of the nodes
        if (storageNodeId != -1) {
            nodeIpAddress = storageNodeRegistry.getNodeInfo(storageNodeId).getNodeIpAddress();
            nodePort = storageNodeRegistry.getNodeInfo(storageNodeId).getNodePort();

            logger.info("Key=" + key + " is stored on storageNodeId=" + storageNodeId);

            // gRPC call to storage node
            ManagedChannel channel = ManagedChannelBuilder.forAddress(nodeIpAddress, nodePort).usePlaintext().build();
//            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9070).usePlaintext().build();
            storageGrpc.storageBlockingStub storageStub = storageGrpc.newBlockingStub(channel);

            // package data for node request
            GetDataNodeRequest nodeRequest = GetDataNodeRequest.newBuilder().setNodeId(nodeId).setKey(key).build();

            // retrieve response from node
            GetDataNodeResponse nodeResponse = storageStub.getDataNode(nodeRequest);

            // package response for client
            GetDataResponse.Builder clientResponse = GetDataResponse.newBuilder();
            clientResponse.setKey(nodeResponse.getKey());
            clientResponse.setValue(nodeResponse.getValue());
            clientResponse.setResponseCode(nodeResponse.getResponseCode());
            clientResponse.setResponseMessage(nodeResponse.getResponseMessage());

            responseObserver.onNext(clientResponse.build());
            responseObserver.onCompleted();
        }
        // key is not store on one of the nodes
        else {
            logger.info("Key=" + key + " doesn't exists");
        }
    }
}
