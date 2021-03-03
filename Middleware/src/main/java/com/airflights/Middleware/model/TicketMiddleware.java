package com.airflights.Middleware.model;

import Shared.Ticket;

import java.util.List;

public interface TicketMiddleware
{
  void BookAFlight(int passportNum,int flightId,int seatNum, Ticket luggage);
  String checkAvailability(int seatNum, int flightId);
  List<Integer> getTickets(int flightID);
  Ticket getTicket(int passportnum,int flightid);
  void CancelFlight(int passportnum,int flightid);
}
