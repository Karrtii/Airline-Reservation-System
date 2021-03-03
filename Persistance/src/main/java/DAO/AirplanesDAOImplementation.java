package DAO;

import Shared.Airplane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplanesDAOImplementation implements AirplanesDAO
{
  private DatabaseHelper<Airplane> helper;
  private FlightsDAO flightsDAO;

  public AirplanesDAOImplementation(String jdbcURL, String username,
      String password)
  {
    helper = new DatabaseHelper<>(jdbcURL, username, password);
    flightsDAO = new FlightsDAOImplementation(jdbcURL, username, password);
  }

  public static class AirplaneMapper implements DataMapper<Airplane>
  {

    @Override public Airplane create(ResultSet rs) throws SQLException
    {
      int registrationNumber = rs.getInt("registrationnumber");
      String planeType = rs.getString("planetype");
      int numberOfSeats = rs.getInt("numberofseats");
      return new Airplane(registrationNumber, planeType, numberOfSeats);
    }
  }

  @Override public List<Airplane> getPlanes()
  {
    return helper.map(new AirplaneMapper(), "SELECT * FROM Airplane");
  }

  @Override public Airplane getAirplaneByType(String type)
  {
    return helper.mapSingle(new AirplaneMapper(),
        "SELECT * FROM Airplane WHERE planetype = ?", type);
  }

  @Override public Airplane getTypeByID(int flightId)
  {
    try (Connection connection = helper.getConnection())
    {
      ResultSet rs = helper.executeQuery(connection,
          "SELECT flies from flight where flightid = ?", flightId);
      List<Integer> integers = new ArrayList<>();
      while (rs.next())
      {
        integers.add(rs.getInt("flies"));
      }
      return helper.mapSingle(new AirplaneMapper(),
          "SELECT * from airplane where registrationnumber = ?",
          integers.get(0));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
