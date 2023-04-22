package smart.air.pollution.historicaldata;

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
    comments = "Source: HistoricalDataService.proto")
public final class HistoricalDataServiceGrpc {

  private HistoricalDataServiceGrpc() {}

  public static final String SERVICE_NAME = "HistoricalDataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<smart.air.pollution.historicaldata.GetHistoricalDataRequest,
      smart.air.pollution.historicaldata.GetHistoricalDataResponse> getGetHistoricalDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHistoricalData",
      requestType = smart.air.pollution.historicaldata.GetHistoricalDataRequest.class,
      responseType = smart.air.pollution.historicaldata.GetHistoricalDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<smart.air.pollution.historicaldata.GetHistoricalDataRequest,
      smart.air.pollution.historicaldata.GetHistoricalDataResponse> getGetHistoricalDataMethod() {
    io.grpc.MethodDescriptor<smart.air.pollution.historicaldata.GetHistoricalDataRequest, smart.air.pollution.historicaldata.GetHistoricalDataResponse> getGetHistoricalDataMethod;
    if ((getGetHistoricalDataMethod = HistoricalDataServiceGrpc.getGetHistoricalDataMethod) == null) {
      synchronized (HistoricalDataServiceGrpc.class) {
        if ((getGetHistoricalDataMethod = HistoricalDataServiceGrpc.getGetHistoricalDataMethod) == null) {
          HistoricalDataServiceGrpc.getGetHistoricalDataMethod = getGetHistoricalDataMethod = 
              io.grpc.MethodDescriptor.<smart.air.pollution.historicaldata.GetHistoricalDataRequest, smart.air.pollution.historicaldata.GetHistoricalDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "HistoricalDataService", "GetHistoricalData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.air.pollution.historicaldata.GetHistoricalDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.air.pollution.historicaldata.GetHistoricalDataResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HistoricalDataServiceMethodDescriptorSupplier("GetHistoricalData"))
                  .build();
          }
        }
     }
     return getGetHistoricalDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HistoricalDataServiceStub newStub(io.grpc.Channel channel) {
    return new HistoricalDataServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HistoricalDataServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HistoricalDataServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HistoricalDataServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HistoricalDataServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HistoricalDataServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<smart.air.pollution.historicaldata.GetHistoricalDataRequest> getHistoricalData(
        io.grpc.stub.StreamObserver<smart.air.pollution.historicaldata.GetHistoricalDataResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetHistoricalDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetHistoricalDataMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                smart.air.pollution.historicaldata.GetHistoricalDataRequest,
                smart.air.pollution.historicaldata.GetHistoricalDataResponse>(
                  this, METHODID_GET_HISTORICAL_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class HistoricalDataServiceStub extends io.grpc.stub.AbstractStub<HistoricalDataServiceStub> {
    private HistoricalDataServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HistoricalDataServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HistoricalDataServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HistoricalDataServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<smart.air.pollution.historicaldata.GetHistoricalDataRequest> getHistoricalData(
        io.grpc.stub.StreamObserver<smart.air.pollution.historicaldata.GetHistoricalDataResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetHistoricalDataMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class HistoricalDataServiceBlockingStub extends io.grpc.stub.AbstractStub<HistoricalDataServiceBlockingStub> {
    private HistoricalDataServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HistoricalDataServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HistoricalDataServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HistoricalDataServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class HistoricalDataServiceFutureStub extends io.grpc.stub.AbstractStub<HistoricalDataServiceFutureStub> {
    private HistoricalDataServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HistoricalDataServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HistoricalDataServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HistoricalDataServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_HISTORICAL_DATA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HistoricalDataServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HistoricalDataServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_HISTORICAL_DATA:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getHistoricalData(
              (io.grpc.stub.StreamObserver<smart.air.pollution.historicaldata.GetHistoricalDataResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HistoricalDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HistoricalDataServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return smart.air.pollution.historicaldata.HistoricalDataServiceimpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HistoricalDataService");
    }
  }

  private static final class HistoricalDataServiceFileDescriptorSupplier
      extends HistoricalDataServiceBaseDescriptorSupplier {
    HistoricalDataServiceFileDescriptorSupplier() {}
  }

  private static final class HistoricalDataServiceMethodDescriptorSupplier
      extends HistoricalDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HistoricalDataServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HistoricalDataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HistoricalDataServiceFileDescriptorSupplier())
              .addMethod(getGetHistoricalDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
