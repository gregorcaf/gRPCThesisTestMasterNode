// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: storage.proto

package si.mlimedija.proto;

public interface GetDataNodeResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GetDataNodeResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string key = 1;</code>
   */
  String getKey();
  /**
   * <code>string key = 1;</code>
   */
  com.google.protobuf.ByteString
      getKeyBytes();

  /**
   * <code>string value = 2;</code>
   */
  String getValue();
  /**
   * <code>string value = 2;</code>
   */
  com.google.protobuf.ByteString
      getValueBytes();

  /**
   * <code>int32 responseCode = 3;</code>
   */
  int getResponseCode();

  /**
   * <code>string responseMessage = 4;</code>
   */
  String getResponseMessage();
  /**
   * <code>string responseMessage = 4;</code>
   */
  com.google.protobuf.ByteString
      getResponseMessageBytes();
}
