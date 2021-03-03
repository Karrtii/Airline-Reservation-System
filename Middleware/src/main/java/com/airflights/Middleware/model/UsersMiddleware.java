package com.airflights.Middleware.model;

import Shared.User;
import org.springframework.http.ResponseEntity;

public interface UsersMiddleware
{
  ResponseEntity<User> performLogin(String email,String password);
  User getUser(String email);
  ResponseEntity<User> performRegister(User newUser);
  ResponseEntity<User> ModifyUser(User newUser,String oldEmail);
}
