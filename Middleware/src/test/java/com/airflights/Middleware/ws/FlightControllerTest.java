package com.airflights.Middleware.ws;

import Shared.Airplane;
import Shared.Flight;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FlightController.class)
class FlightControllerTest
{

  @Autowired
  private MockMvc mvc;

  @Test
  void getAllFlights()
  {
    assertDoesNotThrow(()-> MockMvcRequestBuilders.get("/flights"));
  }

  @Test
  void checkFlights()
  {
    assertDoesNotThrow(()-> MockMvcRequestBuilders.delete("/flights"));
  }

  @Test
  void setFlightStatus() throws Exception
  {
    RequestBuilder request = MockMvcRequestBuilders.get("/flights/status?flightID=4&stat=cancelled");
    MvcResult result = mvc.perform(request).andReturn();
    String json = result.getResponse().getContentAsString();
    Flight someClass = new ObjectMapper().readValue(json, Flight.class);
    assertEquals(new Flight(4,132,"264987","cancelled"),someClass);
  }

  @Test
  void delayFlight() throws Exception
  {
    RequestBuilder request = MockMvcRequestBuilders.get("/flights/delay?flightID=4&minutes=60");
    MvcResult result = mvc.perform(request).andReturn();
    String json = result.getResponse().getContentAsString();
    Flight someClass = new ObjectMapper().readValue(json, Flight.class);
    assertEquals(new Flight(4,132,"264987","delayed"),someClass);
  }
}