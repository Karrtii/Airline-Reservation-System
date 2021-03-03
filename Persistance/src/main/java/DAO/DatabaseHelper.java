package DAO;

import Shared.User;
import org.postgresql.Driver;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DatabaseHelper<T>
{
  private String jdbcURL;
  private String username;
  private String password;

  public DatabaseHelper(String jdbcURL, String username, String password)
  {
    this.jdbcURL = jdbcURL;
    this.username = username;
    this.password = password;
    try
    {
      DriverManager.registerDriver(new Driver());
    }
    catch (SQLException e)
    {
      throw new RuntimeException("No JDBC driver",e);
    }
  }

  public DatabaseHelper(String jdbcURL)
  {
    this(jdbcURL,null,null);
  }

  public Connection getConnection() throws SQLException
  {
    if(username == null)
    {
      return DriverManager.getConnection(jdbcURL);
    }
    else
    {
      return DriverManager.getConnection(jdbcURL,username,password);
    }
  }

  private static PreparedStatement prepare(Connection connection, String sql, Object... parameters) throws SQLException
  {
    PreparedStatement stat = connection.prepareStatement(sql);
    for (int i = 0; i < parameters.length; i++)
    {
      stat.setObject(i+1,parameters[i]);
    }
    return stat;
  }

  public ResultSet executeQuery(Connection connection, String sql, Object... parameters) throws SQLException {
    PreparedStatement stat = prepare(connection, sql, parameters);
    return stat.executeQuery();
  }

  public int executeUpdate(String sql, Object... parameters){
    try (Connection connection = getConnection()) {
      PreparedStatement stat = prepare(connection, sql, parameters);
      return stat.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  public T mapSingle(DataMapper<T> mapper, String sql, Object... parameters) {
    try (Connection connection = getConnection()) {
      ResultSet rs = executeQuery(connection, sql, parameters);
      if(rs.next()) {
        return mapper.create(rs);
      } else {
        return null;
      }
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  public List<T> map(DataMapper<T> mapper, String sql, Object... parameters) {
    try (Connection connection = getConnection()) {
      ResultSet rs = executeQuery(connection, sql, parameters);
      LinkedList<T> allRows = new LinkedList<>();
      while(rs.next()) {
        allRows.add(mapper.create(rs));
      }
      return allRows;
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }
}
