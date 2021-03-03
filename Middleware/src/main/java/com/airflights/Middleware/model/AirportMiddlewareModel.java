package com.airflights.Middleware.model;

import Shared.Airport;
import Shared.Request;
import com.airflights.Middleware.network.SocketClient;

import java.io.IOException;
import java.util.List;

public class AirportMiddlewareModel implements AirportMiddleware
{
  private SocketClient client;

  public AirportMiddlewareModel()
  {
   this.client = new SocketClient();
  }

  @Override public List<Airport> getAirports()
  {
    Request request = new Request("GETAirports", null);
    List<Airport> airports;
    try
    {
      airports = (List<Airport>) client.request(request).getArg();
      return airports;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public Airport getIATAByName(String name)
  {
    Request request = new Request("GETIATACodeByName", name);
    try
    {
      return (Airport) client.request(request).getArg();
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public Airport getAirportByIATA(String iata)
  {
    Request request = new Request("GETAirportByIATA", iata);
    try
    {
      Airport airport = (Airport) client.request(request).getArg();
      return airport;
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
