package com.airflights.Middleware.ws;

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
@WebMvcTest(UsersController.class)
class UsersControllerTest
{
  @Autowired
  private MockMvc mvc;

  @Test
  void getUser()throws Exception
  {
    RequestBuilder request = MockMvcRequestBuilders.get("/users?email=admin@gmail.com");
    MvcResult result = mvc.perform(request).andReturn();
    Date date = Date.valueOf("0001-01-01");
    String json = result.getResponse().getContentAsString();
    User someClass = new ObjectMapper().readValue(json, User.class);
    User expectedUser = new User("operator","admin@gmail.com","admin","admin","admin",date,0);
    assertEquals(expectedUser,someClass);
  }

  @Test
  void performLogin()throws Exception
  {
    RequestBuilder request = MockMvcRequestBuilders.post("/users?email=admin@gmail.com").contentType(
        MediaType.APPLICATION_JSON).content("{admin}");
    MvcResult result = mvc.perform(request).andReturn();
    String json = result.getResponse().getContentAsString();
    User someClass = new ObjectMapper().readValue(json, User.class);
    Date date = Date.valueOf("0001-01-01");
    User expectedUser = new User("operator","admin@gmail.com","admin","admin","admin",date,0);
    assertEquals(expectedUser,someClass);
  }

  @Test
  void registerUser()throws Exception
  {
    String jsonObj = "{\"userType\":\"operator\",\"email\":\"testingtesting@gmail.com\",\"password\":\"admin\",\"firstName\":\"admin\",\"lastName\":\"admin\",\"dateOfBirth\":\"0001-01-01\",\"phoneNumber\":0}";
    RequestBuilder request = MockMvcRequestBuilders.put("/users").contentType(
        MediaType.APPLICATION_JSON).content(jsonObj);
    MvcResult result = mvc.perform(request).andReturn();
    String json = result.getResponse().getContentAsString();
    User someClass = new ObjectMapper().readValue(json, User.class);
    Date date = Date.valueOf("0001-01-01");
    User expectedUser = new User("operator","testingtesting@gmail.com","admin","admin","admin",date,0);
    assertEquals(expectedUser,someClass);
  }

  @Test
  void modifyUser()throws Exception
  {
    String jsonObj = "{\"userType\":\"customer\",\"email\":\"brunooooo@gmail.com\",\"password\":\"admin\",\"firstName\":\"admin\",\"lastName\":\"admin\",\"dateOfBirth\":\"0001-01-01\",\"phoneNumber\":0}";
    RequestBuilder request = MockMvcRequestBuilders.patch("/users?oldEmail=brunogonzales@gmail.com")
        .contentType(MediaType.APPLICATION_JSON).content(jsonObj);
    MvcResult result = mvc.perform(request).andReturn();
    String json = result.getResponse().getContentAsString();
    System.out.println("Value:"+json);
    User someClass = new ObjectMapper().readValue(json, User.class);
    Date date = Date.valueOf("0001-01-01");
    User expectedUser = new User("customer","brunooooo@gmail.com","admin","admin","admin",date,0);
    assertEquals(expectedUser,someClass);
  }


}