package com.airflights.Middleware.network;

import Shared.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class SocketClient
{
  public SocketClient()
  {

  }

  public void startClient()
  {
    try
    {
      Socket socket = new Socket("localhost",2910);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public Request request(Request request)
      throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket("localhost", 2910);
    ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
    outToServer.writeObject(request);
    return (Request) inFromServer.readObject();
  }
}
