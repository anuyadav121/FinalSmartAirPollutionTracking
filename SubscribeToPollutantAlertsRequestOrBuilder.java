// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: AlertService.proto

package smart.air.pollution.alert;

public interface SubscribeToPollutantAlertsRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:SubscribeToPollutantAlertsRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string location = 1;</code>
   */
  java.lang.String getLocation();
  /**
   * <code>string location = 1;</code>
   */
  com.google.protobuf.ByteString
      getLocationBytes();

  /**
   * <code>.Pollutant pollutants = 2;</code>
   */
  boolean hasPollutants();
  /**
   * <code>.Pollutant pollutants = 2;</code>
   */
  smart.air.pollution.alert.Pollutant getPollutants();
  /**
   * <code>.Pollutant pollutants = 2;</code>
   */
  smart.air.pollution.alert.PollutantOrBuilder getPollutantsOrBuilder();
}
