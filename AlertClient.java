package client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import server.AlertServer;
import smart.air.pollution.alert.*;
import com.google.protobuf.Empty;

import java.util.Random;

public class AlertClient {

    // Defining main function
    public static void main(String[] args) throws InterruptedException {

        // Creating a channel to connect to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
        // Creating a blocking stub to call the service methods
        AlertServiceGrpc.AlertServiceStub blockingStub = AlertServiceGrpc.newStub(channel);
        subscribe(blockingStub);
        unsubscribe(blockingStub);

        channel.shutdown();

    }
static  void subscribe(AlertServiceGrpc.AlertServiceStub blockingStub){
    // Defining a stream observer to get the response from the service
    StreamObserver<SubscribeAlertResponse> responseObserver = new StreamObserver<SubscribeAlertResponse>() {
        @Override
        public void onNext(SubscribeAlertResponse value) {
            System.out.println("subscribe alert: " + value.getMessage());
        }

        // Defining onError method to handle errors
        @Override
        public void onError(Throwable t) {

        }

        @Override
        public void onCompleted() {
            System.out.println("completed ");

        }

    };

    // Creating a request observer to send the request to the service
    StreamObserver<SubscribeToPollutantAlertsRequest> requestObserver = blockingStub.subscribeToAlerts(responseObserver);


    try {

        requestObserver.onNext(SubscribeToPollutantAlertsRequest.newBuilder().setLocation("dublin").setPollutants(Pollutant.newBuilder()
                .setName("XYZ").setLevel(2.0f).build()).build());
        // Mark the end of requests
        requestObserver.onCompleted();


        // Sleep for a bit before sending the next one.
        Thread.sleep(new Random().nextInt(1000) + 500);


    } catch (RuntimeException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

}
static  void unsubscribe(AlertServiceGrpc.AlertServiceStub blockingStub){
    StreamObserver<UnSubscribeAlertResponse> responseObserver = new StreamObserver<UnSubscribeAlertResponse>() {
        @Override
        public void onNext(UnSubscribeAlertResponse value) {
            System.out.println("unsubscribe alert: " + value.getMessage());
        }

        @Override
        public void onError(Throwable t) {

        }

        @Override
        public void onCompleted() {
            System.out.println("completed ");

        }

    };

    StreamObserver<UnsubscribeFromAlertsRequest> requestObserver = blockingStub.unsubscribeFromAlerts(responseObserver);


    try {

        requestObserver.onNext(UnsubscribeFromAlertsRequest.newBuilder().setLocation("dublin").build());
        // Mark the end of requests
        requestObserver.onCompleted();


        // Sleep for a bit before sending the next one.
        Thread.sleep(new Random().nextInt(1000) + 500);


    } catch (RuntimeException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

}


}
