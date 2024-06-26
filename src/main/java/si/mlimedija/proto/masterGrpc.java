package si.mlimedija.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: master.proto")
public final class masterGrpc {

  private masterGrpc() {}

  public static final String SERVICE_NAME = "master";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<si.mlimedija.proto.PutDataRequest,
      si.mlimedija.proto.PutDataResponse> getPutDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "putData",
      requestType = si.mlimedija.proto.PutDataRequest.class,
      responseType = si.mlimedija.proto.PutDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<si.mlimedija.proto.PutDataRequest,
      si.mlimedija.proto.PutDataResponse> getPutDataMethod() {
    io.grpc.MethodDescriptor<si.mlimedija.proto.PutDataRequest, si.mlimedija.proto.PutDataResponse> getPutDataMethod;
    if ((getPutDataMethod = masterGrpc.getPutDataMethod) == null) {
      synchronized (masterGrpc.class) {
        if ((getPutDataMethod = masterGrpc.getPutDataMethod) == null) {
          masterGrpc.getPutDataMethod = getPutDataMethod = 
              io.grpc.MethodDescriptor.<si.mlimedija.proto.PutDataRequest, si.mlimedija.proto.PutDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "master", "putData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.PutDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.PutDataResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new masterMethodDescriptorSupplier("putData"))
                  .build();
          }
        }
     }
     return getPutDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<si.mlimedija.proto.GetDataRequest,
      si.mlimedija.proto.GetDataResponse> getGetDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getData",
      requestType = si.mlimedija.proto.GetDataRequest.class,
      responseType = si.mlimedija.proto.GetDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<si.mlimedija.proto.GetDataRequest,
      si.mlimedija.proto.GetDataResponse> getGetDataMethod() {
    io.grpc.MethodDescriptor<si.mlimedija.proto.GetDataRequest, si.mlimedija.proto.GetDataResponse> getGetDataMethod;
    if ((getGetDataMethod = masterGrpc.getGetDataMethod) == null) {
      synchronized (masterGrpc.class) {
        if ((getGetDataMethod = masterGrpc.getGetDataMethod) == null) {
          masterGrpc.getGetDataMethod = getGetDataMethod = 
              io.grpc.MethodDescriptor.<si.mlimedija.proto.GetDataRequest, si.mlimedija.proto.GetDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "master", "getData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.GetDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.GetDataResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new masterMethodDescriptorSupplier("getData"))
                  .build();
          }
        }
     }
     return getGetDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static masterStub newStub(io.grpc.Channel channel) {
    return new masterStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static masterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new masterBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static masterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new masterFutureStub(channel);
  }

  /**
   */
  public static abstract class masterImplBase implements io.grpc.BindableService {

    /**
     */
    public void putData(si.mlimedija.proto.PutDataRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.PutDataResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPutDataMethod(), responseObserver);
    }

    /**
     */
    public void getData(si.mlimedija.proto.GetDataRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.GetDataResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPutDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                si.mlimedija.proto.PutDataRequest,
                si.mlimedija.proto.PutDataResponse>(
                  this, METHODID_PUT_DATA)))
          .addMethod(
            getGetDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                si.mlimedija.proto.GetDataRequest,
                si.mlimedija.proto.GetDataResponse>(
                  this, METHODID_GET_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class masterStub extends io.grpc.stub.AbstractStub<masterStub> {
    private masterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private masterStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected masterStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new masterStub(channel, callOptions);
    }

    /**
     */
    public void putData(si.mlimedija.proto.PutDataRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.PutDataResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getData(si.mlimedija.proto.GetDataRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.GetDataResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class masterBlockingStub extends io.grpc.stub.AbstractStub<masterBlockingStub> {
    private masterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private masterBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected masterBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new masterBlockingStub(channel, callOptions);
    }

    /**
     */
    public si.mlimedija.proto.PutDataResponse putData(si.mlimedija.proto.PutDataRequest request) {
      return blockingUnaryCall(
          getChannel(), getPutDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public si.mlimedija.proto.GetDataResponse getData(si.mlimedija.proto.GetDataRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDataMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class masterFutureStub extends io.grpc.stub.AbstractStub<masterFutureStub> {
    private masterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private masterFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected masterFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new masterFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<si.mlimedija.proto.PutDataResponse> putData(
        si.mlimedija.proto.PutDataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPutDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<si.mlimedija.proto.GetDataResponse> getData(
        si.mlimedija.proto.GetDataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PUT_DATA = 0;
  private static final int METHODID_GET_DATA = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final masterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(masterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PUT_DATA:
          serviceImpl.putData((si.mlimedija.proto.PutDataRequest) request,
              (io.grpc.stub.StreamObserver<si.mlimedija.proto.PutDataResponse>) responseObserver);
          break;
        case METHODID_GET_DATA:
          serviceImpl.getData((si.mlimedija.proto.GetDataRequest) request,
              (io.grpc.stub.StreamObserver<si.mlimedija.proto.GetDataResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class masterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    masterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return si.mlimedija.proto.Master.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("master");
    }
  }

  private static final class masterFileDescriptorSupplier
      extends masterBaseDescriptorSupplier {
    masterFileDescriptorSupplier() {}
  }

  private static final class masterMethodDescriptorSupplier
      extends masterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    masterMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (masterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new masterFileDescriptorSupplier())
              .addMethod(getPutDataMethod())
              .addMethod(getGetDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
