package com.airflights.Middleware.exceptions;

public class CannotRegisterUserException extends RuntimeException
{
  public CannotRegisterUserException(String email)
  {
    super("User with this email: "+email+" already exists");
  }
}
