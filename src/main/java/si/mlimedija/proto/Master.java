// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: master.proto

package si.mlimedija.proto;

public final class Master {
  private Master() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PutDataRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PutDataRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PutDataResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PutDataResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetDataRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetDataRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetDataResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetDataResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014master.proto\"<\n\016PutDataRequest\022\016\n\006node" +
      "Id\030\001 \001(\005\022\013\n\003key\030\002 \001(\t\022\r\n\005value\030\003 \001(\t\"M\n\017" +
      "PutDataResponse\022\013\n\003key\030\001 \001(\t\022\024\n\014response" +
      "Code\030\002 \001(\005\022\027\n\017responseMessage\030\003 \001(\t\"-\n\016G" +
      "etDataRequest\022\016\n\006nodeId\030\001 \001(\005\022\013\n\003key\030\002 \001" +
      "(\t\"\\\n\017GetDataResponse\022\013\n\003key\030\001 \001(\t\022\r\n\005va" +
      "lue\030\002 \001(\t\022\024\n\014responseCode\030\003 \001(\005\022\027\n\017respo" +
      "nseMessage\030\004 \001(\t2d\n\006master\022,\n\007putData\022\017." +
      "PutDataRequest\032\020.PutDataResponse\022,\n\007getD" +
      "ata\022\017.GetDataRequest\032\020.GetDataResponseB\026" +
      "\n\022si.mlimedija.protoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_PutDataRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_PutDataRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PutDataRequest_descriptor,
        new java.lang.String[] { "NodeId", "Key", "Value", });
    internal_static_PutDataResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_PutDataResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PutDataResponse_descriptor,
        new java.lang.String[] { "Key", "ResponseCode", "ResponseMessage", });
    internal_static_GetDataRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_GetDataRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetDataRequest_descriptor,
        new java.lang.String[] { "NodeId", "Key", });
    internal_static_GetDataResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_GetDataResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetDataResponse_descriptor,
        new java.lang.String[] { "Key", "Value", "ResponseCode", "ResponseMessage", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}