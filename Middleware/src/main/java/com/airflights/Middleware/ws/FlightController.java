package com.airflights.Middleware.ws;

import Shared.*;
import com.airflights.Middleware.model.FlightMiddleware;
import com.airflights.Middleware.model.FlightMiddlewareModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/flights") public class FlightController
{
  private FlightMiddleware flightMiddleware;

  public FlightController()
  {
    flightMiddleware = new FlightMiddlewareModel();
  }

  @GetMapping @ResponseBody List<Flight> getFlights()
  {
    return flightMiddleware.getFlights();
  }

  @PostMapping Flight createFlight(@RequestBody FlightInfo objects)
  {
    flightMiddleware
        .addFlight(objects.flight, objects.arrival, objects.departure);
    return objects.flight;
  }

  @DeleteMapping void checkFlights()
  {
   flightMiddleware.CheckFlights();
  }

  @GetMapping
  @ResponseBody
  @RequestMapping("/status")
  Flight setFlightStatus(@RequestParam int flightID,@RequestParam String stat)
  {
    return  flightMiddleware.setFlightStatus(stat,flightID);
  }

  @GetMapping
  @ResponseBody
  @RequestMapping("/delay")
  Flight delayFlights(@RequestParam int minutes,@RequestParam int flightID)
  {
    return flightMiddleware.delayFlight(flightID,minutes);
  }
}
