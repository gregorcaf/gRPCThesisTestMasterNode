package si.mlimedija.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LambdaNodeRegistry {
    private static final Logger logger = LoggerFactory.getLogger(LambdaNodeRegistry.class.getSimpleName());

    private ConcurrentHashMap<Integer, StorageNodeInfo> lambdaNodeInfoMap;
    int iter; // increases with every put call (round-robin data placement technique)
    int nodeCount; // keeps track of how many nodes are active TODO -> add/remove nodes if failure is detected

    public LambdaNodeRegistry() {
        this.lambdaNodeInfoMap = new ConcurrentHashMap<>();
        this.iter = 0;
        this.nodeCount = 0;
    }

    // get map with information about all Lambda storage nodes
    public Map<Integer, StorageNodeInfo> getAllNodeInfo() {
        return lambdaNodeInfoMap;
    }

    // add new node or update existing Lambda storage node
    public void addOrUpdateNodeInfo(int nodeId, StorageNodeInfo storageNodeInfo) {
        lambdaNodeInfoMap.put(nodeId, storageNodeInfo);
    }

    // removes Lambda storage node for given nodeId from map
    public void removeNode(int nodeId) {
        lambdaNodeInfoMap.remove(nodeId);
    }

    // returns Lambda storage node
    public StorageNodeInfo getNodeInfo(int nodeId) {
        return lambdaNodeInfoMap.get(nodeId);
    }

    public int getIter() {
        return iter;
    }

    public void addIter(int num) {
        this.iter = this.iter + num;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

    // TODO -> modify so we can search also by ctr+f approach
    // iterates through Lambda storage nodes and checks which Lambda node stores given key, returns nodeId, otherwise -1
    public int findKey(String key) {
        int nodeId;

        for (Map.Entry<Integer, StorageNodeInfo> entry : lambdaNodeInfoMap.entrySet()) {
            nodeId = entry.getKey();
            HashSet<String> storedKeys = entry.getValue().getKeys();

            if (storedKeys.contains(key)) {
                return nodeId;
            }
        }
        return -1;
    }

    // prints all keys for each Lambda storage node
    public void printKeys() {
        int nodeId;
        String keys;
        logger.debug("Print all Lambda keys:");

        for (Map.Entry<Integer, StorageNodeInfo> entry : lambdaNodeInfoMap.entrySet()) {
            nodeId = entry.getKey();
            keys = entry.getValue().getKeys().toString();
            logger.debug("nodeId=" + nodeId + "|keys=" + keys);
        }
    }

    // TODO -> for distributed use case (more than 1 storage node)
    // returns id of storage node to which we put data
    public int dataPlacement(String key) {

        // round-robin
        addIter(1);
        return ((getIter() % getNodeCount()) + 1);
    }

    // initializes the Lambda storage node instances and puts them to StorageNodeInfo
    public void initStorageNodes() {
        Map<Integer, String> nodeIpAddresses = readIpAddresses();
//        Map<String, Integer> nodeIpAddresses = readIpAddresses();
        int nodeCount = 0;

        logger.info("Started searching for Lambda storage nodes");

// TODO -> commented for testing purposes - duplication of IP addresses
// iterate through the map of ip addresses, create node instances, and put them to the StorageNodeInfo map
//        for (Map.Entry<String, Integer> entry : nodeIpAddresses.entrySet()) {
//            nodeCount++;
//            String nodeIpAddress = entry.getKey();
//            int nodePort = entry.getValue();
//            HashSet<String> keys = new HashSet<>();
//            Boolean isHealthy = true;
//            int mapSize = 0;
//            int cpuUtilization = 0;
//
//            StorageNodeInfo node = new StorageNodeInfo(nodeCount, nodeIpAddress, nodePort, keys, isHealthy, mapSize, cpuUtilization);
//            addOrUpdateNodeInfo(nodeCount, node);
//
//            logger.info("Found new storage node");
//            logger.info("nodeId=" + nodeCount + "|nodeIpAddress=" + nodeIpAddress + "|nodePort=" + nodePort);
//        }

        for (Map.Entry<Integer, String> entry : nodeIpAddresses.entrySet()) {
            nodeCount++;
            String nodeIpAddress = entry.getValue();
            int nodePort = entry.getKey();
            HashSet<String> keys = new HashSet<>();
            Boolean isHealthy = true;
            int mapSize = 0;
            int cpuUtilization = 0;

            StorageNodeInfo node = new StorageNodeInfo(nodeCount, nodeIpAddress, nodePort, keys, isHealthy, mapSize, cpuUtilization);
            addOrUpdateNodeInfo(nodeCount, node);

            logger.info("Found new Lambda storage node");
            logger.info("nodeId=" + nodeCount + "|nodeIpAddress=" + nodeIpAddress + "|nodePort=" + nodePort);
        }
        setNodeCount(nodeCount);

        if (nodeIpAddresses.isEmpty()) {
            logger.info("Did not found any Lambda storage nodes to initialize");
        } else {
            logger.info("Initialized " + nodeIpAddresses.size() + " Lambda storage nodes");
        }
    }

    // reads IP addresses of Lambda storage nodes when booting up
    // TODO => read from external storage (S3, DynamoDB)
    private static Map<Integer, String> readIpAddresses() {
        Map<Integer, String> ipAddresses = new HashMap<>();
        ipAddresses.put(9080, "localhost");
//        ipAddresses.put(9081, "127.0.0.1");
//        ipAddresses.put(9082, "127.0.0.1");
        return ipAddresses;
    }
}
