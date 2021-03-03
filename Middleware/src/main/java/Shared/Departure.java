package Shared;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Departure implements Serializable
{
  public Timestamp departureTime;
  public String fromWhere;
  public int flightID;

  public Departure()
  {
  }

  public Departure(Timestamp departureTime, String fromWhere, int flightID)
  {
    this.departureTime = departureTime;
    this.fromWhere = fromWhere;
    this.flightID = flightID;
  }


  public int getFlightID()
  {
    return flightID;
  }

  @Override public String toString()
  {
    return "Departure{" + "departureTime=" + departureTime + ", fromWhere='"
        + fromWhere + '\'' + ", flightID=" + flightID + '}';
  }
}
