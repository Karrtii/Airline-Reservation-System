package com.airflights.Middleware.model;

import Shared.FlightInfo;

import java.sql.Timestamp;
import java.util.List;

public interface FlightInfoMiddleware
{
  List<FlightInfo> getClosestFlights(Timestamp departure,Timestamp dearptureback,String fromwhere,String whereto,int numberofpeople);
  FlightInfo getFlightInfo(int flightid);
  List<FlightInfo> getMyFlightInfos(String email);
  List<FlightInfo> getMyFlightInfosFinished(String email,String status);
  List<FlightInfo> getAllFlightInfos();
  String checkIfNotCancelled(String email);
  String checkIfNotDelayed(String email);
}
