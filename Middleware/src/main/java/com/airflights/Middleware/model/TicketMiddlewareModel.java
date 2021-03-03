package com.airflights.Middleware.model;

import Shared.Request;
import Shared.Ticket;
import com.airflights.Middleware.network.SocketClient;

import java.io.IOException;
import java.util.List;

public class TicketMiddlewareModel implements TicketMiddleware
{
  private SocketClient client;

  public TicketMiddlewareModel()
  {
    this.client = new SocketClient();
  }

  @Override public Ticket getTicket(int passportnum, int flightid)
  {
    Request request = new Request("GETTicket", passportnum, Integer.toString(flightid));
    try
    {
      Ticket ticket = (Ticket) client.request(request).getArg();
      return ticket;
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void CancelFlight(int passportnum, int flightid)
  {
    Request request = new Request("REMOVETicket", passportnum, Integer.toString(flightid));
    try
    {
      client.request(request);
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public String checkAvailability(int seatNum, int flightID)
  {
    Request request = new Request("CheckAvailability", seatNum, flightID, null);
    try
    {
      Ticket ticket = (Ticket) client.request(request).getArg();
      if (ticket == null)
      {
        return "true";
      }
      else
      {
        return "false";
      }

    }
    catch (IOException | ClassNotFoundException e)
    {
      return "true";
    }
  }

  @Override public void BookAFlight(int passportNum, int flightId, int seatNum,
      Ticket luggage)
  {
    Request request = new Request("BookAFlight", luggage, passportNum, flightId,
        seatNum);
    try
    {
      client.request(request);
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public List<Integer> getTickets(int flightID)
  {
    Request request = new Request("GetTickets", flightID);
    try
    {
      List<Integer> ticket = (List<Integer>) client.request(request).getArg();
      return ticket;
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
