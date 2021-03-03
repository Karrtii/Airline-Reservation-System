package Network;

import Model.PersistenceModel;

public class RunServer
{
  public static void main(String[] args)
  {
    SocketServer socketServer = new SocketServer(new PersistenceModel());
    socketServer.startServer();
  }
}
