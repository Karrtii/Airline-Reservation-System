package com.airflights.Middleware;

import com.airflights.Middleware.network.SocketClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication public class UsersApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(UsersApplication.class, args);
    SocketClient client = new SocketClient();
    client.startClient();
  }

}

