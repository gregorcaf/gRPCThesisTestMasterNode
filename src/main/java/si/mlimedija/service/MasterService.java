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
        String key = clientRequest.getKey();
        String value = clientRequest.getValue();

        // TODO => first check if key already exists and then update it at the same node

        // TODO => data placement logic based on key (get info from StorageNodeInfo class)
        int nodeId = storageNodeRegistry.dataPlacement(key); // => TODO modify dataPlacement(key) method -> currently returns constant number 1
        storageNodeRegistry.getNodeInfo(nodeId).putKey(key);
        String nodeIpAddress = storageNodeRegistry.getNodeInfo(nodeId).getNodeIpAddress();
        int nodePort = storageNodeRegistry.getNodeInfo(nodeId).getNodePort();

        logger.info("PUT_DATA request: key=" + key + "|value=" + value + "|nodeId=" + nodeId + "|ipAddress=" + nodeIpAddress + "|port=" + nodePort);

        // gRPC call to storage node
        ManagedChannel channel = ManagedChannelBuilder.forAddress(nodeIpAddress, nodePort).usePlaintext().build();

        try {
            storageGrpc.storageBlockingStub storageStub = storageGrpc.newBlockingStub(channel);

            // package data for node request
            PutDataNodeRequest nodeRequest = PutDataNodeRequest.newBuilder().setNodeId(nodeId).setKey(key).setValue(value).build();

            // retrieve response from node
            // TODO => handle request timeouts & unsuccessful data puts on the node (code 200 or 400)
            PutDataNodeResponse nodeResponse = storageStub.putDataNode(nodeRequest);

            // package response for client
            PutDataResponse.Builder clientResponse = PutDataResponse.newBuilder();
            clientResponse.setKey(nodeResponse.getKey());
            clientResponse.setResponseCode(nodeResponse.getResponseCode());
            clientResponse.setResponseMessage(nodeResponse.getResponseMessage());

            responseObserver.onNext(clientResponse.build());
            responseObserver.onCompleted();
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

            logger.info("GET_DATA request: key=" + key  + "|nodeId=" + nodeId + "|ipAddress=" + nodeIpAddress + "|port=" + nodePort);

            // gRPC call to storage node
            ManagedChannel channel = ManagedChannelBuilder.forAddress(nodeIpAddress, nodePort).usePlaintext().build();
            storageGrpc.storageBlockingStub storageStub = storageGrpc.newBlockingStub(channel);

            // package data for node request
            GetDataNodeRequest nodeRequest = GetDataNodeRequest.newBuilder().setNodeId(nodeId).setKey(key).build();

            // retrieve response from node
            // TODO => handle request timeouts & unsuccessful data retrievals from the node (code 200 or 400)
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
            logger.warn("GET_DATA request: could not retrieve key=" + key + " from cache");
        }
    }
}
