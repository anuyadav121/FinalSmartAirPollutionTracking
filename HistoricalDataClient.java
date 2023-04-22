package client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import smart.air.pollution.historicaldata.GetHistoricalDataRequest;
import smart.air.pollution.historicaldata.GetHistoricalDataResponse;
import smart.air.pollution.historicaldata.HistoricalDataServiceGrpc;
import smart.air.pollution.historicaldata.Pollutant;

import java.util.Date;
import java.util.Random;


public class HistoricalDataClient {

    //main method of the program, which is the entry point
    public static void main(String[] args) throws InterruptedException {

    // a new gRPC channel to connect to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
        //a stub for making asynchronous calls to the server
        HistoricalDataServiceGrpc.HistoricalDataServiceStub asyncStub = HistoricalDataServiceGrpc.newStub(channel);

//passing the asyncStub object as an argument.
     clientSideStreamingGetStatistics(asyncStub);


    }

    //Method that implements client-side streaming
   static public void clientSideStreamingGetStatistics(HistoricalDataServiceGrpc.HistoricalDataServiceStub asyncStub) throws InterruptedException {
        //Defining a StreamObserver object to handle server responses
        StreamObserver<GetHistoricalDataResponse> responseObserver = new StreamObserver<GetHistoricalDataResponse>() {

            // Method to handle the response from the server
            @Override
            public void onNext(GetHistoricalDataResponse response) {
                System.out.println("AQI"+ response.getAQI());
                System.out.println("TimeStamp"+ response.getTimeStamp());
                System.out.println("name"+ response.getPollutants().getName());
                System.out.println("location"+ response.getPollutants().getLevel());
            }

            // Method to handle any errors
            @Override
            public void onError(Throwable t) {
                System.out.println("error : "+t);

            }

            @Override
            public void onCompleted() {
                System.out.println("completed");
            }

            // Override OnError ...
        };

       // Defining a StreamObserver object to handle client requests
        StreamObserver<GetHistoricalDataRequest> requestObserver = asyncStub.getHistoricalData(responseObserver);
        try {
            // Creating a new request object to send to the server
                GetHistoricalDataRequest request= GetHistoricalDataRequest.newBuilder()
                        .setStartTime(new Date().getTime())
                        .setEndTime(new Date().getTime())
                        .setLocation("dublin").build();

                requestObserver.onNext(request);


            // Sleep for a bit before sending the next one.
            requestObserver.onCompleted();

            Thread.sleep(new Random().nextInt(1000) + 500);

        } catch (RuntimeException e) {
            // Handling any errors that may occur during the request/response cycle
            requestObserver.onError(e);
            throw e;
        }
    }
}