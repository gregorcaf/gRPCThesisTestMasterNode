package si.mlimedija.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StorageNodeRegistry {

    private ConcurrentHashMap<Integer, StorageNodeInfo> nodeInfoMap;

    public StorageNodeRegistry() {
        this.nodeInfoMap = new ConcurrentHashMap<>();
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


    // initializes the node instances and puts them to StorageNodeInfo
    public void initStorageNodes() {
        Map<Integer, String> nodeIpAddresses = readIpAddresses();

        System.out.println("Started searching for storage nodes");

        // iterate through the map of ip addresses, create node instances, and put them to the StorageNodeInfo map
        for (Map.Entry<Integer, String> entry : nodeIpAddresses.entrySet()) {
            int nodeId = entry.getKey();
            String nodeIpAddress = entry.getValue();
            List<String> keys = new ArrayList<>();
            Boolean isHealthy = true;
            int mapSize = 0;
            int cpuUtilization = 0;

            StorageNodeInfo node = new StorageNodeInfo(nodeId, nodeIpAddress, keys, isHealthy, mapSize, cpuUtilization);
            addOrUpdateNodeInfo(nodeId, node);

            System.out.println("Found new storage node");
            System.out.println("nodeId=" + nodeId +  "|nodeIpAddress=" + nodeIpAddress);
        }

        System.out.println("Initialized " + nodeIpAddresses.size() + " storage nodes");
    }


    // reads IP addresses when booting up
    // TODO => read from external storage (S3, DynamoDB)
    private static Map<Integer, String> readIpAddresses() {
        Map<Integer, String> ipAddresses = new HashMap<>();
        ipAddresses.put(1, "131.159.205.63");

        return ipAddresses;
    }
}
