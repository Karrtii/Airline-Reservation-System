package com.airflights.Middleware.ws;

import Shared.Airplane;
import Shared.User;
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

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AirplanesController.class)
class AirplanesControllerTest
{
  @Autowired
  private MockMvc mvc;

  @Test
  void getAllPlanes()
  {
    assertDoesNotThrow(()->MockMvcRequestBuilders.get("/airplanes"));
  }
  @Test
  void getPlaneByType()throws Exception
  {
    RequestBuilder request = MockMvcRequestBuilders.put("/airplanes").contentType(
        MediaType.APPLICATION_JSON).content("{Boeing 737}");
    MvcResult result = mvc.perform(request).andReturn();
    String json = result.getResponse().getContentAsString();
    Airplane someClass = new ObjectMapper().readValue(json, Airplane.class);
    assertEquals(new Airplane(468231,"Boeing 737",198),someClass);
  }

  @Test
  void getPlaneTypeByID()throws Exception
  {
    RequestBuilder request = MockMvcRequestBuilders.get("/airplanes/type?flightID=4");
    MvcResult result = mvc.perform(request).andReturn();
    String json = result.getResponse().getContentAsString();
    Airplane someClass = new ObjectMapper().readValue(json, Airplane.class);
    assertEquals(new Airplane(264987,"Irkut MC21",132),someClass);
  }
}