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

  public static final String SERVICE_NAME = "Master.master";

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
                  "Master.master", "putData"))
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
                  "Master.master", "getData"))
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

  private static volatile io.grpc.MethodDescriptor<si.mlimedija.proto.PutFileEndpointRequest,
      si.mlimedija.proto.PutFileEndpointResponse> getPutFileEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "putFileEndpoint",
      requestType = si.mlimedija.proto.PutFileEndpointRequest.class,
      responseType = si.mlimedija.proto.PutFileEndpointResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<si.mlimedija.proto.PutFileEndpointRequest,
      si.mlimedija.proto.PutFileEndpointResponse> getPutFileEndpointMethod() {
    io.grpc.MethodDescriptor<si.mlimedija.proto.PutFileEndpointRequest, si.mlimedija.proto.PutFileEndpointResponse> getPutFileEndpointMethod;
    if ((getPutFileEndpointMethod = masterGrpc.getPutFileEndpointMethod) == null) {
      synchronized (masterGrpc.class) {
        if ((getPutFileEndpointMethod = masterGrpc.getPutFileEndpointMethod) == null) {
          masterGrpc.getPutFileEndpointMethod = getPutFileEndpointMethod = 
              io.grpc.MethodDescriptor.<si.mlimedija.proto.PutFileEndpointRequest, si.mlimedija.proto.PutFileEndpointResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Master.master", "putFileEndpoint"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.PutFileEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.PutFileEndpointResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new masterMethodDescriptorSupplier("putFileEndpoint"))
                  .build();
          }
        }
     }
     return getPutFileEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<si.mlimedija.proto.GetFileEndpointRequest,
      si.mlimedija.proto.GetFileEndpointResponse> getGetFileEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getFileEndpoint",
      requestType = si.mlimedija.proto.GetFileEndpointRequest.class,
      responseType = si.mlimedija.proto.GetFileEndpointResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<si.mlimedija.proto.GetFileEndpointRequest,
      si.mlimedija.proto.GetFileEndpointResponse> getGetFileEndpointMethod() {
    io.grpc.MethodDescriptor<si.mlimedija.proto.GetFileEndpointRequest, si.mlimedija.proto.GetFileEndpointResponse> getGetFileEndpointMethod;
    if ((getGetFileEndpointMethod = masterGrpc.getGetFileEndpointMethod) == null) {
      synchronized (masterGrpc.class) {
        if ((getGetFileEndpointMethod = masterGrpc.getGetFileEndpointMethod) == null) {
          masterGrpc.getGetFileEndpointMethod = getGetFileEndpointMethod = 
              io.grpc.MethodDescriptor.<si.mlimedija.proto.GetFileEndpointRequest, si.mlimedija.proto.GetFileEndpointResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Master.master", "getFileEndpoint"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.GetFileEndpointRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.GetFileEndpointResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new masterMethodDescriptorSupplier("getFileEndpoint"))
                  .build();
          }
        }
     }
     return getGetFileEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<si.mlimedija.proto.PutKeysRequest,
      si.mlimedija.proto.PutKeysResponse> getPutKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "putKeys",
      requestType = si.mlimedija.proto.PutKeysRequest.class,
      responseType = si.mlimedija.proto.PutKeysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<si.mlimedija.proto.PutKeysRequest,
      si.mlimedija.proto.PutKeysResponse> getPutKeysMethod() {
    io.grpc.MethodDescriptor<si.mlimedija.proto.PutKeysRequest, si.mlimedija.proto.PutKeysResponse> getPutKeysMethod;
    if ((getPutKeysMethod = masterGrpc.getPutKeysMethod) == null) {
      synchronized (masterGrpc.class) {
        if ((getPutKeysMethod = masterGrpc.getPutKeysMethod) == null) {
          masterGrpc.getPutKeysMethod = getPutKeysMethod = 
              io.grpc.MethodDescriptor.<si.mlimedija.proto.PutKeysRequest, si.mlimedija.proto.PutKeysResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Master.master", "putKeys"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.PutKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.PutKeysResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new masterMethodDescriptorSupplier("putKeys"))
                  .build();
          }
        }
     }
     return getPutKeysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<si.mlimedija.proto.DeleteKeysRequest,
      si.mlimedija.proto.DeleteKeysResponse> getDeleteKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteKeys",
      requestType = si.mlimedija.proto.DeleteKeysRequest.class,
      responseType = si.mlimedija.proto.DeleteKeysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<si.mlimedija.proto.DeleteKeysRequest,
      si.mlimedija.proto.DeleteKeysResponse> getDeleteKeysMethod() {
    io.grpc.MethodDescriptor<si.mlimedija.proto.DeleteKeysRequest, si.mlimedija.proto.DeleteKeysResponse> getDeleteKeysMethod;
    if ((getDeleteKeysMethod = masterGrpc.getDeleteKeysMethod) == null) {
      synchronized (masterGrpc.class) {
        if ((getDeleteKeysMethod = masterGrpc.getDeleteKeysMethod) == null) {
          masterGrpc.getDeleteKeysMethod = getDeleteKeysMethod = 
              io.grpc.MethodDescriptor.<si.mlimedija.proto.DeleteKeysRequest, si.mlimedija.proto.DeleteKeysResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Master.master", "deleteKeys"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.DeleteKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.DeleteKeysResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new masterMethodDescriptorSupplier("deleteKeys"))
                  .build();
          }
        }
     }
     return getDeleteKeysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<si.mlimedija.proto.NodeHandshakeRequest,
      si.mlimedija.proto.NodeHandshakeResponse> getNodeHandshakeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "nodeHandshake",
      requestType = si.mlimedija.proto.NodeHandshakeRequest.class,
      responseType = si.mlimedija.proto.NodeHandshakeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<si.mlimedija.proto.NodeHandshakeRequest,
      si.mlimedija.proto.NodeHandshakeResponse> getNodeHandshakeMethod() {
    io.grpc.MethodDescriptor<si.mlimedija.proto.NodeHandshakeRequest, si.mlimedija.proto.NodeHandshakeResponse> getNodeHandshakeMethod;
    if ((getNodeHandshakeMethod = masterGrpc.getNodeHandshakeMethod) == null) {
      synchronized (masterGrpc.class) {
        if ((getNodeHandshakeMethod = masterGrpc.getNodeHandshakeMethod) == null) {
          masterGrpc.getNodeHandshakeMethod = getNodeHandshakeMethod = 
              io.grpc.MethodDescriptor.<si.mlimedija.proto.NodeHandshakeRequest, si.mlimedija.proto.NodeHandshakeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Master.master", "nodeHandshake"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.NodeHandshakeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  si.mlimedija.proto.NodeHandshakeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new masterMethodDescriptorSupplier("nodeHandshake"))
                  .build();
          }
        }
     }
     return getNodeHandshakeMethod;
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

    /**
     */
    public void putFileEndpoint(si.mlimedija.proto.PutFileEndpointRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.PutFileEndpointResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPutFileEndpointMethod(), responseObserver);
    }

    /**
     */
    public void getFileEndpoint(si.mlimedija.proto.GetFileEndpointRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.GetFileEndpointResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFileEndpointMethod(), responseObserver);
    }

    /**
     */
    public void putKeys(si.mlimedija.proto.PutKeysRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.PutKeysResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPutKeysMethod(), responseObserver);
    }

    /**
     */
    public void deleteKeys(si.mlimedija.proto.DeleteKeysRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.DeleteKeysResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteKeysMethod(), responseObserver);
    }

    /**
     */
    public void nodeHandshake(si.mlimedija.proto.NodeHandshakeRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.NodeHandshakeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getNodeHandshakeMethod(), responseObserver);
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
          .addMethod(
            getPutFileEndpointMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                si.mlimedija.proto.PutFileEndpointRequest,
                si.mlimedija.proto.PutFileEndpointResponse>(
                  this, METHODID_PUT_FILE_ENDPOINT)))
          .addMethod(
            getGetFileEndpointMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                si.mlimedija.proto.GetFileEndpointRequest,
                si.mlimedija.proto.GetFileEndpointResponse>(
                  this, METHODID_GET_FILE_ENDPOINT)))
          .addMethod(
            getPutKeysMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                si.mlimedija.proto.PutKeysRequest,
                si.mlimedija.proto.PutKeysResponse>(
                  this, METHODID_PUT_KEYS)))
          .addMethod(
            getDeleteKeysMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                si.mlimedija.proto.DeleteKeysRequest,
                si.mlimedija.proto.DeleteKeysResponse>(
                  this, METHODID_DELETE_KEYS)))
          .addMethod(
            getNodeHandshakeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                si.mlimedija.proto.NodeHandshakeRequest,
                si.mlimedija.proto.NodeHandshakeResponse>(
                  this, METHODID_NODE_HANDSHAKE)))
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

    /**
     */
    public void putFileEndpoint(si.mlimedija.proto.PutFileEndpointRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.PutFileEndpointResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutFileEndpointMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFileEndpoint(si.mlimedija.proto.GetFileEndpointRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.GetFileEndpointResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFileEndpointMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putKeys(si.mlimedija.proto.PutKeysRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.PutKeysResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutKeysMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteKeys(si.mlimedija.proto.DeleteKeysRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.DeleteKeysResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteKeysMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void nodeHandshake(si.mlimedija.proto.NodeHandshakeRequest request,
        io.grpc.stub.StreamObserver<si.mlimedija.proto.NodeHandshakeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getNodeHandshakeMethod(), getCallOptions()), request, responseObserver);
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

    /**
     */
    public si.mlimedija.proto.PutFileEndpointResponse putFileEndpoint(si.mlimedija.proto.PutFileEndpointRequest request) {
      return blockingUnaryCall(
          getChannel(), getPutFileEndpointMethod(), getCallOptions(), request);
    }

    /**
     */
    public si.mlimedija.proto.GetFileEndpointResponse getFileEndpoint(si.mlimedija.proto.GetFileEndpointRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetFileEndpointMethod(), getCallOptions(), request);
    }

    /**
     */
    public si.mlimedija.proto.PutKeysResponse putKeys(si.mlimedija.proto.PutKeysRequest request) {
      return blockingUnaryCall(
          getChannel(), getPutKeysMethod(), getCallOptions(), request);
    }

    /**
     */
    public si.mlimedija.proto.DeleteKeysResponse deleteKeys(si.mlimedija.proto.DeleteKeysRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteKeysMethod(), getCallOptions(), request);
    }

    /**
     */
    public si.mlimedija.proto.NodeHandshakeResponse nodeHandshake(si.mlimedija.proto.NodeHandshakeRequest request) {
      return blockingUnaryCall(
          getChannel(), getNodeHandshakeMethod(), getCallOptions(), request);
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

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<si.mlimedija.proto.PutFileEndpointResponse> putFileEndpoint(
        si.mlimedija.proto.PutFileEndpointRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPutFileEndpointMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<si.mlimedija.proto.GetFileEndpointResponse> getFileEndpoint(
        si.mlimedija.proto.GetFileEndpointRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFileEndpointMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<si.mlimedija.proto.PutKeysResponse> putKeys(
        si.mlimedija.proto.PutKeysRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPutKeysMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<si.mlimedija.proto.DeleteKeysResponse> deleteKeys(
        si.mlimedija.proto.DeleteKeysRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteKeysMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<si.mlimedija.proto.NodeHandshakeResponse> nodeHandshake(
        si.mlimedija.proto.NodeHandshakeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getNodeHandshakeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PUT_DATA = 0;
  private static final int METHODID_GET_DATA = 1;
  private static final int METHODID_PUT_FILE_ENDPOINT = 2;
  private static final int METHODID_GET_FILE_ENDPOINT = 3;
  private static final int METHODID_PUT_KEYS = 4;
  private static final int METHODID_DELETE_KEYS = 5;
  private static final int METHODID_NODE_HANDSHAKE = 6;

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
        case METHODID_PUT_FILE_ENDPOINT:
          serviceImpl.putFileEndpoint((si.mlimedija.proto.PutFileEndpointRequest) request,
              (io.grpc.stub.StreamObserver<si.mlimedija.proto.PutFileEndpointResponse>) responseObserver);
          break;
        case METHODID_GET_FILE_ENDPOINT:
          serviceImpl.getFileEndpoint((si.mlimedija.proto.GetFileEndpointRequest) request,
              (io.grpc.stub.StreamObserver<si.mlimedija.proto.GetFileEndpointResponse>) responseObserver);
          break;
        case METHODID_PUT_KEYS:
          serviceImpl.putKeys((si.mlimedija.proto.PutKeysRequest) request,
              (io.grpc.stub.StreamObserver<si.mlimedija.proto.PutKeysResponse>) responseObserver);
          break;
        case METHODID_DELETE_KEYS:
          serviceImpl.deleteKeys((si.mlimedija.proto.DeleteKeysRequest) request,
              (io.grpc.stub.StreamObserver<si.mlimedija.proto.DeleteKeysResponse>) responseObserver);
          break;
        case METHODID_NODE_HANDSHAKE:
          serviceImpl.nodeHandshake((si.mlimedija.proto.NodeHandshakeRequest) request,
              (io.grpc.stub.StreamObserver<si.mlimedija.proto.NodeHandshakeResponse>) responseObserver);
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
              .addMethod(getPutFileEndpointMethod())
              .addMethod(getGetFileEndpointMethod())
              .addMethod(getPutKeysMethod())
              .addMethod(getDeleteKeysMethod())
              .addMethod(getNodeHandshakeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
