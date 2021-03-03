package com.airflights.Middleware.model;

import Shared.Airport;

import java.util.List;

public interface AirportMiddleware
{
  List<Airport> getAirports();
  Airport getIATAByName(String name);
  Airport getAirportByIATA(String iata);
}
