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
        // create storage registry for EC2 and Lambda
        EC2NodeRegistry ec2NodeRegistry = new EC2NodeRegistry();
        LambdaNodeRegistry lambdaNodeRegistry = new LambdaNodeRegistry();

        MasterService masterService = new MasterService(ec2NodeRegistry, lambdaNodeRegistry);
        HealthChecker healthChecker = new HealthChecker(ec2NodeRegistry, lambdaNodeRegistry);

        Server server = ServerBuilder.forPort(9090)
                .addService(masterService)
                .maxInboundMessageSize(16 * 1024 * 1024) // set max inbound message size to 16 MB
                .build();

        logger.info("Starting gRPC server");

        server.start();

        String ipAddress = getIpAddress();
        logger.info("Server started at " + ipAddress + ":" + server.getPort());

        // initializes EC2 and Lambda storage nodes
        ec2NodeRegistry.initStorageNodes();
        lambdaNodeRegistry.initStorageNodes();

        // periodical health checks - 5 threads, every 5 seconds
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.scheduleAtFixedRate(() -> {
            try {
                healthChecker.updateAllNodeInfo();
            } catch (Exception e) {
                logger.error("Error during health check: " + e.getMessage());
            }
        }, 0, 10, TimeUnit.SECONDS);

        server.awaitTermination();
    }

    // retrieves the IP address of the running server instance
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
