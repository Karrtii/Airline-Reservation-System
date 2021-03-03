package Shared;

import java.io.Serializable;
import java.sql.Timestamp;

public class Arrival implements Serializable
{
    public Timestamp arrivalTime;
    public String fromWhere;
    public int flightID;

    public Arrival(Timestamp arrivalTime,String fromWhere,int flightID)
    {
      this.arrivalTime = arrivalTime;
      this.fromWhere = fromWhere;
      this.flightID = flightID;
    }

  public Arrival()
  {
  }

  public int getFlightID()
  {
    return flightID;
  }

  @Override public String toString()
  {
    return "Arrival{" + "arrivalTime=" + arrivalTime + ", fromWhere='"
        + fromWhere + '\'' + ", flightID=" + flightID + '}';
  }
}
