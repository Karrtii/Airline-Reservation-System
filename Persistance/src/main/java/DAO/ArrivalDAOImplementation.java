package DAO;

import Shared.Arrival;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArrivalDAOImplementation implements ArrivalDAO
{
  private DatabaseHelper<Arrival> helper;

  public ArrivalDAOImplementation(String jdbcURL, String username, String password)
  {
    helper = new DatabaseHelper<>(jdbcURL, username, password);
  }

  public static class ArrivalMapper implements DataMapper<Arrival>
  {

    @Override public Arrival create(ResultSet rs) throws SQLException
    {
      Timestamp time = rs.getTimestamp("arrivaltime");
      String fromWhere = rs.getString("comes");
      int flightId = rs.getInt("arrives");
      return new Arrival(time,fromWhere,flightId);
    }
  }

  @Override public void addArrival(Arrival newArrival, int flightID)
  {
    helper.executeUpdate("INSERT INTO Arrival(arrivaltime,comes,arrives) VALUES(?,?,?)",newArrival.arrivalTime,newArrival.fromWhere,flightID);
  }

  @Override public List<Arrival> getArrivalsByName(String name)
  {
    return helper.map(new ArrivalMapper(),"SELECT * FROM Arrival WHERE comes = ?",name);
  }

  @Override public List<Arrival> getAllArrivals()
  {
    return helper.map(new ArrivalMapper(),"SELECT * FROM Arrival");
  }

  @Override public Arrival getArrivalById(int id)
  {
    return helper.mapSingle(new ArrivalMapper(),"SELECT * FROM Arrival WHERE arrives = ?",id);
  }

  @Override public void delay(int flightID, int minutes)
  {
    try(Connection connection = helper.getConnection())
    {
      ResultSet rs = helper.executeQuery(connection, "SELECT arrivaltime from arrival where arrives = ?",flightID);
      List<Timestamp> arrivaltime = new ArrayList<>();
      while (rs.next())
      {
        arrivaltime.add(rs.getTimestamp("arrivaltime"));
      }
      Timestamp arrival = arrivaltime.get(0);
      arrival.setTime(arrivaltime.get(0).getTime()+(60000*minutes));
      helper.executeUpdate("UPDATE arrival SET arrivaltime = ? WHERE arrives = ?",arrival,flightID);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }
}
