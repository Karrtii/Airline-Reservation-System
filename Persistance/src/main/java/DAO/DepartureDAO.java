package DAO;

import Shared.Departure;

import java.util.List;

public interface DepartureDAO
{
  void addDeparture(Departure newDeparture,int FlightID);
  List<Departure> getDeparturesByName(String name);
  List<Departure> getAllDepartures();
  Departure getDepartureByID(int id);
  void delay(int flightID,int minutes);
}
