package com.airflights.Middleware.model;

import Shared.Arrival;
import Shared.Departure;
import Shared.Flight;

import java.util.List;

public interface FlightMiddleware
{
  List<Flight> getFlights();
  void addFlight(Flight newFlight, Arrival newArrival, Departure newDeparture);
  void CheckFlights();
  Flight setFlightStatus(String status,int flightID);
  Flight delayFlight(int flightID,int minutes);
}
