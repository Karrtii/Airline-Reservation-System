package com.airflights.Middleware.ws;

import Shared.Airplane;
import Shared.Ticket;
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
@WebMvcTest(TicketsController.class)
class TicketsControllerTest
{
  @Autowired
  private MockMvc mvc;

  @Test
  void CheckAvailability() throws Exception
  {
    RequestBuilder request = MockMvcRequestBuilders.put("/tickets?flightID=4").contentType(
        MediaType.APPLICATION_JSON).content("10");
    MvcResult result = mvc.perform(request).andReturn();
    assertEquals("true",result.getResponse().getContentAsString());
  }

  @Test
  void getTickets()
  {
    assertDoesNotThrow(()->MockMvcRequestBuilders.get("/tickets"));
  }

  @Test
  void getTicket() throws Exception
  {
    RequestBuilder request = MockMvcRequestBuilders.get("/tickets/get?passNum=1111111111&flightID=20");
    MvcResult result = mvc.perform(request).andReturn();
    String json = result.getResponse().getContentAsString();
    Ticket someClass = new ObjectMapper().readValue(json, Ticket.class);
    assertEquals(new Ticket(2150,"Large",5),someClass);
  }
}