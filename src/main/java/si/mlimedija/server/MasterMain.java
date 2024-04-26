package si.mlimedija.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import si.mlimedija.service.MasterService;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

        HealthChecker healthChecker = new HealthChecker(storageNodeRegistry);

        Server server = ServerBuilder.forPort(9090).addService(masterService).build();

        logger.info("Starting gRPC server");

        server.start();

        logger.info("Server started at " + getIpAddress() + ":" + server.getPort());

        // iterates through IP addresses and initialized nodes in the list
        storageNodeRegistry.initStorageNodes();

        // periodical health checks - 5 threads, every 5 seconds
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.scheduleAtFixedRate(() -> {
            try {
                healthChecker.updateAllNodeInfo();
            } catch (Exception e) {
                logger.error("Error during health check: " + e.getMessage());
            }
        }, 0, 5, TimeUnit.SECONDS);

        server.awaitTermination();
    }

    public static String getIpAddress() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            return address.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null; // Handle the error gracefully
        }
    }
}
