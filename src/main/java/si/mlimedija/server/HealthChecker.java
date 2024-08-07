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

    private EC2NodeRegistry ec2NodeRegistry;
    private LambdaNodeRegistry lambdaNodeRegistry;

    public HealthChecker(EC2NodeRegistry ec2NodeRegistry, LambdaNodeRegistry lambdaNodeRegistry) {
        this.ec2NodeRegistry = ec2NodeRegistry;
        this.lambdaNodeRegistry = lambdaNodeRegistry;
    }

    public void updateAllNodeInfo() {
        updateNodeInfo(ec2NodeRegistry);
        updateNodeInfo(lambdaNodeRegistry);
    }

    private void updateNodeInfo(Object registry) {
        Map<Integer, StorageNodeInfo> allNodeInfo;

        if (registry instanceof EC2NodeRegistry) {
            allNodeInfo = ((EC2NodeRegistry) registry).getAllNodeInfo();
        } else {
            allNodeInfo = ((LambdaNodeRegistry) registry).getAllNodeInfo();
        }

        for (Map.Entry<Integer, StorageNodeInfo> entry : allNodeInfo.entrySet()) {
            StorageNodeInfo nodeInfo = entry.getValue();
            int nodeId = nodeInfo.getNodeId();
            String nodeIpAddress = nodeInfo.getNodeIpAddress();
            int nodePort = nodeInfo.getNodePort();
            updateNodeInfoAsync(registry, nodeId, nodeIpAddress, nodePort); // call updateNodeInfoAsync for each node
        }
    }

    // TODO => remove node if unhealthy
    // TODO => detect that node has disconnected (request timeout)
    private CompletableFuture<Void> updateNodeInfoAsync(Object registry, int nodeId, String nodeIpAddress, int nodePort) {
        return CompletableFuture.runAsync(() -> {

            if (registry instanceof EC2NodeRegistry) {
                logger.info("GET_EC2_NODE_INFO request: nodeId=" + nodeId + "|nodeIpAddress=" + nodeIpAddress + "|nodePort=" + nodePort);
            } else {
                logger.info("GET_LAMBDA_NODE_INFO request: nodeId=" + nodeId + "|nodeIpAddress=" + nodeIpAddress + "|nodePort=" + nodePort);
            }

            // gPRC call to corresponding storage node
            ManagedChannel channel = ManagedChannelBuilder.forAddress(nodeIpAddress, nodePort).usePlaintext().build();

            try {
                nodeInfoGrpc.nodeInfoBlockingStub nodeInfoStub = nodeInfoGrpc.newBlockingStub(channel);

                // package data for node request
                NodeInfoRequest request = NodeInfoRequest.newBuilder().setNodeId(nodeId).setNodeIpAddress(nodeIpAddress).setNodePort(nodePort).build();

                // retrieve response from the node
                NodeInfoResponse response = nodeInfoStub.getNodeInfo(request);

                // TODO => remove node from map if it is unhealthy

                if (registry instanceof EC2NodeRegistry) {
                    // update EC2 storage node's health status and cache size
                    ((EC2NodeRegistry) registry).getNodeInfo(nodeId).setHealthy(response.getIsHealthy());
                    ((EC2NodeRegistry) registry).getNodeInfo(nodeId).setMapSize(response.getMapSize());
                    logger.info("GET_EC2NODE_INFO response: nodeId=" + nodeId + "|nodeIpAddress=" + nodeIpAddress + "|nodePort=" + nodePort + "|isHealthy=" + response.getIsHealthy() + "|mapSizeMb=" + response.getMapSize());
                } else {
                    // update Lambda storage node's health status and cache size
                    ((LambdaNodeRegistry) registry).getNodeInfo(nodeId).setHealthy(response.getIsHealthy());
                    ((LambdaNodeRegistry) registry).getNodeInfo(nodeId).setMapSize(response.getMapSize());
                    logger.info("GET_LAMBDA_INFO response: nodeId=" + nodeId + "|nodeIpAddress=" + nodeIpAddress + "|nodePort=" + nodePort + "|isHealthy=" + response.getIsHealthy() + "|mapSizeMb=" + response.getMapSize() * 4);
                }
            } finally {
                // shutdown the channel when done
                channel.shutdown();
            }
        });
    }
}
