package com.airflights.Middleware.model;

import Shared.Request;
import Shared.User;
import com.airflights.Middleware.exceptions.CannotRegisterUserException;
import com.airflights.Middleware.exceptions.WrongCredentialsException;
import com.airflights.Middleware.network.SocketClient;
import com.airflights.Middleware.exceptions.CannotContactServer;
import org.springframework.http.ResponseEntity;


public class UsersMiddlewareModel implements UsersMiddleware
{
  private SocketClient client;

  public UsersMiddlewareModel()
  {
    this.client = new SocketClient();
  }

  @Override public ResponseEntity<User> performLogin(String email, String password)
  {
    User fromDatabase = null;
    try
    {
      Request request = new Request("GETUser", email);
      fromDatabase = (User) client.request(request).getArg();
      if (fromDatabase.password.equals(password))
      {
        return ResponseEntity.status(200).body(getUser(email));
      }
      else
      {
        throw new WrongCredentialsException();
      }
    }
    catch (WrongCredentialsException | NullPointerException e)
    {
      throw new WrongCredentialsException();
    }
    catch (Exception e)
    {
      throw new CannotContactServer();
    }
  }

  @Override public ResponseEntity<User> performRegister(User newUser)
  {
    Request request = new Request("GETUser", newUser.email);
    User fromDatabase = null;
    try
    {
      fromDatabase = (User) client.request(request).getArg();

      if (fromDatabase != null)
      {
        throw new CannotRegisterUserException(newUser.email);
      }
      else
      {
        client.request(new Request("REGISTERUser", newUser));
        return ResponseEntity.status(204).body(getUser(newUser.email));
      }
    }
    catch (CannotRegisterUserException e)
    {
      throw new CannotRegisterUserException(newUser.email);
    }
    catch (Exception e)
    {
      throw new CannotContactServer();
    }
  }

  @Override public User getUser(String email)
  {
    try
    {
      Request request = new Request("GETUser", email);
      return (User) client.request(request).getArg();
    }
    catch (Exception e)
    {
      throw new CannotContactServer();
    }
  }

  @Override public ResponseEntity<User> ModifyUser(User newUser, String oldEmail)
  {
    Request request = new Request("GETUser", newUser.email);
    try
    {
      User user = (User) client.request(request).getArg();
      request = new Request("ModifyUser", newUser, oldEmail);
      if (user == null)
      {
        client.request(request);
        return ResponseEntity.status(200).body(getUser(newUser.email));
      }
      else
      {
        newUser.email = oldEmail;
        client.request(request);
        return ResponseEntity.status(200).body(getUser(oldEmail));
      }
    }
    catch (Exception e)
    {
      throw new CannotContactServer();
    }
  }
}
