package Network;

import Model.Persistence;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private Persistence persistence;

  public SocketServer(Persistence persistence)
  {
    this.persistence = persistence;
  }

  public void startServer()
  {
    try
    {
      ServerSocket welcomeSocket = new ServerSocket(2910);
      System.out.println("Persistence server started");
      while(true)
      {
        Socket socket = welcomeSocket.accept();
        new Thread(new SocketHandler(socket, persistence)).start();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

  }
}
