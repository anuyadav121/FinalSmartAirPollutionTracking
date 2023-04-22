package server;

import com.google.protobuf.Timestamp;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import smart.air.pollution.airquality.*;
import util.JmdnsRegisterDiscoverUtil;

import java.io.IOException;
import java.time.Instant;
import java.util.Properties;

import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

public class AirQualityServer extends AirQualityServiceGrpc.AirQualityServiceImplBase {
    public static void main(String[] args) {
        AirQualityServer airQualityServer = new AirQualityServer();
        Properties prop = JmdnsRegisterDiscoverUtil.getProperties("src/main/resources/airqualityservice.properties");
        try {
            JmdnsRegisterDiscoverUtil.registerService(prop);
            int port = Integer.parseInt( prop.getProperty("service_port") );
            Server server = ServerBuilder.forPort(port)
                    .addService(airQualityServer)
                    .build()
                    .start();

            System.out.println("AirQualityServer started, listening on " + port);

            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void getLatestAirQualityData(GetLatestAirQualityDataRequest request,
                                        StreamObserver<GetLatestAirQualityDataResponse> responseObserver) {
        //prepare the value to be set back
        GetLatestAirQualityDataResponse reply = GetLatestAirQualityDataResponse
                .newBuilder()
                .setAqi(1)
                .setPollutants(Pollutant.newBuilder().setName(request.getLocation()).setLevel(4.0f).build())
                .setHealthEffects("Danger")
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    /**
     *
     */
    @Override
    public void getAirQualityDataByTimeRange(GetAirQualityDataByTimeRangeRequest request,
                                             StreamObserver<GetAirQualityDataByTimeRangeResponse> responseObserver) {
        //prepare the value to be set back
        GetAirQualityDataByTimeRangeResponse reply = GetAirQualityDataByTimeRangeResponse
                .newBuilder()
                .setAqi(1)
                .setPollutants(Pollutant.newBuilder().setName(request.getLocation()).setLevel(4.0f).build())
                .setTimeStamp(new java.sql.Timestamp(System.currentTimeMillis()).getTime())
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();

    }


}