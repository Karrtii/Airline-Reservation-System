package com.airflights.Middleware.model;

import Shared.Passenger;
import Shared.Request;
import com.airflights.Middleware.network.SocketClient;

import java.io.IOException;
import java.util.List;

public class PassengerMiddlewareModel implements PassengerMiddleware
{
  private SocketClient client;

  public PassengerMiddlewareModel()
  {
    this.client = new SocketClient();
  }

  @Override public List<Passenger> getMyPassengers(String email)
  {
    Request request = new Request("GETMyPassengers", email);
    try
    {
      List<Passenger> passengers = (List<Passenger>) client.request(request)
          .getArg();
      return passengers;
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public boolean passengerExists(Passenger passenger)
  {
    Request request = new Request("GETPassenger",
        passenger.getPassportNumber());
    try
    {
      Passenger passenger1 = (Passenger) client.request(request).getArg();
      if (passenger1 != null)
      {
        return true;
      }
      else
      {
        return false;
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      return true;
    }
  }

  @Override public Passenger getPassenger(int passportNumber)
  {
    Request request = new Request("GETPassenger", passportNumber);
    try
    {
      Passenger passenger = (Passenger) client.request(request).getArg();
      return passenger;
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public String CheckPassenger(Passenger passenger)
  {
    Request request = new Request("GETPassenger",
        passenger.getPassportNumber());
    try
    {
      Passenger passInDatabase = (Passenger) client.request(request).getArg();
      if (passInDatabase == null)
      {
        return "true";
      }
      else
      {
        if (passenger.getFirstname().equals(passInDatabase.getFirstname())
            && passenger.getLastname().equals(passInDatabase.getLastname()))
        {
          return "true";
        }
        else
        {
          return "false";
        }
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      return "false";
    }
  }

  @Override public Passenger registerPassenger(Passenger newPassenger,
      String email)
  {
    Request request = new Request("RegisterPassenger", newPassenger, email);
    try
    {
      Passenger passenger = (Passenger) client.request(request).getArg();
      return passenger;
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
