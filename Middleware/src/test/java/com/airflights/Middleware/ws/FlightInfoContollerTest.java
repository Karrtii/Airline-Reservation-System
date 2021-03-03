package com.airflights.Middleware.ws;

import Shared.*;
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

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) @WebMvcTest(FlightInfoContoller.class) class FlightInfoContollerTest
{

  @Autowired private MockMvc mvc;

  @Test void getFlightInfo() throws Exception
  {
    RequestBuilder request = MockMvcRequestBuilders.put("/flightinfo").contentType(MediaType.APPLICATION_JSON).content("11");
    MvcResult result = mvc.perform(request).andReturn();
    String json = result.getResponse().getContentAsString();
    FlightInfo someClass = new ObjectMapper().readValue(json, FlightInfo.class);
    assertEquals(new FlightInfo(new Flight(11, 132, "264987", "on time"),
            new Arrival(new Timestamp(2024, 12, 30, 0, 0, 0, 0), "CPH", 11),
            new Departure(new Timestamp(2024, 12, 30, 0, 0, 0, 0), "BER", 11)),
        someClass);
  }

  @Test void getMyFlightInfos()
  {
    assertDoesNotThrow(
        () -> MockMvcRequestBuilders.get("/flightinfo?email=admin@gmail.com"));
  }

  @Test void getMyFlightInfosFinished()
  {
    assertDoesNotThrow(() -> MockMvcRequestBuilders
        .get("/flightinfo/status?email=admin@gmail.com&status=finished"));
  }

  @Test void getAllFlightInfos()
  {
    assertDoesNotThrow(
        () -> MockMvcRequestBuilders.get("/flightinfo/allflights"));
  }

  @Test void checkIfCancelledOrDelayed() throws Exception
  {
    RequestBuilder request = MockMvcRequestBuilders
        .put("/flightinfo/state?phrase=delayed&email=test@gmail.com");
    MvcResult result = mvc.perform(request).andReturn();
    String json = result.getResponse().getContentAsString();
    assertEquals("true", json);
  }
}