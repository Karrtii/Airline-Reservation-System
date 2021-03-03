package com.airflights.Middleware.model;

import Shared.Passenger;

import java.util.List;

public interface PassengerMiddleware
{
  boolean passengerExists(Passenger passenger);
  Passenger registerPassenger(Passenger newPassenger,String email);
  List<Passenger> getMyPassengers(String email);
  Passenger getPassenger(int passportNumber);
  String CheckPassenger(Passenger passenger);
}
