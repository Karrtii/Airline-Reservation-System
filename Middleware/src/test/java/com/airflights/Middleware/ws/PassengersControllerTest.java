package com.airflights.Middleware.ws;

import Shared.Airport;
import Shared.Passenger;
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

@ExtendWith(SpringExtension.class)
@WebMvcTest(PassengersController.class)
class PassengersControllerTest
{
  @Autowired
  private MockMvc mvc;

  @Test
  void registerPassenger()throws Exception
  {
    String passenger = "{\"passportNumber\":\"1564442315\",\"passportExpirationDate\":\"2025-12-30T04:40:00.000+00:00\",\"firstname\":\"bob\",\"lastname\":\"Bob\",\"dateOfBirth\":\"1989-12-30T04:40:00.000+00:00\",\"gender\":\"M\",\"nationality\":\"Malay\"}";
    RequestBuilder request = MockMvcRequestBuilders.post("/passengers?email=admin@gmail.com").contentType(
        MediaType.APPLICATION_JSON).content(passenger);
    MvcResult result = mvc.perform(request).andReturn();
    String json = result.getResponse().getContentAsString();
    Passenger someClass = new ObjectMapper().readValue(json, Passenger.class);
    assertEquals(new Passenger(1564442315,new Timestamp(2025,12,30,0,0,0,0),"Bob","Bob",new Timestamp(1989,12,30,0,0,0,0),"M","Malay"),someClass);
  }

  @Test
  void getUsersPassengers()
  {
    assertDoesNotThrow(()-> MockMvcRequestBuilders.get("/passengers?email=admin@gmail.com"));
  }

  @Test
  void getPassenger() throws Exception
  {
    RequestBuilder request = MockMvcRequestBuilders.get("/passengers/get?id=1564442315");
    MvcResult result = mvc.perform(request).andReturn();
    String json = result.getResponse().getContentAsString();
    Passenger someClass = new ObjectMapper().readValue(json, Passenger.class);
    assertEquals(new Passenger(1564442315,new Timestamp(2025,12,30,0,0,0,0),"Bob","Bob",new Timestamp(1989,12,30,0,0,0,0),"M","Malay"),someClass);
  }

  @Test
  void checkPassenger()throws Exception
  {
    String passenger = "{\"passportNumber\":\"1563212315\",\"passportExpirationDate\":\"2025-12-30T04:40:00.000+00:00\",\"firstname\":\"bob\",\"lastname\":\"Bob\",\"dateOfBirth\":\"1989-12-30T04:40:00.000+00:00\",\"gender\":\"M\",\"nationality\":\"Malay\"}";
    RequestBuilder request = MockMvcRequestBuilders.put("/passengers").contentType(
        MediaType.APPLICATION_JSON).content(passenger);;
    MvcResult result = mvc.perform(request).andReturn();
    String json = result.getResponse().getContentAsString();
    assertEquals("true",json);
  }

}