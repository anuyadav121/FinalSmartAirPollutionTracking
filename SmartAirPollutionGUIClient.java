package gui;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import smart.air.pollution.airquality.*;
import smart.air.pollution.airquality.Pollutant;
import smart.air.pollution.alert.*;
import smart.air.pollution.historicaldata.GetHistoricalDataRequest;
import smart.air.pollution.historicaldata.GetHistoricalDataResponse;
import smart.air.pollution.historicaldata.HistoricalDataServiceGrpc;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class SmartAirPollutionGUIClient implements ActionListener {


    private JTextField entry1, reply1;
    private JTextField startTimeEntry,endTimeEntry,locationEntry, reply2;
    private JTextField locationEntry3,nameEntry3,levelEntry3, reply3;
    private JTextField locationEntry4, reply4;

    private JTextField startTimeEntry5,endTimeEntry5,locationEntry5, reply5;


    private JPanel getLatestAirQualityDataJPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter location");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry1 = new JTextField("", 10);
        panel.add(entry1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("getLatestAirQualityData AirQualityService");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply1 = new JTextField("", 10);
        reply1.setEditable(false);
        panel.add(reply1);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getAirQualityDataByTimeRangeJPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel startTimeLabel = new JLabel("Enter Start time");
        panel.add(startTimeLabel);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        startTimeEntry = new JTextField("", 10);
        panel.add(startTimeEntry);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JLabel endTimeLabel = new JLabel("Enter End time");
        panel.add(endTimeLabel);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        endTimeEntry = new JTextField("", 10);
        panel.add(endTimeEntry);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JLabel locationLabel = new JLabel("Enter the Location");
        panel.add(locationLabel);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        locationEntry = new JTextField("", 10);
        panel.add(locationEntry);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("getAirQualityDataByTimeRangeRequest");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply2 = new JTextField("service response comes here",20);
        reply2.setEditable(false);
        panel.add(reply2);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getSubscribeToPollutantAlertsJPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter location");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        locationEntry3 = new JTextField("", 10);
        panel.add(locationEntry3);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

         label = new JLabel("Enter name");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        nameEntry3 = new JTextField("", 10);
        panel.add(nameEntry3);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

         label = new JLabel("Enter level");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        levelEntry3 = new JTextField("", 10);
        panel.add(levelEntry3);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));


        JButton button = new JButton("subscribeToPollutantAlerts");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply3 = new JTextField("", 10);
        reply3.setEditable(false);
        panel.add(reply3);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getUnsubscribeFromAlertsJPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter location");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        locationEntry4 = new JTextField("", 10);
        panel.add(locationEntry4);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("UnsubscribeFromAlerts");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply4 = new JTextField("", 10);
        reply4.setEditable(false);
        panel.add(reply4);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getHistoricalDataServiceJPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel startTimeLabel = new JLabel("Enter Start time");
        panel.add(startTimeLabel);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        startTimeEntry5 = new JTextField("", 10);
        panel.add(startTimeEntry5);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JLabel endTimeLabel = new JLabel("Enter End time");
        panel.add(endTimeLabel);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        endTimeEntry5 = new JTextField("", 10);
        panel.add(endTimeEntry5);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JLabel locationLabel = new JLabel("Enter the Location");
        panel.add(locationLabel);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        locationEntry5 = new JTextField("", 10);
        panel.add(locationEntry5);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("GetHistoricalData");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply5 = new JTextField("service response comes here",20);
        reply5.setEditable(false);
        panel.add(reply5);

        panel.setLayout(boxlayout);

        return panel;
    }

    public static void main(String[] args) {

        SmartAirPollutionGUIClient gui = new SmartAirPollutionGUIClient();

        gui.build();
    }

    private void build() {

        JFrame frame = new JFrame("Smart Air Pollution");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the panel to add buttons
        JPanel panel = new JPanel();

        // Set the BoxLayout to be X_AXIS: from left to right
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        // Set border for the panel
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

        panel.add(getLatestAirQualityDataJPanel());
        panel.add(getAirQualityDataByTimeRangeJPanel());
        panel.add(getSubscribeToPollutantAlertsJPanel());
        panel.add(getUnsubscribeFromAlertsJPanel());
        panel.add(getHistoricalDataServiceJPanel());

        // Set size for the frame
        frame.setSize(300, 300);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String label = button.getActionCommand();

        if (label.equals("getLatestAirQualityData AirQualityService")) {
            System.out.println("getLatestAirQualityData AirQualityService ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            AirQualityServiceGrpc.AirQualityServiceBlockingStub blockingStub = AirQualityServiceGrpc.newBlockingStub(channel);

            //preparing message to send
            GetLatestAirQualityDataRequest request = GetLatestAirQualityDataRequest.newBuilder().setLocation(entry1.getText()).build();

            //retreving reply from service
            GetLatestAirQualityDataResponse response = blockingStub.getLatestAirQualityData(request);

            Pollutant pollutant = response.getPollutants();
            System.out.println(pollutant.getName() + "," + pollutant.getLevel());
            System.out.println(response.getAqi());
            System.out.println(response.getHealthEffects());
            reply1.setText("name:" + pollutant.getName() + ",level:" + pollutant.getLevel() + "aqi:" + response.getAqi() + "Health effects:" + response.getHealthEffects());


            //reply1.setText( String.valueOf( response.getLength()) );

        } else if (label.equals("getAirQualityDataByTimeRangeRequest")) {
            System.out.println("GetAirQualityDataByTimeRangeRequest ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            AirQualityServiceGrpc.AirQualityServiceBlockingStub blockingStub = AirQualityServiceGrpc.newBlockingStub(channel);
            //preparing message to send
            GetAirQualityDataByTimeRangeRequest airQualityDataByTimeRangeRequest = GetAirQualityDataByTimeRangeRequest.newBuilder()
                    .setStartTime(Integer.valueOf(startTimeEntry.getText())).setEndTime(Integer.valueOf(endTimeEntry.getText())).setLocation(locationEntry.getText()).build();

            //retreving reply from service
            GetAirQualityDataByTimeRangeResponse response = blockingStub.getAirQualityDataByTimeRange(airQualityDataByTimeRangeRequest).next();

            Pollutant pollutant = response.getPollutants();
            System.out.println(pollutant.getName() + "," + pollutant.getLevel());
            System.out.println(response.getAqi());
            System.out.println(response.getTimeStamp());
            reply2.setText("name:" + pollutant.getName() + ",level:" + pollutant.getLevel() + "aqi:" + response.getAqi() + "Time Stamp:" + response.getTimeStamp());


        }
         else if (label.equals("subscribeToPollutantAlerts")) {
            System.out.println("SubscribeToPollutantAlertsRequest ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
            AlertServiceGrpc.AlertServiceStub blockingStub = AlertServiceGrpc.newStub(channel);
            subscribe(blockingStub);

        }
     else if (label.equals("UnsubscribeFromAlerts")) {
            System.out.println("UnsubscribeFromAlerts ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
            AlertServiceGrpc.AlertServiceStub blockingStub = AlertServiceGrpc.newStub(channel);
            unsubscribe(blockingStub);

        }
        else {
            boolean historicalDataRequest;
            if (label.equals("GetHistoricalDataRequest")) historicalDataRequest = true;
            else historicalDataRequest = false;
            {
                System.out.println("GetHistoricalDataRequest ...");

                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
                HistoricalDataServiceGrpc.HistoricalDataServiceStub asyncStub = HistoricalDataServiceGrpc.newStub(channel);

                try {
                    clientSideStreamingGetStatistics(asyncStub);

                } catch (Exception e1) {

                    //reply4.setText( String.valueOf( response.getLength()) );
                }
            }
        }
    }
     private void clientSideStreamingGetStatistics(HistoricalDataServiceGrpc.HistoricalDataServiceStub asyncStub) throws InterruptedException {
        StreamObserver<GetHistoricalDataResponse> responseObserver = new StreamObserver<GetHistoricalDataResponse>() {
            @Override
            public void onNext(GetHistoricalDataResponse response) {
                reply5.setText("name:" + response.getPollutants().getName() + ",level:" + response.getPollutants().getLevel() + "aqi:" + response.getAQI() + "Time Stamp:" + response.getTimeStamp());

                System.out.println("AQI"+ response.getAQI());
                System.out.println("TimeStamp"+ response.getTimeStamp());
                System.out.println("name"+ response.getPollutants().getName());
                System.out.println("location"+ response.getPollutants().getLevel());
            }

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

        StreamObserver<GetHistoricalDataRequest> requestObserver = asyncStub.getHistoricalData(responseObserver);
        try {
//            for (int i = 1; i <= 5; i++) {
            GetHistoricalDataRequest request= GetHistoricalDataRequest.newBuilder()
                    .setStartTime(Integer.valueOf(startTimeEntry5.getText()))
                    .setEndTime(Integer.valueOf(endTimeEntry5.getText()))
                    .setLocation(locationEntry5.getText()).build();

            requestObserver.onNext(request);

//            }
            // Sleep for a bit before sending the next one.
            requestObserver.onCompleted();

            Thread.sleep(new Random().nextInt(1000) + 500);

        } catch (RuntimeException e) {
            requestObserver.onError(e);
            throw e;
        }
    }
      void subscribe(AlertServiceGrpc.AlertServiceStub blockingStub){
        StreamObserver<SubscribeAlertResponse> responseObserver = new StreamObserver<SubscribeAlertResponse>() {
            @Override
            public void onNext(SubscribeAlertResponse value) {
                reply3.setText("subscribe alert: " + value.getMessage());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("completed ");

            }

        };

        StreamObserver<SubscribeToPollutantAlertsRequest> requestObserver = blockingStub.subscribeToAlerts(responseObserver);




            requestObserver.onNext(SubscribeToPollutantAlertsRequest.newBuilder().setLocation(locationEntry3.getText()).setPollutants(smart.air.pollution.alert.Pollutant.newBuilder()
                    .setName(nameEntry3.getText()).setLevel(Float.valueOf(levelEntry3.getText())).build()).build());
            // Mark the end of requests
            requestObserver.onCompleted();




    }
      void unsubscribe(AlertServiceGrpc.AlertServiceStub blockingStub){
        StreamObserver<UnSubscribeAlertResponse> responseObserver = new StreamObserver<UnSubscribeAlertResponse>() {
            @Override
            public void onNext(UnSubscribeAlertResponse value) {
               reply4.setText("unsubscribe alert: " + value.getMessage());
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