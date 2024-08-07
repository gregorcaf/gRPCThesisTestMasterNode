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
//        return nodeCount;
        return ec2NodeInfoMap.size();
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


    // initializes EC2 storage node
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

        logger.info("Initialized new EC2 storage node");
        logger.info("nodeId=" + nodeId + "|nodeIpAddress=" + nodeIpAddress + "|nodePort=" + nodePort);

        // return node id
        return nodeId;
    }
}
