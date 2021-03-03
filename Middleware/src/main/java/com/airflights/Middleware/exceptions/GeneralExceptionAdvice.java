package com.airflights.Middleware.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GeneralExceptionAdvice
{
  @ResponseBody
  @ExceptionHandler(CannotRegisterUserException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  String CannotRegisterUserHandler(CannotRegisterUserException ex)
  {
    return  ex.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(WrongCredentialsException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  String WrongCredentialsHandler(WrongCredentialsException ex)
  {
    return  ex.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(CannotContactServer.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  String CannotContactServerHandler(CannotContactServer ex)
  {
    return ex.getMessage();
  }
}
