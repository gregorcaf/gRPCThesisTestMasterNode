// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: NodeInfo.proto

package si.mlimedija.proto;

/**
 * <pre>
 * get storage node's info status =&gt; request
 * </pre>
 *
 * Protobuf type {@code NodeInfoRequest}
 */
public  final class NodeInfoRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:NodeInfoRequest)
    NodeInfoRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NodeInfoRequest.newBuilder() to construct.
  private NodeInfoRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NodeInfoRequest() {
    nodeId_ = 0;
    nodeIpAddress_ = "";
    nodePort_ = 0;
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NodeInfoRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            nodeId_ = input.readInt32();
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            nodeIpAddress_ = s;
            break;
          }
          case 24: {

            nodePort_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return NodeInfo.internal_static_NodeInfoRequest_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return NodeInfo.internal_static_NodeInfoRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            NodeInfoRequest.class, Builder.class);
  }

  public static final int NODEID_FIELD_NUMBER = 1;
  private int nodeId_;
  /**
   * <code>int32 nodeId = 1;</code>
   */
  public int getNodeId() {
    return nodeId_;
  }

  public static final int NODEIPADDRESS_FIELD_NUMBER = 2;
  private volatile Object nodeIpAddress_;
  /**
   * <code>string nodeIpAddress = 2;</code>
   */
  public String getNodeIpAddress() {
    Object ref = nodeIpAddress_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      nodeIpAddress_ = s;
      return s;
    }
  }
  /**
   * <code>string nodeIpAddress = 2;</code>
   */
  public com.google.protobuf.ByteString
      getNodeIpAddressBytes() {
    Object ref = nodeIpAddress_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      nodeIpAddress_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NODEPORT_FIELD_NUMBER = 3;
  private int nodePort_;
  /**
   * <code>int32 nodePort = 3;</code>
   */
  public int getNodePort() {
    return nodePort_;
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (nodeId_ != 0) {
      output.writeInt32(1, nodeId_);
    }
    if (!getNodeIpAddressBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, nodeIpAddress_);
    }
    if (nodePort_ != 0) {
      output.writeInt32(3, nodePort_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (nodeId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, nodeId_);
    }
    if (!getNodeIpAddressBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, nodeIpAddress_);
    }
    if (nodePort_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, nodePort_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof NodeInfoRequest)) {
      return super.equals(obj);
    }
    NodeInfoRequest other = (NodeInfoRequest) obj;

    boolean result = true;
    result = result && (getNodeId()
        == other.getNodeId());
    result = result && getNodeIpAddress()
        .equals(other.getNodeIpAddress());
    result = result && (getNodePort()
        == other.getNodePort());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + NODEID_FIELD_NUMBER;
    hash = (53 * hash) + getNodeId();
    hash = (37 * hash) + NODEIPADDRESS_FIELD_NUMBER;
    hash = (53 * hash) + getNodeIpAddress().hashCode();
    hash = (37 * hash) + NODEPORT_FIELD_NUMBER;
    hash = (53 * hash) + getNodePort();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static NodeInfoRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static NodeInfoRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static NodeInfoRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static NodeInfoRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static NodeInfoRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static NodeInfoRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static NodeInfoRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static NodeInfoRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static NodeInfoRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static NodeInfoRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static NodeInfoRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static NodeInfoRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(NodeInfoRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * get storage node's info status =&gt; request
   * </pre>
   *
   * Protobuf type {@code NodeInfoRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:NodeInfoRequest)
      NodeInfoRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return NodeInfo.internal_static_NodeInfoRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return NodeInfo.internal_static_NodeInfoRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              NodeInfoRequest.class, Builder.class);
    }

    // Construct using si.mlimedija.proto.NodeInfoRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      nodeId_ = 0;

      nodeIpAddress_ = "";

      nodePort_ = 0;

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return NodeInfo.internal_static_NodeInfoRequest_descriptor;
    }

    @Override
    public NodeInfoRequest getDefaultInstanceForType() {
      return NodeInfoRequest.getDefaultInstance();
    }

    @Override
    public NodeInfoRequest build() {
      NodeInfoRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public NodeInfoRequest buildPartial() {
      NodeInfoRequest result = new NodeInfoRequest(this);
      result.nodeId_ = nodeId_;
      result.nodeIpAddress_ = nodeIpAddress_;
      result.nodePort_ = nodePort_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof NodeInfoRequest) {
        return mergeFrom((NodeInfoRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(NodeInfoRequest other) {
      if (other == NodeInfoRequest.getDefaultInstance()) return this;
      if (other.getNodeId() != 0) {
        setNodeId(other.getNodeId());
      }
      if (!other.getNodeIpAddress().isEmpty()) {
        nodeIpAddress_ = other.nodeIpAddress_;
        onChanged();
      }
      if (other.getNodePort() != 0) {
        setNodePort(other.getNodePort());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      NodeInfoRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (NodeInfoRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int nodeId_ ;
    /**
     * <code>int32 nodeId = 1;</code>
     */
    public int getNodeId() {
      return nodeId_;
    }
    /**
     * <code>int32 nodeId = 1;</code>
     */
    public Builder setNodeId(int value) {
      
      nodeId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 nodeId = 1;</code>
     */
    public Builder clearNodeId() {
      
      nodeId_ = 0;
      onChanged();
      return this;
    }

    private Object nodeIpAddress_ = "";
    /**
     * <code>string nodeIpAddress = 2;</code>
     */
    public String getNodeIpAddress() {
      Object ref = nodeIpAddress_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        nodeIpAddress_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string nodeIpAddress = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNodeIpAddressBytes() {
      Object ref = nodeIpAddress_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        nodeIpAddress_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string nodeIpAddress = 2;</code>
     */
    public Builder setNodeIpAddress(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      nodeIpAddress_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string nodeIpAddress = 2;</code>
     */
    public Builder clearNodeIpAddress() {
      
      nodeIpAddress_ = getDefaultInstance().getNodeIpAddress();
      onChanged();
      return this;
    }
    /**
     * <code>string nodeIpAddress = 2;</code>
     */
    public Builder setNodeIpAddressBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      nodeIpAddress_ = value;
      onChanged();
      return this;
    }

    private int nodePort_ ;
    /**
     * <code>int32 nodePort = 3;</code>
     */
    public int getNodePort() {
      return nodePort_;
    }
    /**
     * <code>int32 nodePort = 3;</code>
     */
    public Builder setNodePort(int value) {
      
      nodePort_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 nodePort = 3;</code>
     */
    public Builder clearNodePort() {
      
      nodePort_ = 0;
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:NodeInfoRequest)
  }

  // @@protoc_insertion_point(class_scope:NodeInfoRequest)
  private static final NodeInfoRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new NodeInfoRequest();
  }

  public static NodeInfoRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NodeInfoRequest>
      PARSER = new com.google.protobuf.AbstractParser<NodeInfoRequest>() {
    @Override
    public NodeInfoRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new NodeInfoRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NodeInfoRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<NodeInfoRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public NodeInfoRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

