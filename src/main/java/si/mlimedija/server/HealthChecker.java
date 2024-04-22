package si.mlimedija.server;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.mlimedija.proto.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class HealthChecker {

    private static final Logger logger = LoggerFactory.getLogger(HealthChecker.class.getSimpleName());

    private StorageNodeRegistry storageNodeRegistry;

    public HealthChecker(StorageNodeRegistry storageNodeRegistry) {
        this.storageNodeRegistry = storageNodeRegistry;
    }

    public void updateAllNodeInfo() {
        // iterates through all nodes in the storageNodeRegistry, makes async gRPC calls, and updates their info
        for (Map.Entry<Integer, StorageNodeInfo> entry : storageNodeRegistry.getAllNodeInfo().entrySet()) {
            StorageNodeInfo nodeInfo = entry.getValue();
            int nodeId = nodeInfo.getNodeId();
            String nodeIpAddress = nodeInfo.getNodeIpAddress();
            int nodePort = nodeInfo.getNodePort();

            // call updateNodeInfoAsync for each node
            updateNodeInfoAsync(nodeId, nodeIpAddress, nodePort);
        }
    }

    // TODO => remove node if unhealthy
    // TODO => detect that node disconnected (request timeout)
    private CompletableFuture<Void> updateNodeInfoAsync(int nodeId, String nodeIpAddress, int nodePort) {
        return CompletableFuture.runAsync(() -> {

            logger.info("GET_NODE_INFO request: nodeId=" + nodeId + "|nodeIpAddress=" + nodeIpAddress + "|nodePort=" + nodePort);

            // gPRC call to storage node
            ManagedChannel channel = ManagedChannelBuilder.forAddress(nodeIpAddress, nodePort).usePlaintext().build();

            try {
                nodeInfoGrpc.nodeInfoBlockingStub nodeInfoStub = nodeInfoGrpc.newBlockingStub(channel);

                // package data for node request
                NodeInfoRequest request = NodeInfoRequest.newBuilder().setNodeId(nodeId).setNodeIpAddress(nodeIpAddress).setNodePort(nodePort).build();

                // retrieve response from the node
                NodeInfoResponse response = nodeInfoStub.getNodeInfo(request);

                // TODO => remove node from map if it is unhealthy

                // update node health status and cache size
                storageNodeRegistry.getNodeInfo(nodeId).setHealthy(response.getIsHealthy());
                storageNodeRegistry.getNodeInfo(nodeId).setMapSize(response.getMapSize());
                logger.info("GET_NODE_INFO response: nodeId=" + nodeId + "|nodeIpAddress=" + nodeIpAddress + "|nodePort=" + nodePort + "|isHealthy=" + response.getIsHealthy() + "|mapSize=" + response.getMapSize());
            } finally {
                // shutdown the channel when done
                channel.shutdown();
            }
        });
    }
}
