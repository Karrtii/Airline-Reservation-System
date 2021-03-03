package com.airflights.Middleware.ws;

import Shared.Airplane;
import com.airflights.Middleware.model.AirplaneMiddleware;
import com.airflights.Middleware.model.AirplaneMiddlewareModel;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/airplanes")
public class AirplanesController
{
  private AirplaneMiddleware airplaneMiddleware;

  public AirplanesController()
  {
    airplaneMiddleware = new AirplaneMiddlewareModel();
  }

  @GetMapping
  @ResponseBody
  List<Airplane> getAllPlanes()
  {
    return airplaneMiddleware.getPlanes();
  }

  @PutMapping
  @ResponseBody
  Airplane getPlaneByType(@RequestBody String type)
  {
    String typeWithoutQuotation = type.substring(1, type.length()-1);
    return airplaneMiddleware.getAirplaneByType(typeWithoutQuotation);
  }

  @GetMapping
  @ResponseBody
  @RequestMapping("/type")
  Airplane getPlaneTypeByID(@RequestParam int flightID)
  {
    return airplaneMiddleware.getTypeById(flightID);
  }
}
