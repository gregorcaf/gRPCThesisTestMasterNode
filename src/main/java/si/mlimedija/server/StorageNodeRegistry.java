package si.mlimedija.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StorageNodeRegistry {

    private static final Logger logger = LoggerFactory.getLogger(StorageNodeRegistry.class.getSimpleName());

    private ConcurrentHashMap<Integer, StorageNodeInfo> nodeInfoMap;

    // increases with every put call (round-robin data placement technique)
    private int iter;

    // keeps track of how many nodes are active
    // TODO => add/remove nodes if failure is detected
    private int nodeCount;

    public StorageNodeRegistry() {
        this.nodeInfoMap = new ConcurrentHashMap<>();
        this.iter = 0;
        this.nodeCount = 0;
    }

    // get map with information about all nodes
    public Map<Integer, StorageNodeInfo> getAllNodeInfo() {
        return nodeInfoMap;
    }

    // add new node or update existing node
    public void addOrUpdateNodeInfo(int nodeId, StorageNodeInfo storageNodeInfo) {
        nodeInfoMap.put(nodeId, storageNodeInfo);
    }

    // removes node for given nodeId from map
    public void removeNode(int nodeId) {
        nodeInfoMap.remove(nodeId);
    }

    // returns node
    public StorageNodeInfo getNodeInfo(int nodeId) {
        return nodeInfoMap.get(nodeId);
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

    // iterates through nodes and checks which node stores given key, returns nodeId, otherwise -1
    public int findKey(String key) {
        logger.info("findKey method called");
        int nodeId;

        // TODO => print is only for testing purposes
        printKeys();

        for (Map.Entry<Integer, StorageNodeInfo> entry : nodeInfoMap.entrySet()) {
            nodeId = entry.getKey();
            HashSet<String> storedKeys = entry.getValue().getKeys();

            if (storedKeys.contains(key)) {
                return nodeId;
            }
        }
        return -1;
    }

    // prints all keys for each storage node
    public void printKeys() {
        int nodeId;
        String keys;
        logger.info("Print all keys:");

        for (Map.Entry<Integer, StorageNodeInfo> entry : nodeInfoMap.entrySet()) {
            nodeId = entry.getKey();
            keys = entry.getValue().getKeys().toString();
            logger.info("nodeId=" + nodeId + "|keys=" + keys);
        }
    }

    // TODO -> for distributed use case (more than 1 storage node)
    // performs analysis of all storage nodes and determines on which node would it be the best to store new <key,value> pair
    // returns id of storage node to which we put data
    public int dataPlacement(String key) {

        // round-robin
        addIter(1);
        return ((getIter() % getNodeCount()) + 1);
    }

    // initializes the node instances and puts them to StorageNodeInfo
    public void initStorageNodes() {
        Map<String, Integer> nodeIpAddresses = readIpAddresses();
        int nodeCount = 0;

        logger.info("Started searching for storage nodes");

        // iterate through the map of ip addresses, create node instances, and put them to the StorageNodeInfo map
        for (Map.Entry<String, Integer> entry : nodeIpAddresses.entrySet()) {
            nodeCount++;
            String nodeIpAddress = entry.getKey();
            int nodePort = entry.getValue();
            HashSet<String> keys = new HashSet<>();
            Boolean isHealthy = true;
            int mapSize = 0;
            int cpuUtilization = 0;

            StorageNodeInfo node = new StorageNodeInfo(nodeCount, nodeIpAddress, nodePort, keys, isHealthy, mapSize, cpuUtilization);
            addOrUpdateNodeInfo(nodeCount, node);

            logger.info("Found new storage node");
            logger.info("nodeId=" + nodeCount + "|nodeIpAddress=" + nodeIpAddress + "|nodePort=" + nodePort);
        }
        setNodeCount(nodeCount);
        logger.info("Initialized " + nodeIpAddresses.size() + " storage nodes");
    }


    // reads IP addresses when booting up
    // TODO => read from external storage (S3, DynamoDB)
    // TODO => handle key duplication
    private static Map<String, Integer> readIpAddresses() {
        Map<String, Integer> ipAddresses = new HashMap<>();
        ipAddresses.put("192.168.1.248", 9070);
        ipAddresses.put("localhost", 9071);
        return ipAddresses;
    }
}
