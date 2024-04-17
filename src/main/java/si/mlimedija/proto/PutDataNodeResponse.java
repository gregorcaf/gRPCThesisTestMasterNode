// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: storage.proto

package si.mlimedija.proto;

/**
 * Protobuf type {@code PutDataNodeResponse}
 */
public  final class PutDataNodeResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:PutDataNodeResponse)
        PutDataNodeResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PutDataNodeResponse.newBuilder() to construct.
  private PutDataNodeResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PutDataNodeResponse() {
    key_ = "";
    responseCode_ = 0;
    responseMessage_ = "";
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PutDataNodeResponse(
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
          case 10: {
            String s = input.readStringRequireUtf8();

            key_ = s;
            break;
          }
          case 16: {

            responseCode_ = input.readInt32();
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

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
    return si.mlimedija.proto.Storage.internal_static_PutDataNodeResponse_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return si.mlimedija.proto.Storage.internal_static_PutDataNodeResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            si.mlimedija.proto.PutDataNodeResponse.class, si.mlimedija.proto.PutDataNodeResponse.Builder.class);
  }

  public static final int KEY_FIELD_NUMBER = 1;
  private volatile Object key_;
  /**
   * <code>string key = 1;</code>
   */
  public String getKey() {
    Object ref = key_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      key_ = s;
      return s;
    }
  }
  /**
   * <code>string key = 1;</code>
   */
  public com.google.protobuf.ByteString
      getKeyBytes() {
    Object ref = key_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      key_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int RESPONSECODE_FIELD_NUMBER = 2;
  private int responseCode_;
  /**
   * <code>int32 responseCode = 2;</code>
   */
  public int getResponseCode() {
    return responseCode_;
  }

  public static final int RESPONSEMESSAGE_FIELD_NUMBER = 3;
  private volatile Object responseMessage_;
  /**
   * <code>string responseMessage = 3;</code>
   */
  public String getResponseMessage() {
    Object ref = responseMessage_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      responseMessage_ = s;
      return s;
    }
  }
  /**
   * <code>string responseMessage = 3;</code>
   */
  public com.google.protobuf.ByteString
      getResponseMessageBytes() {
    Object ref = responseMessage_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      responseMessage_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getKeyBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, key_);
    }
    if (responseCode_ != 0) {
      output.writeInt32(2, responseCode_);
    }
    if (!getResponseMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, responseMessage_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getKeyBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, key_);
    }
    if (responseCode_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, responseCode_);
    }
    if (!getResponseMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, responseMessage_);
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
    if (!(obj instanceof si.mlimedija.proto.PutDataNodeResponse)) {
      return super.equals(obj);
    }
    si.mlimedija.proto.PutDataNodeResponse other = (si.mlimedija.proto.PutDataNodeResponse) obj;

    boolean result = true;
    result = result && getKey()
        .equals(other.getKey());
    result = result && (getResponseCode()
        == other.getResponseCode());
    result = result && getResponseMessage()
        .equals(other.getResponseMessage());
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
    hash = (37 * hash) + KEY_FIELD_NUMBER;
    hash = (53 * hash) + getKey().hashCode();
    hash = (37 * hash) + RESPONSECODE_FIELD_NUMBER;
    hash = (53 * hash) + getResponseCode();
    hash = (37 * hash) + RESPONSEMESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getResponseMessage().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static si.mlimedija.proto.PutDataNodeResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static si.mlimedija.proto.PutDataNodeResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static si.mlimedija.proto.PutDataNodeResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static si.mlimedija.proto.PutDataNodeResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static si.mlimedija.proto.PutDataNodeResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static si.mlimedija.proto.PutDataNodeResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static si.mlimedija.proto.PutDataNodeResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static si.mlimedija.proto.PutDataNodeResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static si.mlimedija.proto.PutDataNodeResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static si.mlimedija.proto.PutDataNodeResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static si.mlimedija.proto.PutDataNodeResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static si.mlimedija.proto.PutDataNodeResponse parseFrom(
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
  public static Builder newBuilder(si.mlimedija.proto.PutDataNodeResponse prototype) {
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
   * Protobuf type {@code PutDataNodeResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:PutDataNodeResponse)
      PutDataNodeResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return si.mlimedija.proto.Storage.internal_static_PutDataNodeResponse_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return si.mlimedija.proto.Storage.internal_static_PutDataNodeResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              si.mlimedija.proto.PutDataNodeResponse.class, si.mlimedija.proto.PutDataNodeResponse.Builder.class);
    }

    // Construct using si.mlimedija.proto.PutDataNodeResponse.newBuilder()
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
      key_ = "";

      responseCode_ = 0;

      responseMessage_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return si.mlimedija.proto.Storage.internal_static_PutDataNodeResponse_descriptor;
    }

    @Override
    public si.mlimedija.proto.PutDataNodeResponse getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    @Override
    public si.mlimedija.proto.PutDataNodeResponse build() {
      si.mlimedija.proto.PutDataNodeResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public si.mlimedija.proto.PutDataNodeResponse buildPartial() {
      si.mlimedija.proto.PutDataNodeResponse result = new si.mlimedija.proto.PutDataNodeResponse(this);
      result.key_ = key_;
      result.responseCode_ = responseCode_;
      result.responseMessage_ = responseMessage_;
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
      if (other instanceof si.mlimedija.proto.PutDataNodeResponse) {
        return mergeFrom((si.mlimedija.proto.PutDataNodeResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(si.mlimedija.proto.PutDataNodeResponse other) {
      if (other == getDefaultInstance()) return this;
      if (!other.getKey().isEmpty()) {
        key_ = other.key_;
        onChanged();
      }
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

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      si.mlimedija.proto.PutDataNodeResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (si.mlimedija.proto.PutDataNodeResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object key_ = "";
    /**
     * <code>string key = 1;</code>
     */
    public String getKey() {
      Object ref = key_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        key_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string key = 1;</code>
     */
    public com.google.protobuf.ByteString
        getKeyBytes() {
      Object ref = key_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        key_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string key = 1;</code>
     */
    public Builder setKey(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      key_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string key = 1;</code>
     */
    public Builder clearKey() {
      
      key_ = getDefaultInstance().getKey();
      onChanged();
      return this;
    }
    /**
     * <code>string key = 1;</code>
     */
    public Builder setKeyBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      key_ = value;
      onChanged();
      return this;
    }

    private int responseCode_ ;
    /**
     * <code>int32 responseCode = 2;</code>
     */
    public int getResponseCode() {
      return responseCode_;
    }
    /**
     * <code>int32 responseCode = 2;</code>
     */
    public Builder setResponseCode(int value) {
      
      responseCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 responseCode = 2;</code>
     */
    public Builder clearResponseCode() {
      
      responseCode_ = 0;
      onChanged();
      return this;
    }

    private Object responseMessage_ = "";
    /**
     * <code>string responseMessage = 3;</code>
     */
    public String getResponseMessage() {
      Object ref = responseMessage_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        responseMessage_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string responseMessage = 3;</code>
     */
    public com.google.protobuf.ByteString
        getResponseMessageBytes() {
      Object ref = responseMessage_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        responseMessage_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string responseMessage = 3;</code>
     */
    public Builder setResponseMessage(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      responseMessage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string responseMessage = 3;</code>
     */
    public Builder clearResponseMessage() {
      
      responseMessage_ = getDefaultInstance().getResponseMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string responseMessage = 3;</code>
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


    // @@protoc_insertion_point(builder_scope:PutDataNodeResponse)
  }

  // @@protoc_insertion_point(class_scope:PutDataNodeResponse)
  private static final si.mlimedija.proto.PutDataNodeResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new si.mlimedija.proto.PutDataNodeResponse();
  }

  public static si.mlimedija.proto.PutDataNodeResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PutDataNodeResponse>
      PARSER = new com.google.protobuf.AbstractParser<PutDataNodeResponse>() {
    @Override
    public PutDataNodeResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PutDataNodeResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PutDataNodeResponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<PutDataNodeResponse> getParserForType() {
    return PARSER;
  }

  @Override
  public si.mlimedija.proto.PutDataNodeResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

