package client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import smart.air.pollution.airquality.*;

public class AirQualityClient {

    // define the main method
    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        AirQualityServiceGrpc.AirQualityServiceBlockingStub blockingStub = AirQualityServiceGrpc.newBlockingStub(channel);

        try {
            //preparing message to send
            GetLatestAirQualityDataRequest request = GetLatestAirQualityDataRequest.newBuilder().setLocation("dublin").build();

            //retrieving reply from service
            GetLatestAirQualityDataResponse response = blockingStub.getLatestAirQualityData(request);

            Pollutant pollutant = response.getPollutants();
            System.out.println(pollutant.getName() + "," + pollutant.getLevel());
            System.out.println(response.getAqi());
            System.out.println(response.getHealthEffects());


            //preparing message to send
            GetAirQualityDataByTimeRangeRequest airQualityDataByTimeRangeRequest = GetAirQualityDataByTimeRangeRequest.newBuilder()
                    .setStartTime(10).setEndTime(66).setLocation("dublin").build();

            //retrieving reply from service
            GetAirQualityDataByTimeRangeResponse airQualityDataByTimeRangeResponse = blockingStub.getAirQualityDataByTimeRange(airQualityDataByTimeRangeRequest).next();
            Pollutant pollutant1 = airQualityDataByTimeRangeResponse.getPollutants();
            System.out.println(pollutant1.getName() + "," + pollutant1.getLevel());

            System.out.println(airQualityDataByTimeRangeResponse.getAqi());
            System.out.println(airQualityDataByTimeRangeResponse.getTimeStamp());
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
        } finally {
            channel.shutdown();
        }
    }
}
