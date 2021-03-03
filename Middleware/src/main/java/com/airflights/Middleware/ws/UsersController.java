package com.airflights.Middleware.ws;

import Shared.User;
import com.airflights.Middleware.model.UsersMiddleware;
import com.airflights.Middleware.model.UsersMiddlewareModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController
{
  private UsersMiddleware usersMiddleware;

  UsersController()
  {
    usersMiddleware = new UsersMiddlewareModel();
  }

  @PostMapping
  @ResponseBody
  ResponseEntity<User> performLogin(@RequestBody String password,@RequestParam String email)
  {
    return usersMiddleware.performLogin(email, password.substring(1, password.length()-1));
  }

  @PutMapping
  ResponseEntity<User> performRegister(@RequestBody User newUser)
  {
    return usersMiddleware.performRegister(newUser);
  }

  @PatchMapping
  ResponseEntity<User> modifyUser(@RequestBody User newUser,@RequestParam String oldEmail)
  {
    return usersMiddleware.ModifyUser(newUser,oldEmail);
  }

  @GetMapping
  User getUser(@RequestParam String email)
  {
    return usersMiddleware.getUser(email);
  }
}
