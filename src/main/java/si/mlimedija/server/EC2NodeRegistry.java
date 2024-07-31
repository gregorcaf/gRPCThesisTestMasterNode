package si.mlimedija.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class EC2NodeRegistry {

    private static final Logger logger = LoggerFactory.getLogger(EC2NodeRegistry.class.getSimpleName());

    private ConcurrentHashMap<Integer, StorageNodeInfo> ec2NodeInfoMap;
    int iter; // increases with every put call (round-robin data placement technique)
    int nodeCount; // keeps track of how many nodes are active TODO -> add/remove nodes if failure is detected

    public EC2NodeRegistry() {
        this.ec2NodeInfoMap = new ConcurrentHashMap<>();
        this.iter = 0;
        this.nodeCount = 0;
    }

    // get map with information about all EC2 storage nodes
    public Map<Integer, StorageNodeInfo> getAllNodeInfo() {
        return ec2NodeInfoMap;
    }

    // add new node or update existing EC2 storage node
    public void addOrUpdateNodeInfo(int nodeId, StorageNodeInfo storageNodeInfo) {
        ec2NodeInfoMap.put(nodeId, storageNodeInfo);
    }

    // removes EC2 storage node for given nodeId from map
    public void removeNode(int nodeId) {
        ec2NodeInfoMap.remove(nodeId);
    }

    // returns EC2 storage node
    public StorageNodeInfo getNodeInfo(int nodeId) {
        return ec2NodeInfoMap.get(nodeId);
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

    // iterates through EC2 storage nodes and checks which EC2 node stores given key, returns nodeId, otherwise -1
    public int findKey(String key) {
        int nodeId;

        for (Map.Entry<Integer, StorageNodeInfo> entry : ec2NodeInfoMap.entrySet()) {
            nodeId = entry.getKey();
            HashMap<String, Integer> storedKeys = entry.getValue().getKeys();

            if (storedKeys.containsKey(key)) {
                return nodeId;
            }
        }
        return -1;
    }

    // prints all keys for each EC2 storage node
    public void printKeys() {
        int nodeId;
        String keys;
        logger.debug("Print all EC2 keys:");

        for (Map.Entry<Integer, StorageNodeInfo> entry : ec2NodeInfoMap.entrySet()) {
            nodeId = entry.getKey();
            keys = entry.getValue().getKeys().toString();
            logger.debug("nodeId=" + nodeId + "|keys=" + keys);
        }
    }

    // TODO -> for distributed case (more than 1 node)
    // returns id of storage node to which we put data
    public int dataPlacement(String key) {

        // round-robin
        addIter(1);
        return ((getIter() % getNodeCount()) + 1);
    }

    // initializes the EC2 storage node instances and puts them to StorageNodeInfo
    public void initStorageNodes() {
        Map<Integer, String> nodeIpAddresses = readIpAddresses();
//        Map<String, Integer> nodeIpAddresses = readIpAddresses();
        int nodeCount = 0;

        logger.info("Started searching for EC2 storage nodes");

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
            HashMap<String, Integer> keys = new HashMap<>();
            Boolean isHealthy = true;
            int mapSize = 0;
            int cpuUtilization = 0;

            StorageNodeInfo node = new StorageNodeInfo(nodeCount, nodeIpAddress, nodePort, keys, isHealthy, mapSize, cpuUtilization);
            addOrUpdateNodeInfo(nodeCount, node);

            logger.info("Found new EC2 storage node");
            logger.info("nodeId=" + nodeCount + "|nodeIpAddress=" + nodeIpAddress + "|nodePort=" + nodePort);
        }
        setNodeCount(nodeCount);

        if (nodeIpAddresses.isEmpty()) {
            logger.info("Did not found any EC2 storage nodes to initialize");
        } else {
            logger.info("Initialized " + nodeIpAddresses.size() + " EC2 storage nodes");
        }
    }


    // reads IP addresses of EC2 storage nodes when booting up
    // TODO => read from external storage (S3, DynamoDB)
    private static Map<Integer, String> readIpAddresses() {
        Map<Integer, String> ipAddresses = new HashMap<>();
//        ipAddresses.put(9070, "localhost");
//        ipAddresses.put(9071, "127.0.0.1");
//        ipAddresses.put(9072, "127.0.0.1");
        return ipAddresses;
    }


}
