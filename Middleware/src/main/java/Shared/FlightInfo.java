package Shared;

public class FlightInfo
{
  public Flight flight;
  public Arrival arrival;
  public Departure departure;
  public Passenger passenger;

  public FlightInfo(Flight flight,Arrival arrival,Departure departure)
  {
    this.flight = flight;
    this.departure = departure;
    this.arrival = arrival;
  }

  public FlightInfo(Flight flight,Arrival arrival,Departure departure,Passenger passenger)
  {
    this.flight = flight;
    this.departure = departure;
    this.arrival = arrival;
    this.passenger = passenger;
  }

  public FlightInfo()
  {

  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof FlightInfo))
      return false;
    FlightInfo other = (FlightInfo) obj;
    return flight.id==other.flight.id;
  }

  @Override public String toString()
  {
    return "FlightInfo{" + "flight=" + flight + ", arrival=" + arrival
        + ", departure=" + departure + '}';
  }
}
