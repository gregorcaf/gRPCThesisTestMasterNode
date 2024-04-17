package si.mlimedija.server;

import java.util.List;

// this class is used to hold information about individual node
public class StorageNodeInfo {
    private int nodeId;
    private String nodeIpAddress;
    private List<String> keys;
    private boolean isHealthy;
    private int mapSize;
    private int cpuUtilization;

    public StorageNodeInfo(int nodeId, String nodeIpAddress, List<String> keys, boolean isHealthy, int mapSize, int cpuUtilization) {
        this.nodeId = nodeId;
        this.nodeIpAddress = nodeIpAddress;
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

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
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


