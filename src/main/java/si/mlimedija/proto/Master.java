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
    internal_static_Master_PutDataRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Master_PutDataRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Master_PutDataResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Master_PutDataResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Master_GetDataRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Master_GetDataRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Master_GetDataResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Master_GetDataResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Master_PutFileEndpointRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Master_PutFileEndpointRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Master_PutFileEndpointResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Master_PutFileEndpointResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Master_GetFileEndpointRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Master_GetFileEndpointRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Master_GetFileEndpointResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Master_GetFileEndpointResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Master_PutKeysRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Master_PutKeysRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Master_PutKeysResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Master_PutKeysResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Master_DeleteKeysRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Master_DeleteKeysRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Master_DeleteKeysResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Master_DeleteKeysResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Master_NodeHandshakeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Master_NodeHandshakeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Master_NodeHandshakeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Master_NodeHandshakeResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014master.proto\022\006Master\",\n\016PutDataRequest" +
      "\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t\"M\n\017PutDataR" +
      "esponse\022\013\n\003key\030\001 \001(\t\022\024\n\014responseCode\030\002 \001" +
      "(\005\022\027\n\017responseMessage\030\003 \001(\t\"\035\n\016GetDataRe" +
      "quest\022\013\n\003key\030\001 \001(\t\"\\\n\017GetDataResponse\022\013\n" +
      "\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t\022\024\n\014responseCod" +
      "e\030\003 \001(\005\022\027\n\017responseMessage\030\004 \001(\t\">\n\026PutF" +
      "ileEndpointRequest\022\020\n\010fileName\030\001 \001(\t\022\022\n\n" +
      "fileSizeMb\030\002 \001(\005\"B\n\027PutFileEndpointRespo" +
      "nse\022\025\n\rnodeIpAddress\030\001 \001(\t\022\020\n\010nodePort\030\002" +
      " \001(\005\"*\n\026GetFileEndpointRequest\022\020\n\010fileNa" +
      "me\030\001 \001(\t\"q\n\027GetFileEndpointResponse\022\025\n\rn" +
      "odeIpAddress\030\001 \003(\t\022\024\n\014isStoredOnS3\030\002 \001(\010" +
      "\022\024\n\014s3BucketName\030\003 \001(\t\022\023\n\013s3ObjectKey\030\004 " +
      "\001(\t\".\n\016PutKeysRequest\022\016\n\006nodeId\030\001 \001(\005\022\014\n" +
      "\004keys\030\002 \003(\t\"@\n\017PutKeysResponse\022\024\n\014respon" +
      "seCode\030\001 \001(\005\022\027\n\017responseMessage\030\002 \001(\t\"1\n" +
      "\021DeleteKeysRequest\022\016\n\006nodeId\030\001 \001(\005\022\014\n\004ke" +
      "ys\030\002 \003(\t\"C\n\022DeleteKeysResponse\022\024\n\014respon" +
      "seCode\030\001 \001(\005\022\027\n\017responseMessage\030\002 \001(\t\"Q\n" +
      "\024NodeHandshakeRequest\022\025\n\rnodeIpAddress\030\001" +
      " \001(\t\022\020\n\010nodePort\030\002 \001(\005\022\020\n\010nodeType\030\003 \001(\t" +
      "\"V\n\025NodeHandshakeResponse\022\016\n\006nodeId\030\001 \001(" +
      "\005\022\024\n\014responseCode\030\002 \001(\005\022\027\n\017responseMessa" +
      "ge\030\003 \001(\t2\367\003\n\006master\022:\n\007putData\022\026.Master." +
      "PutDataRequest\032\027.Master.PutDataResponse\022" +
      ":\n\007getData\022\026.Master.GetDataRequest\032\027.Mas" +
      "ter.GetDataResponse\022R\n\017putFileEndpoint\022\036" +
      ".Master.PutFileEndpointRequest\032\037.Master." +
      "PutFileEndpointResponse\022R\n\017getFileEndpoi" +
      "nt\022\036.Master.GetFileEndpointRequest\032\037.Mas" +
      "ter.GetFileEndpointResponse\022:\n\007putKeys\022\026" +
      ".Master.PutKeysRequest\032\027.Master.PutKeysR" +
      "esponse\022C\n\ndeleteKeys\022\031.Master.DeleteKey" +
      "sRequest\032\032.Master.DeleteKeysResponse\022L\n\r" +
      "nodeHandshake\022\034.Master.NodeHandshakeRequ" +
      "est\032\035.Master.NodeHandshakeResponseB\026\n\022si" +
      ".mlimedija.protoP\001b\006proto3"
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
    internal_static_Master_PutDataRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Master_PutDataRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Master_PutDataRequest_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_Master_PutDataResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Master_PutDataResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Master_PutDataResponse_descriptor,
        new java.lang.String[] { "Key", "ResponseCode", "ResponseMessage", });
    internal_static_Master_GetDataRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Master_GetDataRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Master_GetDataRequest_descriptor,
        new java.lang.String[] { "Key", });
    internal_static_Master_GetDataResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Master_GetDataResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Master_GetDataResponse_descriptor,
        new java.lang.String[] { "Key", "Value", "ResponseCode", "ResponseMessage", });
    internal_static_Master_PutFileEndpointRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Master_PutFileEndpointRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Master_PutFileEndpointRequest_descriptor,
        new java.lang.String[] { "FileName", "FileSizeMb", });
    internal_static_Master_PutFileEndpointResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Master_PutFileEndpointResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Master_PutFileEndpointResponse_descriptor,
        new java.lang.String[] { "NodeIpAddress", "NodePort", });
    internal_static_Master_GetFileEndpointRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_Master_GetFileEndpointRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Master_GetFileEndpointRequest_descriptor,
        new java.lang.String[] { "FileName", });
    internal_static_Master_GetFileEndpointResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_Master_GetFileEndpointResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Master_GetFileEndpointResponse_descriptor,
        new java.lang.String[] { "NodeIpAddress", "IsStoredOnS3", "S3BucketName", "S3ObjectKey", });
    internal_static_Master_PutKeysRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_Master_PutKeysRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Master_PutKeysRequest_descriptor,
        new java.lang.String[] { "NodeId", "Keys", });
    internal_static_Master_PutKeysResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_Master_PutKeysResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Master_PutKeysResponse_descriptor,
        new java.lang.String[] { "ResponseCode", "ResponseMessage", });
    internal_static_Master_DeleteKeysRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_Master_DeleteKeysRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Master_DeleteKeysRequest_descriptor,
        new java.lang.String[] { "NodeId", "Keys", });
    internal_static_Master_DeleteKeysResponse_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_Master_DeleteKeysResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Master_DeleteKeysResponse_descriptor,
        new java.lang.String[] { "ResponseCode", "ResponseMessage", });
    internal_static_Master_NodeHandshakeRequest_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_Master_NodeHandshakeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Master_NodeHandshakeRequest_descriptor,
        new java.lang.String[] { "NodeIpAddress", "NodePort", "NodeType", });
    internal_static_Master_NodeHandshakeResponse_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_Master_NodeHandshakeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Master_NodeHandshakeResponse_descriptor,
        new java.lang.String[] { "NodeId", "ResponseCode", "ResponseMessage", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
