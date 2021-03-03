package Shared;

import java.io.Serializable;

public class Airport implements Serializable
{
  public String IATACode;
  public String airportName;
  public String city;
  public String country;

  public Airport()
  {
  }

  public Airport(String IATACode,String airportName,String city,String country)
  {
    this.IATACode = IATACode;
    this.airportName = airportName;
    this.city = city;
    this.country = country;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Airport))
      return false;
    Airport other = (Airport) obj;
    return IATACode.equals(other.IATACode)&&airportName.equals(other.airportName)&&city.equals(other.city)&&country.equals(other.country);
  }

  @Override public String toString()
  {
    return "Airport{" + "IATACode='" + IATACode + '\'' + ", airportName='"
        + airportName + '\'' + ", city='" + city + '\'' + ", country='"
        + country + '\'' + '}';
  }

}
