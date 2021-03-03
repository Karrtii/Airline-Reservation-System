package Shared;

import java.io.Serializable;

public class Airplane implements Serializable
{
  private int registrationNumber;
  private String planeType;
  private int numberOfSeats;

  public Airplane(int registrationNumber, String planeType, int numberOfSeats)
  {
    this.registrationNumber = registrationNumber;
    this.planeType = planeType;
    this.numberOfSeats = numberOfSeats;
  }

  public  Airplane()
  {

  }

  public void setRegistrationNumber(int registrationNumber)
  {
    this.registrationNumber = registrationNumber;
  }


  public int getRegistrationNumber()
  {
    return registrationNumber;
  }


  @Override public String toString()
  {
    return "Airplane{" + "registrationNumber=" + registrationNumber
        + ", planeType='" + planeType + '\'' + ", numberOfSeats="
        + numberOfSeats + '}';
  }
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Airplane))
      return false;
    Airplane other = (Airplane) obj;
    return registrationNumber == other.registrationNumber;
  }
}
