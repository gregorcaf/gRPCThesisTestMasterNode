package si.mlimedija.server;

import java.util.HashSet;

// this class is used to hold information about individual node
public class StorageNodeInfo {
    private int nodeId;
    private String nodeIpAddress;
    private int nodePort;
    private HashSet<String> keys;
    private boolean isHealthy;
    private int mapSize;
    private int cpuUtilization;

    public StorageNodeInfo(int nodeId, String nodeIpAddress, int nodePort, HashSet<String> keys, boolean isHealthy, int mapSize, int cpuUtilization) {
        this.nodeId = nodeId;
        this.nodeIpAddress = nodeIpAddress;
        this.nodePort = nodePort;
        this.keys = keys;
        this.isHealthy = isHealthy;
        this.mapSize = mapSize;
        this.cpuUtilization = cpuUtilization;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeIpAddress() {
        return nodeIpAddress;
    }

    public void setNodeIpAddress(String nodeIpAddress) {
        this.nodeIpAddress = nodeIpAddress;
    }

    public int getNodePort() {
        return nodePort;
    }

    public void setNodePort(int nodePort) {
        this.nodePort = nodePort;
    }

    public HashSet<String> getKeys() {
        return keys;
    }

    public void setKeys(HashSet<String> keys) {
        this.keys = keys;
    }

    public void putKey(String key) {
        this.keys.add(key);
    }

    @Override
    public String toString() {
        return "keys=" + keys;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public int getCpuUtilization() {
        return cpuUtilization;
    }

    public void setCpuUtilization(int cpuUtilization) {
        this.cpuUtilization = cpuUtilization;
    }
}


