package DAO;

import Shared.Airport;

import java.util.List;

public interface AirportsDAO
{
  List<Airport> getAirports();
  Airport getAirportByName(String name);
  Airport getAirportByIATA(String iata);
}
