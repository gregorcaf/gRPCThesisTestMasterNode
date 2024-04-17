package si.mlimedija.service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import si.mlimedija.proto.*;


// This class is responsible for sending/retrieving data to/from storage nodes with gRPC calls
public class MasterService extends masterGrpc.masterImplBase {



    @Override
    public void putData(PutDataRequest clientRequest, StreamObserver<PutDataResponse> responseObserver) {

        // extract client request
        int nodeId = clientRequest.getNodeId();
        String key = clientRequest.getKey();
        String value = clientRequest.getValue();

        // TODO => data placement logic based on key (get info from StorageNodeInfo class)


        System.out.println("PUT_DATA request: nodeId=" + nodeId + "|key=" + key + "|value=" + value);

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


        // TODO => data retrieval logic based on key (get info from StorageNodeInfo class)


        System.out.println("GET_DATA request: nodeId=" + nodeId + "|key=" + key);

        // gRPC call to storage node
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9070).usePlaintext().build();
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
}
