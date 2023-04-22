package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import smart.air.pollution.historicaldata.GetHistoricalDataRequest;
import smart.air.pollution.historicaldata.GetHistoricalDataResponse;
import smart.air.pollution.historicaldata.HistoricalDataServiceGrpc;
import smart.air.pollution.historicaldata.Pollutant;
import util.JmdnsRegisterDiscoverUtil;
import io.grpc.Metadata;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;

public class HistoricalDataServer extends HistoricalDataServiceGrpc.HistoricalDataServiceImplBase {
    public static void main(String[] args) {
        HistoricalDataServer historicalDataServer = new HistoricalDataServer();

        Properties prop = JmdnsRegisterDiscoverUtil.getProperties("src/main/resources/historicaldataservice.properties");
        try {
            JmdnsRegisterDiscoverUtil.registerService(prop);
            int port = Integer.parseInt( prop.getProperty("service_port") );
            Server server = ServerBuilder.forPort(port)
                    .addService(historicalDataServer)
                    .build()
                    .start();

            System.out.println("HistoricalDataServer started, listening on " + port);

            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public StreamObserver<GetHistoricalDataRequest> getHistoricalData(StreamObserver<GetHistoricalDataResponse> responseObserver) {

        return new StreamObserver<GetHistoricalDataRequest>() {
            @Override
            public void onNext(GetHistoricalDataRequest request) {
                // for (int i = 1; i <= 5; i++) {
                GetHistoricalDataResponse getHistoricalDataResponse= GetHistoricalDataResponse.newBuilder()
                        .setAQI(1)
                        .setPollutants(Pollutant.newBuilder().setName(request.getLocation()).setLevel(4.0f).build())
                        .setTimeStamp(new Date().getTime())
                        .build();
                // Creating a new metadata object
                Metadata metadata = new Metadata();
                // Add a custom metadata key-value pair
                metadata.put(Metadata.Key.of("MY_METADATA_KEY", Metadata.ASCII_STRING_MARSHALLER), "MY_METADATA_VALUE");
                // Call the responseObserver with the response and metadata
                responseObserver.onNext(getHistoricalDataResponse);
                //}

            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
