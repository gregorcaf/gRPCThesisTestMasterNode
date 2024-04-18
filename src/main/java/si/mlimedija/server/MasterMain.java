package si.mlimedija.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import si.mlimedija.service.MasterService;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO list:
 *  - putKey() method in the StorageNodeRegistry()
 *  - remove redundant nodeId from gRPC body when making putData and getData requests
 */

public class MasterMain {

    private static final Logger logger = LoggerFactory.getLogger(MasterMain.class.getSimpleName());

    public static void main(String[] args) throws IOException, InterruptedException {

        // create instance of storageNodeRegistry and search for all storage nodes
        StorageNodeRegistry storageNodeRegistry = new StorageNodeRegistry();

        MasterService masterService = new MasterService(storageNodeRegistry);

        Server server = ServerBuilder.forPort(9090).addService(masterService).build();

        logger.info("Starting gRPC server");

        server.start();

        logger.info("Server started at localhost:" + server.getPort());

        // iterates through IP addresses and initialized nodes in the list
        storageNodeRegistry.initStorageNodes();

        server.awaitTermination();
    }
}
