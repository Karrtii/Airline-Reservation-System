package com.airflights.Middleware.ws;

import Shared.Passenger;
import com.airflights.Middleware.model.PassengerMiddleware;
import com.airflights.Middleware.model.PassengerMiddlewareModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengersController
{
  private PassengerMiddleware passengerMiddleware;

  public PassengersController()
  {
    this.passengerMiddleware = new PassengerMiddlewareModel();
  }

  @PostMapping
  @ResponseBody
  Passenger registerPassenger(@RequestBody Passenger newPassenger, @RequestParam String email)
  {
    if (passengerMiddleware.passengerExists(newPassenger))
    {
      return newPassenger;
    }
    else
    {
      return passengerMiddleware.registerPassenger(newPassenger, email);
    }
  }

  @GetMapping
  @ResponseBody
  List<Passenger> getUsersPassengers(@RequestParam String email)
  {
    return passengerMiddleware.getMyPassengers(email);
  }

  @GetMapping
  @RequestMapping("/get")
  @ResponseBody
  Passenger getPassenger(@RequestParam int id)
  {
    return passengerMiddleware.getPassenger(id);
  }

  @PutMapping
  @ResponseBody
  String checkPassenger(@RequestBody Passenger passenger)
  {
    return passengerMiddleware.CheckPassenger(passenger);
  }
}
