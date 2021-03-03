package com.airflights.Middleware.ws;

import Shared.Airplane;
import Shared.Airport;
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
@WebMvcTest(AirportsController.class)
class AirportsControllerTest
{
  @Autowired
  private MockMvc mvc;

  @Test
  void getAllAirports()
  {
    assertDoesNotThrow(()-> MockMvcRequestBuilders.get("/airports"));
  }

  @Test
  void getAirportByName()throws Exception
  {
    RequestBuilder request = MockMvcRequestBuilders.put("/airports").contentType(
        MediaType.APPLICATION_JSON).content("{Berlin Brandenburg Airport}");
    MvcResult result = mvc.perform(request).andReturn();
    String json = result.getResponse().getContentAsString();
    Airport someClass = new ObjectMapper().readValue(json, Airport.class);
    assertEquals(new Airport("BER","Berlin Brandenburg Airport","Berlin","Germany"),someClass);
  }

  @Test
  void getAirportByIATA()throws Exception
  {
    RequestBuilder request = MockMvcRequestBuilders.post("/airports").contentType(
        MediaType.APPLICATION_JSON).content("{BER}");
    MvcResult result = mvc.perform(request).andReturn();
    String json = result.getResponse().getContentAsString();
    Airport someClass = new ObjectMapper().readValue(json, Airport.class);
    assertEquals(new Airport("BER","Berlin Brandenburg Airport","Berlin","Germany"),someClass);
  }

}