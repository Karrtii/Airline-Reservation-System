package com.airflights.Middleware.model;

import Shared.Arrival;
import Shared.Departure;
import Shared.Flight;
import Shared.Request;
import com.airflights.Middleware.network.SocketClient;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class FlightMiddlewareModel implements FlightMiddleware
{
  private SocketClient client;

  public FlightMiddlewareModel()
  {
    this.client = new SocketClient();
  }

  @Override public List<Flight> getFlights()
  {
    Request request = new Request("GETFlights", null);
    try
    {
      return (List<Flight>) client.request(request).getArg();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void addFlight(Flight newFlight, Arrival newArrival,
      Departure newDepartures)
  {
    newArrival.arrivalTime.setTime(newArrival.arrivalTime.getTime()-3600000);
    newDepartures.departureTime.setTime(newDepartures.departureTime.getTime()-3600000);
    try
    {
      client.request(
          new Request("ADDFlight", newFlight, newArrival, newDepartures));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  @Override public void CheckFlights()
  {
    Request request = new Request("GETFlights", null);
    try
    {
      List<Flight> allFlights = (List<Flight>) client.request(request).getArg();
      for (Flight f:allFlights)
      {
        request = new Request("GETArrival", f.id);
        Arrival arrival = (Arrival) client.request(request).getArg();
        if(arrival.arrivalTime.toLocalDateTime().isBefore(LocalDateTime.now()))
        {
          request = new Request("SETFinished", f.id);
          client.request(request);
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  @Override public Flight setFlightStatus(String status,int flightID)
  {
    try
    {
      Request request = new Request("SETFlightStatus",flightID,status);
      client.request(request);
      request = new Request("GETFlightByID",flightID);
      return (Flight)client.request(request).getArg();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public Flight delayFlight(int flightID, int minutes)
  {
    try
    {
      Request request = new Request("DELAYFlight",flightID,Integer.toString(minutes));
      client.request(request);
      request = new Request("SETFlightStatus",flightID,"delayed");
      client.request(request);
      request = new Request("GETFlightByID",flightID);
      return (Flight) client.request(request).getArg();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
