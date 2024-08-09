// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: master.proto

package si.mlimedija.proto;

/**
 * <pre>
 * response for adding keys to registry (Lambda cache)
 * </pre>
 *
 * Protobuf type {@code Master.PutKeysResponse}
 */
public  final class PutKeysResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Master.PutKeysResponse)
    PutKeysResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PutKeysResponse.newBuilder() to construct.
  private PutKeysResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PutKeysResponse() {
    responseCode_ = 0;
    responseMessage_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PutKeysResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
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

            responseCode_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            responseMessage_ = s;
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
    return si.mlimedija.proto.Master.internal_static_Master_PutKeysResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return si.mlimedija.proto.Master.internal_static_Master_PutKeysResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            si.mlimedija.proto.PutKeysResponse.class, si.mlimedija.proto.PutKeysResponse.Builder.class);
  }

  public static final int RESPONSECODE_FIELD_NUMBER = 1;
  private int responseCode_;
  /**
   * <code>int32 responseCode = 1;</code>
   */
  public int getResponseCode() {
    return responseCode_;
  }

  public static final int RESPONSEMESSAGE_FIELD_NUMBER = 2;
  private volatile java.lang.Object responseMessage_;
  /**
   * <code>string responseMessage = 2;</code>
   */
  public java.lang.String getResponseMessage() {
    java.lang.Object ref = responseMessage_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      responseMessage_ = s;
      return s;
    }
  }
  /**
   * <code>string responseMessage = 2;</code>
   */
  public com.google.protobuf.ByteString
      getResponseMessageBytes() {
    java.lang.Object ref = responseMessage_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      responseMessage_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (responseCode_ != 0) {
      output.writeInt32(1, responseCode_);
    }
    if (!getResponseMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, responseMessage_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (responseCode_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, responseCode_);
    }
    if (!getResponseMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, responseMessage_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof si.mlimedija.proto.PutKeysResponse)) {
      return super.equals(obj);
    }
    si.mlimedija.proto.PutKeysResponse other = (si.mlimedija.proto.PutKeysResponse) obj;

    boolean result = true;
    result = result && (getResponseCode()
        == other.getResponseCode());
    result = result && getResponseMessage()
        .equals(other.getResponseMessage());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + RESPONSECODE_FIELD_NUMBER;
    hash = (53 * hash) + getResponseCode();
    hash = (37 * hash) + RESPONSEMESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getResponseMessage().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static si.mlimedija.proto.PutKeysResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static si.mlimedija.proto.PutKeysResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static si.mlimedija.proto.PutKeysResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static si.mlimedija.proto.PutKeysResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static si.mlimedija.proto.PutKeysResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static si.mlimedija.proto.PutKeysResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static si.mlimedija.proto.PutKeysResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static si.mlimedija.proto.PutKeysResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static si.mlimedija.proto.PutKeysResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static si.mlimedija.proto.PutKeysResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static si.mlimedija.proto.PutKeysResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static si.mlimedija.proto.PutKeysResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(si.mlimedija.proto.PutKeysResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * response for adding keys to registry (Lambda cache)
   * </pre>
   *
   * Protobuf type {@code Master.PutKeysResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Master.PutKeysResponse)
      si.mlimedija.proto.PutKeysResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return si.mlimedija.proto.Master.internal_static_Master_PutKeysResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return si.mlimedija.proto.Master.internal_static_Master_PutKeysResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              si.mlimedija.proto.PutKeysResponse.class, si.mlimedija.proto.PutKeysResponse.Builder.class);
    }

    // Construct using si.mlimedija.proto.PutKeysResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      responseCode_ = 0;

      responseMessage_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return si.mlimedija.proto.Master.internal_static_Master_PutKeysResponse_descriptor;
    }

    @java.lang.Override
    public si.mlimedija.proto.PutKeysResponse getDefaultInstanceForType() {
      return si.mlimedija.proto.PutKeysResponse.getDefaultInstance();
    }

    @java.lang.Override
    public si.mlimedija.proto.PutKeysResponse build() {
      si.mlimedija.proto.PutKeysResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public si.mlimedija.proto.PutKeysResponse buildPartial() {
      si.mlimedija.proto.PutKeysResponse result = new si.mlimedija.proto.PutKeysResponse(this);
      result.responseCode_ = responseCode_;
      result.responseMessage_ = responseMessage_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof si.mlimedija.proto.PutKeysResponse) {
        return mergeFrom((si.mlimedija.proto.PutKeysResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(si.mlimedija.proto.PutKeysResponse other) {
      if (other == si.mlimedija.proto.PutKeysResponse.getDefaultInstance()) return this;
      if (other.getResponseCode() != 0) {
        setResponseCode(other.getResponseCode());
      }
      if (!other.getResponseMessage().isEmpty()) {
        responseMessage_ = other.responseMessage_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      si.mlimedija.proto.PutKeysResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (si.mlimedija.proto.PutKeysResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int responseCode_ ;
    /**
     * <code>int32 responseCode = 1;</code>
     */
    public int getResponseCode() {
      return responseCode_;
    }
    /**
     * <code>int32 responseCode = 1;</code>
     */
    public Builder setResponseCode(int value) {
      
      responseCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 responseCode = 1;</code>
     */
    public Builder clearResponseCode() {
      
      responseCode_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object responseMessage_ = "";
    /**
     * <code>string responseMessage = 2;</code>
     */
    public java.lang.String getResponseMessage() {
      java.lang.Object ref = responseMessage_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        responseMessage_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string responseMessage = 2;</code>
     */
    public com.google.protobuf.ByteString
        getResponseMessageBytes() {
      java.lang.Object ref = responseMessage_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        responseMessage_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string responseMessage = 2;</code>
     */
    public Builder setResponseMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      responseMessage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string responseMessage = 2;</code>
     */
    public Builder clearResponseMessage() {
      
      responseMessage_ = getDefaultInstance().getResponseMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string responseMessage = 2;</code>
     */
    public Builder setResponseMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      responseMessage_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Master.PutKeysResponse)
  }

  // @@protoc_insertion_point(class_scope:Master.PutKeysResponse)
  private static final si.mlimedija.proto.PutKeysResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new si.mlimedija.proto.PutKeysResponse();
  }

  public static si.mlimedija.proto.PutKeysResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PutKeysResponse>
      PARSER = new com.google.protobuf.AbstractParser<PutKeysResponse>() {
    @java.lang.Override
    public PutKeysResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PutKeysResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PutKeysResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PutKeysResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public si.mlimedija.proto.PutKeysResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

