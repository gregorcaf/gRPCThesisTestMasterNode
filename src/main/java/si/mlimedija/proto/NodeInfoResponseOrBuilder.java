// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: NodeInfo.proto

package si.mlimedija.proto;

public interface NodeInfoResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:NodeInfoResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 nodeId = 1;</code>
   */
  int getNodeId();

  /**
   * <code>string nodeIpAddress = 2;</code>
   */
  String getNodeIpAddress();
  /**
   * <code>string nodeIpAddress = 2;</code>
   */
  com.google.protobuf.ByteString
      getNodeIpAddressBytes();

  /**
   * <code>bool isHealthy = 3;</code>
   */
  boolean getIsHealthy();

  /**
   * <code>int32 mapSize = 4;</code>
   */
  int getMapSize();

  /**
   * <code>int32 responseCode = 5;</code>
   */
  int getResponseCode();

  /**
   * <code>string responseMessage = 6;</code>
   */
  String getResponseMessage();
  /**
   * <code>string responseMessage = 6;</code>
   */
  com.google.protobuf.ByteString
      getResponseMessageBytes();
}
