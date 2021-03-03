package com.airflights.Middleware.ws;

import Shared.Ticket;
import com.airflights.Middleware.model.TicketMiddleware;
import com.airflights.Middleware.model.TicketMiddlewareModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/tickets") public class TicketsController
{
  private TicketMiddleware ticketMiddleware;

  public TicketsController()
  {
    this.ticketMiddleware = new TicketMiddlewareModel();
  }

  @PostMapping @ResponseBody void BookAFlight(@RequestBody Ticket ticket,
      @RequestParam int passNum, @RequestParam int id,
      @RequestParam int seatNum)
  {
    ticketMiddleware.BookAFlight(passNum, id, seatNum, ticket);
  }

  @PutMapping @ResponseBody String CheckAvailability(@RequestBody int seatNum,
      @RequestParam int flightID)
  {
    return ticketMiddleware.checkAvailability(seatNum, flightID);
  }

  @GetMapping @ResponseBody List<Integer> getTickets(@RequestParam int flightID)
  {
    return ticketMiddleware.getTickets(flightID);
  }

  @GetMapping @RequestMapping("/get") @ResponseBody Ticket getTicket(
      @RequestParam int passNum, @RequestParam int flightID)
  {
    return ticketMiddleware.getTicket(passNum, flightID);
  }

  @DeleteMapping void cancelFlight(@RequestParam int flightID,
      @RequestParam int passNum)
  {
    ticketMiddleware.CancelFlight(passNum, flightID);
  }
}
