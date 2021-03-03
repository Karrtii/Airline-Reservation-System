package DAO;

import Shared.Arrival;

import java.util.List;

public interface ArrivalDAO
{
  void addArrival(Arrival newArrival, int flightID);
  List<Arrival> getArrivalsByName(String name);
  List<Arrival> getAllArrivals();
  Arrival getArrivalById(int id);
  void delay(int flightID,int minutes);
}
