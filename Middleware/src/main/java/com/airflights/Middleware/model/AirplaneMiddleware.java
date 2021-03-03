package com.airflights.Middleware.model;

import Shared.Airplane;

import java.util.List;

public interface AirplaneMiddleware
{
  List<Airplane> getPlanes();
  Airplane getAirplaneByType(String type);
  Airplane getTypeById(int flightId);
}
