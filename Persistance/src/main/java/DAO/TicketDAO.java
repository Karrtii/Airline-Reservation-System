package DAO;

import Shared.Flight;
import Shared.Ticket;

import java.util.List;

public interface TicketDAO
{
  Ticket getTicket(int seatNum,int flightID);
  void CreateTicket(Ticket luggage,int passportnum, int flightid, int seatnum);
  List<Integer> getTickets(int flightid);
  List<Integer> getFlightsByPassport(int passportNum);
  Ticket getTicketPassport(int passportNum,int flightID);
  void removeTicket(int passportnum,int flightid);
}
