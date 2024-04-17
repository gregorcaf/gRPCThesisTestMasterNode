package si.mlimedija.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import si.mlimedija.service.MasterService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO list:
 * 1) DONE => consider moving initStorageNodes() to the StorageNodeRegistry class
 * 2) create method that makes gRPC call getNodeInfo to all nodes (for each loop) and updates
 *    data in the map from received response => consider to do it in the StorageNodeRegistry class
 */



public class MasterMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9090).addService(new MasterService()).build();

        System.out.println("Starting gRPC server");

        server.start();

        System.out.println("Server started at localhost:" + server.getPort());

        // create instance of storageNodeRegistry and search for all storage nodes
        StorageNodeRegistry storageNodeRegistry = new StorageNodeRegistry();
        storageNodeRegistry.initStorageNodes();

        server.awaitTermination();
    }




}
