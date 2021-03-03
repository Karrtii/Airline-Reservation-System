package Shared;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Airplane implements Serializable
{
  @JsonProperty("registrationNumber")
  private int registrationNumber;
  @JsonProperty("planeType")
  private String planeType;
  @JsonProperty("numberOfSeats")
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
