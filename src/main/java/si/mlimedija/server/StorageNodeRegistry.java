package si.mlimedija.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StorageNodeRegistry {

    private static final Logger logger = LoggerFactory.getLogger(StorageNodeRegistry.class.getSimpleName());

    private ConcurrentHashMap<Integer, StorageNodeInfo> ec2NodeInfoMap;
    private ConcurrentHashMap<Integer, StorageNodeInfo> lambdaNodeInfoMap;

    // increases with every put call (round-robin data placement technique)
    private int iter;

    // keeps track of how many nodes are active
    // TODO => add/remove nodes if failure is detected
    private int nodeCount;

    public StorageNodeRegistry() {
        this.ec2NodeInfoMap = new ConcurrentHashMap<>();
        this.lambdaNodeInfoMap = new ConcurrentHashMap<>();
        this.iter = 0;
        this.nodeCount = 0;
    }

    // get map with information about all EC2 storage nodes
    public Map<Integer, StorageNodeInfo> getAllEC2NodeInfo() {
        return ec2NodeInfoMap;
    }

    // get map with information about all Lambda storage nodes
    public Map<Integer, StorageNodeInfo> getAllLambdaNodeInfo() {
        return lambdaNodeInfoMap;
    }

    // add new node or update existing EC2 storage node
    public void addOrUpdateEC2NodeInfo(int nodeId, StorageNodeInfo storageNodeInfo) {
        ec2NodeInfoMap.put(nodeId, storageNodeInfo);
    }

    // add new node or update existing Lambda storage node
    public void addOrUpdateLambdaNodeInfo(int nodeId, StorageNodeInfo storageNodeInfo) {
        lambdaNodeInfoMap.put(nodeId, storageNodeInfo);
    }

    // removes EC2 storage node for given nodeId from map
    public void removeEC2Node(int nodeId) {
        ec2NodeInfoMap.remove(nodeId);
    }

    // removes Lambda storage node for given nodeId from map
    public void removeLambdaNode(int nodeId) {
        lambdaNodeInfoMap.remove(nodeId);
    }

    // returns EC2 storage node
    public StorageNodeInfo getEC2NodeInfo(int nodeId) {
        return ec2NodeInfoMap.get(nodeId);
    }

    // returns Lambda storage node
    public StorageNodeInfo getLambdaNodeInfo(int nodeId) {
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

    // iterates through EC2 storage nodes and checks which EC2 node stores given key, returns nodeId, otherwise -1
    public int findEC2Key(String key) {
        int nodeId;

        for (Map.Entry<Integer, StorageNodeInfo> entry : ec2NodeInfoMap.entrySet()) {
            nodeId = entry.getKey();
            HashSet<String> storedKeys = entry.getValue().getKeys();

            if (storedKeys.contains(key)) {
                return nodeId;
            }
        }
        return -1;
    }

    // TODO -> modify so we can search also by ctr+f approach
    // iterates through Lambda storage nodes and checks which Lambda node stores given key, returns nodeId, otherwise -1
    public int findLambdaKey(String key) {
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

    // prints all keys for each EC2 storage node
    public void printEC2Keys() {
        int nodeId;
        String keys;
        logger.debug("EC2 Print all keys:");

        for (Map.Entry<Integer, StorageNodeInfo> entry : ec2NodeInfoMap.entrySet()) {
            nodeId = entry.getKey();
            keys = entry.getValue().getKeys().toString();
            logger.debug("nodeId=" + nodeId + "|keys=" + keys);
        }
    }

    // prints all keys for each EC2 storage node
    public void printLambdaKeys() {
        int nodeId;
        String keys;
        logger.debug("Lambda Print all keys:");

        for (Map.Entry<Integer, StorageNodeInfo> entry : lambdaNodeInfoMap.entrySet()) {
            nodeId = entry.getKey();
            keys = entry.getValue().getKeys().toString();
            logger.debug("nodeId=" + nodeId + "|keys=" + keys);
        }
    }

    // TODO -> modify for different use cases (Lambda vs EC2)
    // TODO -> for distributed use case (more than 1 storage node)
    // performs analysis of all storage nodes and determines on which node would it be the best to store new <key,value> pair
    // returns id of storage node to which we put data
    public int dataPlacement(String key) {

        // round-robin
        addIter(1);
        return ((getIter() % getNodeCount()) + 1);
    }

    // initializes the EC2 storage node instances and puts them to StorageNodeInfo
    public void initStorageNodesEC2() {
        Map<Integer, String> nodeIpAddressesEC2 = readIpAddressesEC2();
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

        for (Map.Entry<Integer, String> entry : nodeIpAddressesEC2.entrySet()) {
            nodeCount++;
            String nodeIpAddress = entry.getValue();
            int nodePort = entry.getKey();
            HashSet<String> keys = new HashSet<>();
            Boolean isHealthy = true;
            int mapSize = 0;
            int cpuUtilization = 0;

            StorageNodeInfo node = new StorageNodeInfo(nodeCount, nodeIpAddress, nodePort, keys, isHealthy, mapSize, cpuUtilization);
            addOrUpdateEC2NodeInfo(nodeCount, node);

            logger.info("Found new EC2 storage node");
            logger.info("nodeId=" + nodeCount + "|nodeIpAddress=" + nodeIpAddress + "|nodePort=" + nodePort);
        }
        setNodeCount(nodeCount);
        logger.info("Initialized " + nodeIpAddressesEC2.size() + " EC2 storage nodes");
    }

    // initializes the Lambda storage node instances and puts them to StorageNodeInfo
    public void initStorageNodesLambda() {
        Map<Integer, String> nodeIpAddressesLambda = readIpAddressesLambda();
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

        for (Map.Entry<Integer, String> entry : nodeIpAddressesLambda.entrySet()) {
            nodeCount++;
            String nodeIpAddress = entry.getValue();
            int nodePort = entry.getKey();
            HashSet<String> keys = new HashSet<>();
            Boolean isHealthy = true;
            int mapSize = 0;
            int cpuUtilization = 0;

            StorageNodeInfo node = new StorageNodeInfo(nodeCount, nodeIpAddress, nodePort, keys, isHealthy, mapSize, cpuUtilization);
            addOrUpdateEC2NodeInfo(nodeCount, node);

            logger.info("Found new Lambda storage node");
            logger.info("nodeId=" + nodeCount + "|nodeIpAddress=" + nodeIpAddress + "|nodePort=" + nodePort);
        }
        setNodeCount(nodeCount);
        logger.info("Initialized " + nodeIpAddressesLambda.size() + " Lambda storage nodes");
    }


// reads IP addresses when booting up
// TODO => read from external storage (S3, DynamoDB)
    private static Map<Integer, String> readIpAddressesEC2() {
        Map<Integer, String> ipAddresses = new HashMap<>();
//        ipAddresses.put(9070, "127.0.0.1");
//        ipAddresses.put(9080, "127.0.0.1");
        return ipAddresses;
    }

    private static Map<Integer, String> readIpAddressesLambda() {
        Map<Integer, String> ipAddresses = new HashMap<>();
        ipAddresses.put(9080, "127.0.0.1");
//        ipAddresses.put(9080, "127.0.0.1");
        return ipAddresses;
    }

// commented for testing purposes - duplication of IP addresses
// key=String (IP address) and value=Integer (port)
//    private static Map<String, Integer> readIpAddresses() {
//        Map<String, Integer> ipAddresses = new HashMap<>();
//        ipAddresses.put("192.168.1.248", 9070);
//        return ipAddresses;
//    }
}
