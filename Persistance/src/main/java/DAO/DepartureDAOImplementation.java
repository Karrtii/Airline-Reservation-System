package DAO;

import Shared.Departure;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartureDAOImplementation implements DepartureDAO
{
  private DatabaseHelper<Departure> helper;

  public DepartureDAOImplementation(String jdbcURL, String username, String password)
  {
    helper = new DatabaseHelper<>(jdbcURL, username, password);
  }


  public static class DepartureMapper implements DataMapper<Departure>
  {

    @Override public Departure create(ResultSet rs) throws SQLException
    {
      Timestamp departureTime = rs.getTimestamp("departuretime");
      String leavesFrom = rs.getString("leaves");
      int flightID = rs.getInt("departs");
      return new Departure(departureTime,leavesFrom,flightID);
    }
  }

  @Override public void addDeparture(Departure newDeparture, int flightID)
  {
    helper.executeUpdate("INSERT INTO Departure(departuretime,leaves,departs) VALUES(?,?,?)",newDeparture.departureTime,newDeparture.fromWhere,flightID);
  }

  @Override public List<Departure> getDeparturesByName(String name)
  {
    return helper.map(new DepartureMapper(),"SELECT * FROM Departure WHERE leaves = ?",name);
  }

  @Override public List<Departure> getAllDepartures()
  {
    return helper.map(new DepartureMapper(),"SELECT * from Departure");
  }

  @Override public Departure getDepartureByID(int id)
  {
    return helper.mapSingle(new DepartureMapper(),"SELECT * FROM Departure WHERE departs = ?", id);
  }

  @Override public void delay(int flightID, int minutes)
  {
    try(Connection connection = helper.getConnection())
    {
      ResultSet rs = helper.executeQuery(connection, "SELECT departuretime from departure where departs = ?",flightID);
      List<Timestamp> arrivaltime = new ArrayList<>();
      while (rs.next())
      {
        arrivaltime.add(rs.getTimestamp("departuretime"));
      }
      Timestamp arrival = arrivaltime.get(0);
      arrival.setTime(arrivaltime.get(0).getTime()+(60000*minutes));
      helper.executeUpdate("UPDATE departure SET departuretime = ? WHERE departs = ?",arrival,flightID);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
