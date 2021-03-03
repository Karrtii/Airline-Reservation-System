package DAO;

import Shared.Airport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AirportsDAOImplementation implements AirportsDAO
{
  private DatabaseHelper<Airport> helper;

  public AirportsDAOImplementation(String jdbcURL, String username, String password)
  {
    helper = new DatabaseHelper<>(jdbcURL, username, password);
  }

  public static class AirportMapper implements DataMapper<Airport>
  {

    @Override public Airport create(ResultSet rs) throws SQLException
    {
      String iatacode = rs.getString("iatacode");
      String name = rs.getString("airportname");
      String city = rs.getString("city");
      String country = rs.getString("country");
      return new Airport(iatacode,name,city,country);
    }
  }

  @Override public List<Airport> getAirports()
  {
    return helper.map(new AirportMapper(),"SELECT * FROM Airport");
  }

  @Override public Airport getAirportByName(String name)
  {
    return helper.mapSingle(new AirportMapper(),"SELECT * FROM Airport WHERE airportname = ? ",name);
  }

  @Override public Airport getAirportByIATA(String iata)
  {
    return helper.mapSingle(new AirportMapper(),"SELECT * FROM Airport WHERE iatacode = ?",iata);
  }
}
