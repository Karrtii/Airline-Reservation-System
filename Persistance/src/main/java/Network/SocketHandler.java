package Network;

import Model.Persistence;
import Shared.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler implements Runnable
{
  private Socket socket;
  private Persistence persistence;

  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;

  public SocketHandler(Socket socket, Persistence persistence)
  {
    this.socket = socket;
    this.persistence = persistence;

    try
    {
      outToClient = new ObjectOutputStream(socket.getOutputStream());
      inFromClient = new ObjectInputStream(socket.getInputStream());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

  }

  @Override public void run()
  {
    try
    {
      Request request = (Request) inFromClient.readObject();
      Request result = persistence.handlerRequest(request);
      outToClient.writeObject(result);
    }
    catch (IOException e)
    {

    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}
