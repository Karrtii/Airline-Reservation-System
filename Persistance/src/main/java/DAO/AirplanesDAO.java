package DAO;

import Shared.Airplane;

import java.util.List;

public interface AirplanesDAO
{
  List<Airplane> getPlanes();
  Airplane getAirplaneByType(String type);
  Airplane getTypeByID(int flightId);
}
