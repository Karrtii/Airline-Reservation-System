package com.airflights.Middleware.ws;

import Shared.FlightInfo;
import com.airflights.Middleware.model.FlightInfoMiddleware;
import com.airflights.Middleware.model.FlightInfoMiddlewareModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/flightinfo") public class FlightInfoContoller
{

  private FlightInfoMiddleware flightInfoMiddleware;

  public FlightInfoContoller()
  {
    this.flightInfoMiddleware = new FlightInfoMiddlewareModel();
  }

  @PostMapping List<FlightInfo> searchForClosestFlights(@RequestBody FlightInfo objects,
      @RequestParam String fromwhere, @RequestParam String towhere,
      @RequestParam int numberofpassengers)
  {
    return flightInfoMiddleware.getClosestFlights(objects.arrival.arrivalTime,
        objects.departure.departureTime, fromwhere, towhere,
        numberofpassengers);
  }

  @PutMapping FlightInfo getFlightInfo(@RequestBody int flightid)
  {
    return flightInfoMiddleware.getFlightInfo(flightid);
  }

  @GetMapping @ResponseBody List<FlightInfo> getMyFlightInfos(
      @RequestParam String email)
  {
    return flightInfoMiddleware.getMyFlightInfos(email);
  }

  @GetMapping @ResponseBody @RequestMapping("/status") List<FlightInfo> getMyFlightInfosFinished(
      @RequestParam String email, @RequestParam String status)
  {
    return flightInfoMiddleware.getMyFlightInfosFinished(email, status);
  }

  @GetMapping @ResponseBody @RequestMapping("/allflights") List<FlightInfo> getAllFlightInfos()
  {
    return flightInfoMiddleware.getAllFlightInfos();
  }

  @GetMapping @ResponseBody @RequestMapping("/state") String checkIfCancelledOrDelayed(
      @RequestParam String phrase, @RequestParam String email)
  {
    if (phrase.equals("cancel"))
    {
      return flightInfoMiddleware.checkIfNotCancelled(email);
    }
    else
    {
      return flightInfoMiddleware.checkIfNotDelayed(email);
    }
  }
}

