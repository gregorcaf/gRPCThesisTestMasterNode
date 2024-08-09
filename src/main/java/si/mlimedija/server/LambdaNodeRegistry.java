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
//        return nodeCount;
        return lambdaNodeInfoMap.size();
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
            HashMap<String, Integer> storedKeys = entry.getValue().getKeys();

            if (storedKeys.containsKey(key)) {
                return nodeId;
            }
        }
        return -1;
    }

    // prints all keys for each Lambda storage node
    public void printKeys() {
        int nodeId;
        String keys;
        logger.info("Print all Lambda keys:");

        for (Map.Entry<Integer, StorageNodeInfo> entry : lambdaNodeInfoMap.entrySet()) {
            nodeId = entry.getKey();
            keys = entry.getValue().getKeys().toString();
            logger.info("nodeId=" + nodeId + "|keys=" + keys);
        }
    }

    // TODO -> for distributed use case (more than 1 storage node)
    // returns id of storage node to which we put data
    public int dataPlacement(String fileName, int fileSizeMb) {

        // TODO -> check if the size of file would fit to the node
        // round-robin
        addIter(1);
        return ((getIter() % getNodeCount()) + 1);
    }


    // initializes Lambda storage node
    public int initStorageNode(String nodeIpAddress, int nodePort) {
        // extract information for node init
        HashMap<String, Integer> keys = new HashMap<>();
        Boolean isHealthy = true;
        int mapSize = 0;
        int cpuUtilization = 0;
        int nodeId = getNodeCount();

        // create a Lambda cache node
        StorageNodeInfo node = new StorageNodeInfo(nodeId, nodeIpAddress, nodePort, keys, isHealthy, mapSize, cpuUtilization);

        // add Lambda cache node to Lambda registry
        addOrUpdateNodeInfo(nodeId, node);

        logger.info("Initialized new Lambda storage node");
        logger.info("nodeId=" + nodeId + "|nodeIpAddress=" + nodeIpAddress + "|nodePort=" + nodePort);

        // return node id
        return nodeId;
    }

    // performs search for nodes storing specific filenames
    public Map<Integer, String> findOrderedFileLocations(String filename) {
        String prefix = filename + ":";
        Map<Integer, String> chunkIpMap = new TreeMap<>(); // treemap for automatically sorting by chunk number

        // iterate over nodes in Lambda node registry
        for (Map.Entry<Integer, StorageNodeInfo> entry : lambdaNodeInfoMap.entrySet()) {
            StorageNodeInfo nodeInfo = entry.getValue();
            HashMap<String, Integer> storedKeys = nodeInfo.getKeys();

            // iterate over stored keys
            for (Map.Entry<String, Integer> keyEntry : storedKeys.entrySet()) {
                String key = keyEntry.getKey();
                Integer chunkNumber = keyEntry.getValue();

                // check if prefix matches
                if (key.startsWith(prefix)) {
                    // put chunk number and IP address to the hashmap
                    chunkIpMap.put(chunkNumber, nodeInfo.getNodeIpAddress());
                }
            }
        }
        // return the map of chunk numbers and corresponding IP addresses
        return chunkIpMap;
    }
}







