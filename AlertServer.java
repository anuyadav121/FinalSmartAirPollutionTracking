package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import smart.air.pollution.alert.*;
import util.JmdnsRegisterDiscoverUtil;

import java.io.IOException;
import java.util.Properties;

public class AlertServer extends AlertServiceGrpc.AlertServiceImplBase {
    public static void main(String[] args) {
        AlertServer alertServer = new AlertServer();
        Properties prop = JmdnsRegisterDiscoverUtil.getProperties("src/main/resources/alertservice.properties");
        try {
            JmdnsRegisterDiscoverUtil.registerService(prop);
            int port = Integer.parseInt( prop.getProperty("service_port") );
            Server server = ServerBuilder.forPort(port)
                    .addService(alertServer)
                    .build()
                    .start();

            System.out.println("AlertServer started, listening on " + port);

            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public StreamObserver<SubscribeToPollutantAlertsRequest> subscribeToAlerts(StreamObserver<SubscribeAlertResponse> responseObserver) {
        return new StreamObserver<SubscribeToPollutantAlertsRequest>() {
            String  alertResponse=null;
            public void onNext(SubscribeToPollutantAlertsRequest value) {
//
                alertResponse="Successfully subscribe to location "+value.getLocation()
                        +"Pollutant name:"+value.getPollutants().getName() +"level:"+value.getPollutants().getLevel();
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                SubscribeAlertResponse subscribeAlertResponse=SubscribeAlertResponse.newBuilder().setMessage(alertResponse).build();
                System.out.println("Stream completed");
                responseObserver.onNext(subscribeAlertResponse);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<UnsubscribeFromAlertsRequest> unsubscribeFromAlerts(StreamObserver<UnSubscribeAlertResponse> responseObserver) {
        return new StreamObserver<UnsubscribeFromAlertsRequest>() {
            String  alertResponse=null;
            public void onNext(UnsubscribeFromAlertsRequest value) {
                System.out.println("unsubscribe request for location: " + value.getLocation());

                alertResponse="Successfully unsubscribe to location "+value.getLocation();
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                UnSubscribeAlertResponse unSubscribeAlertResponse=UnSubscribeAlertResponse.newBuilder().setMessage(alertResponse).build();
                System.out.println("Stream completed");
                responseObserver.onNext(unSubscribeAlertResponse);
                responseObserver.onCompleted();
            }
        };
    }

}


