// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: storage.proto

package si.mlimedija.proto;

public final class Storage {
  private Storage() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PutDataNodeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PutDataNodeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PutDataNodeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PutDataNodeResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetDataNodeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetDataNodeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GetDataNodeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GetDataNodeResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rstorage.proto\"@\n\022PutDataNodeRequest\022\016\n" +
      "\006nodeId\030\001 \001(\005\022\013\n\003key\030\002 \001(\t\022\r\n\005value\030\003 \001(" +
      "\t\"Q\n\023PutDataNodeResponse\022\013\n\003key\030\001 \001(\t\022\024\n" +
      "\014responseCode\030\002 \001(\005\022\027\n\017responseMessage\030\003" +
      " \001(\t\"1\n\022GetDataNodeRequest\022\016\n\006nodeId\030\001 \001" +
      "(\005\022\013\n\003key\030\002 \001(\t\"`\n\023GetDataNodeResponse\022\013" +
      "\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t\022\024\n\014responseCo" +
      "de\030\003 \001(\005\022\027\n\017responseMessage\030\004 \001(\t2}\n\007sto" +
      "rage\0228\n\013putDataNode\022\023.PutDataNodeRequest" +
      "\032\024.PutDataNodeResponse\0228\n\013getDataNode\022\023." +
      "GetDataNodeRequest\032\024.GetDataNodeResponse" +
      "B\026\n\022si.mlimedija.protoP\001b\006proto3"
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
    internal_static_PutDataNodeRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_PutDataNodeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PutDataNodeRequest_descriptor,
        new String[] { "NodeId", "Key", "Value", });
    internal_static_PutDataNodeResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_PutDataNodeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PutDataNodeResponse_descriptor,
        new String[] { "Key", "ResponseCode", "ResponseMessage", });
    internal_static_GetDataNodeRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_GetDataNodeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetDataNodeRequest_descriptor,
        new String[] { "NodeId", "Key", });
    internal_static_GetDataNodeResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_GetDataNodeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GetDataNodeResponse_descriptor,
        new String[] { "Key", "Value", "ResponseCode", "ResponseMessage", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
