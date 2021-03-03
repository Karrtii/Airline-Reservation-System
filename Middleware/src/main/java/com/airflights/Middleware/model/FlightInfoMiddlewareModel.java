package com.airflights.Middleware.model;

import Shared.*;
import com.airflights.Middleware.network.SocketClient;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightInfoMiddlewareModel implements FlightInfoMiddleware
{
  private SocketClient client;

  public FlightInfoMiddlewareModel()
  {
    this.client = new SocketClient();
  }

  @Override public List<FlightInfo> getClosestFlights(Timestamp departure,
      Timestamp dearptureback, String fromwhere, String whereto,
      int numberofpeople)
  {
    Date date = Date.valueOf("0001-01-02");
    if (dearptureback.before(date))
    {
      Request request = new Request("GETDepartureByName", fromwhere);
      try
      {
        List<Departure> allDepartures = (List<Departure>) client
            .request(request).getArg();
        request = new Request("GETArrivalByName", whereto);
        List<Arrival> allArrivals = (List<Arrival>) client.request(request)
            .getArg();
        return ManageFlightSearch(allDepartures, allArrivals, fromwhere,
            whereto, departure, numberofpeople);
      }
      catch (IOException | ClassNotFoundException e)
      {
        e.printStackTrace();
      }
    }
    else
    {

    }
    return null;
  }

  @Override public FlightInfo getFlightInfo(int flightid)
  {
    Request request = new Request("GETFlightByID", flightid);
    try
    {
      Flight flight = (Flight) client.request(request).getArg();
      request = new Request("GETArrival", flightid);
      Arrival arrival = (Arrival) client.request(request).getArg();
      request = new Request("GETDeparture", flightid);
      Departure departure = (Departure) client.request(request).getArg();
      return new FlightInfo(flight, arrival, departure);
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  private List<FlightInfo> getAllFlightsOfUser(String email)
  {
    Request request = new Request("GETMyPassengers", email);
    try
    {
      List<Passenger> passengers = (List<Passenger>) client.request(request)
          .getArg();
      List<FlightInfo> allFlights = new ArrayList<>();
      for (Passenger p : passengers)
      {
        List<Flight> passengerFlights = new ArrayList<>();
        request = new Request("GETMyFlights", p.getPassportNumber());
        passengerFlights
            .addAll((List<Flight>) client.request(request).getArg());
        for (Flight f : passengerFlights)
        {
          request = new Request("GETArrival", f.id);
          Arrival arrival = (Arrival) client.request(request).getArg();
          request = new Request("GETDeparture", f.id);
          Departure departure = (Departure) client.request(request).getArg();
          allFlights.add(new FlightInfo(f, arrival, departure, p));
        }
      }
      return allFlights;
    }
    catch (IOException | ClassNotFoundException | NullPointerException e)
    {
      return null;
    }
  }

  @Override public List<FlightInfo> getMyFlightInfos(String email)
  {
    List<FlightInfo> allFlights = getAllFlightsOfUser(email);
    List<FlightInfo> allExceptFinishedFlights = new ArrayList<>();

    if (allFlights != null)
    {
      for (FlightInfo f : allFlights)
      {
        if (f.flight.status.equals("on time") || f.flight.status
            .equals("delayed") || f.flight.status.equals("cancelled"))
        {
          allExceptFinishedFlights.add(f);
        }
      }
    }

    return allExceptFinishedFlights;
  }

  @Override public List<FlightInfo> getMyFlightInfosFinished(String email,
      String status)
  {
    List<FlightInfo> allFlights = getAllFlightsOfUser(email);
    List<FlightInfo> finishedFlights = new ArrayList<>();
    if(allFlights != null)
    {
      for (FlightInfo f : allFlights)
      {
        if (f.flight.status.equals("finished"))
        {
          finishedFlights.add(f);
        }
      }
    }
    return finishedFlights;
  }

  @Override public List<FlightInfo> getAllFlightInfos()
  {
    try
    {
      Request request = new Request("GETDepartureByName",null);
      List<Departure> departures = (List<Departure>)client.request(request).getArg();
      request = new Request("GETArrivalByName",null);
      List<Arrival> arrivals = (List<Arrival>)client.request(request).getArg();
      request = new Request("GETFlights",null);
      List<Flight> flights = (List<Flight>)client.request(request).getArg();
      List<FlightInfo> allflights = new ArrayList<>();
      if(allflights != null)
      {
        for (int i = 0; i < flights.size(); i++)
        {
          allflights.add(new FlightInfo(flights.get(i),arrivals.get(i),departures.get(i)));
        }
      }
      return allflights;
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public String checkIfNotCancelled(String email)
  {
    List<FlightInfo> allFlights = getAllFlightsOfUser(email);
    for (FlightInfo f:allFlights)
    {
      if(f.flight.status.equals("cancelled"))
      {
        return "true";
      }
    }
    return "false";
  }

  @Override public String checkIfNotDelayed(String email)
  {
    List<FlightInfo> allFlights = getAllFlightsOfUser(email);
    for (FlightInfo f:allFlights)
    {
      if(f.flight.status.equals("delayed"))
      {
        return "true";
      }
    }
    return "false";
  }

  private List<FlightInfo> ManageFlightSearch(List<Departure> allDepartures,
      List<Arrival> allArrivals, String fromwhere, String whereto,
      Timestamp departure, int numberOfPassengers)
  {
    List<FlightInfo> flightInfos = new ArrayList<>();
    List<Arrival> wishedArrivals = new ArrayList<>();
    List<Departure> wishedDepartures = new ArrayList<>();
    for (int i = 0; i < allDepartures.size(); i++)
    {
      if (allArrivals.get(i).fromWhere.equals(whereto) && allDepartures
          .get(i).fromWhere.equals(fromwhere))
      {

        wishedArrivals.add(allArrivals.get(i));
        wishedDepartures.add(allDepartures.get(i));
      }
    }
    for (int i = 0; i < wishedArrivals.size(); i++)
    {
      if (wishedDepartures.get(i).flightID == wishedArrivals.get(i).flightID)
      {
        Request request = new Request("GETFlightByID",
            wishedArrivals.get(i).flightID);
        try
        {
          flightInfos.add(
              new FlightInfo((Flight) client.request(request).getArg(),
                  wishedArrivals.get(i), wishedDepartures.get(i)));
        }
        catch (IOException | ClassNotFoundException e)
        {
          e.printStackTrace();
        }
      }
    }

    Date wishedDepartureDateSQL = new Date(departure.getTime());
    LocalDate wishedDepartureLocalDate = wishedDepartureDateSQL.toLocalDate();
    List<FlightInfo> flightInfosWithRightDate = new ArrayList<>();
    for (int i = 0; i < flightInfos.size(); i++)
    {
      Date dateOfDepartureSQL = new Date(
          flightInfos.get(i).departure.departureTime.getTime());
      LocalDate localDateOfDeparture = dateOfDepartureSQL.toLocalDate();
      if (wishedDepartureLocalDate.minusDays(1).equals(localDateOfDeparture)
          || wishedDepartureLocalDate.minusDays(2).equals(localDateOfDeparture)
          || wishedDepartureLocalDate.equals(localDateOfDeparture)
          || wishedDepartureLocalDate.plusDays(1).equals(localDateOfDeparture)
          || wishedDepartureLocalDate.plusDays(2).equals(localDateOfDeparture))
      {
        flightInfosWithRightDate.add(flightInfos.get(i));
      }
    }
    List<FlightInfo> finalFlightInfos = new ArrayList<>();
    for (int i = 0; i < flightInfosWithRightDate.size(); i++)
    {
      if (flightInfosWithRightDate.get(i).flight.numberOfSeatsRemaining
          - numberOfPassengers >= 0)
      {
        finalFlightInfos.add(flightInfosWithRightDate.get(i));
      }
    }
    return finalFlightInfos;
  }
}
