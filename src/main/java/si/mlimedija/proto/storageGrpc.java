package si.mlimedija.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: storage.proto")
public final class storageGrpc {

  private storageGrpc() {}

  public static final String SERVICE_NAME = "storage";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<si.mlimedija.proto.PutDataNodeRequest,
      si.mlimedija.proto.PutDataNodeResponse> getPutDataNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "putDataNode",
      requestType = si.mlimedija.proto.PutDataNodeRequest.class,
      responseType = si.mlimedija.proto.PutDataNodeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<si.mlimedija.proto.PutDataNodeRequest,
      si.mlimedija.proto.PutDataNodeResponse> getPutDataNodeMethod() {
    io.grpc.MethodDescriptor<si.mlimedija.proto.PutDataNodeRequest, si.mlimedija.proto.PutDataNodeResponse> getPutDataNodeMethod;
    if ((getPutDataNodeMethod = storageGrpc.getPutDataNodeMethod) == null) {
      synchronized (storageGrpc.class) {
        if ((getPutDataNodeMethod = storageGrpc.getPutDataNodeMethod) == null) {
          storageGrpc.getPutDataNodeMethod = getPutDataNodeMethod = 
              io.grpc.MethodDescriptor.<si.mlimedija.proto.PutDataNodeRequest, si.mlimedija.proto.PutDataNodeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "storage", "putDataNode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.PutDataNodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.PutDataNodeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new storageMethodDescriptorSupplier("putDataNode"))
                  .build();
          }
        }
     }
     return getPutDataNodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<si.mlimedija.proto.GetDataNodeRequest,
      si.mlimedija.proto.GetDataNodeResponse> getGetDataNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getDataNode",
      requestType = si.mlimedija.proto.GetDataNodeRequest.class,
      responseType = si.mlimedija.proto.GetDataNodeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<si.mlimedija.proto.GetDataNodeRequest,
      si.mlimedija.proto.GetDataNodeResponse> getGetDataNodeMethod() {
    io.grpc.MethodDescriptor<si.mlimedija.proto.GetDataNodeRequest, si.mlimedija.proto.GetDataNodeResponse> getGetDataNodeMethod;
    if ((getGetDataNodeMethod = storageGrpc.getGetDataNodeMethod) == null) {
      synchronized (storageGrpc.class) {
        if ((getGetDataNodeMethod = storageGrpc.getGetDataNodeMethod) == null) {
          storageGrpc.getGetDataNodeMethod = getGetDataNodeMethod = 
              io.grpc.MethodDescriptor.<si.mlimedija.proto.GetDataNodeRequest, si.mlimedija.proto.GetDataNodeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "storage", "getDataNode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.GetDataNodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.GetDataNodeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new storageMethodDescriptorSupplier("getDataNode"))
                  .build();
          }
        }
     }
     return getGetDataNodeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static storageStub newStub(io.grpc.Channel channel) {
    return new storageStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static storageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new storageBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static storageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new storageFutureStub(channel);
  }

  /**
   */
  public static abstract class storageImplBase implements io.grpc.BindableService {

    /**
     */
    public void putDataNode(si.mlimedija.proto.PutDataNodeRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.PutDataNodeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPutDataNodeMethod(), responseObserver);
    }

    /**
     */
    public void getDataNode(si.mlimedija.proto.GetDataNodeRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.GetDataNodeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDataNodeMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPutDataNodeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                si.mlimedija.proto.PutDataNodeRequest,
                si.mlimedija.proto.PutDataNodeResponse>(
                  this, METHODID_PUT_DATA_NODE)))
          .addMethod(
            getGetDataNodeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                si.mlimedija.proto.GetDataNodeRequest,
                si.mlimedija.proto.GetDataNodeResponse>(
                  this, METHODID_GET_DATA_NODE)))
          .build();
    }
  }

  /**
   */
  public static final class storageStub extends io.grpc.stub.AbstractStub<storageStub> {
    private storageStub(io.grpc.Channel channel) {
      super(channel);
    }

    private storageStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected storageStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new storageStub(channel, callOptions);
    }

    /**
     */
    public void putDataNode(si.mlimedija.proto.PutDataNodeRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.PutDataNodeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutDataNodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDataNode(si.mlimedija.proto.GetDataNodeRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.GetDataNodeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDataNodeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class storageBlockingStub extends io.grpc.stub.AbstractStub<storageBlockingStub> {
    private storageBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private storageBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected storageBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new storageBlockingStub(channel, callOptions);
    }

    /**
     */
    public si.mlimedija.proto.PutDataNodeResponse putDataNode(si.mlimedija.proto.PutDataNodeRequest request) {
      return blockingUnaryCall(
          getChannel(), getPutDataNodeMethod(), getCallOptions(), request);
    }

    /**
     */
    public si.mlimedija.proto.GetDataNodeResponse getDataNode(si.mlimedija.proto.GetDataNodeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDataNodeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class storageFutureStub extends io.grpc.stub.AbstractStub<storageFutureStub> {
    private storageFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private storageFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected storageFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new storageFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<si.mlimedija.proto.PutDataNodeResponse> putDataNode(
        si.mlimedija.proto.PutDataNodeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPutDataNodeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<si.mlimedija.proto.GetDataNodeResponse> getDataNode(
        si.mlimedija.proto.GetDataNodeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDataNodeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PUT_DATA_NODE = 0;
  private static final int METHODID_GET_DATA_NODE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final storageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(storageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PUT_DATA_NODE:
          serviceImpl.putDataNode((si.mlimedija.proto.PutDataNodeRequest) request,
              (io.grpc.stub.StreamObserver<si.mlimedija.proto.PutDataNodeResponse>) responseObserver);
          break;
        case METHODID_GET_DATA_NODE:
          serviceImpl.getDataNode((si.mlimedija.proto.GetDataNodeRequest) request,
              (io.grpc.stub.StreamObserver<si.mlimedija.proto.GetDataNodeResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class storageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    storageBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return si.mlimedija.proto.Storage.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("storage");
    }
  }

  private static final class storageFileDescriptorSupplier
      extends storageBaseDescriptorSupplier {
    storageFileDescriptorSupplier() {}
  }

  private static final class storageMethodDescriptorSupplier
      extends storageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    storageMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (storageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new storageFileDescriptorSupplier())
              .addMethod(getPutDataNodeMethod())
              .addMethod(getGetDataNodeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
