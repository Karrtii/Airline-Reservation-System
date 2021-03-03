package DAO;

import Shared.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAOImplementation implements UsersDAO
{
  private DatabaseHelper<User> helper;

  public UsersDAOImplementation(String jdbcURL, String username,
      String password)
  {
    helper = new DatabaseHelper<>(jdbcURL, username, password);
  }

  public static class UserMapper implements DataMapper<User>
  {

    @Override public User create(ResultSet rs) throws SQLException
    {
      String userType = rs.getString("userType");
      String email = rs.getString("email");
      String password = rs.getString("password");
      String firstName = rs.getString("firstName");
      String lastName = rs.getString("lastNames");
      Date dateOfBirth = (Date) rs.getObject("dateOfBirth");
      int phoneNumber = rs.getInt("phoneNumber");
      return new User(userType, email, password, firstName, lastName,
          dateOfBirth, phoneNumber);
    }
  }

  @Override public User getUser(String email)
  {
    return helper
        .mapSingle(new UserMapper(), "SELECT * FROM USERS WHERE email = ?",
            email);
  }

  @Override public User addUser(User newUser)
  {
    helper.executeUpdate(
        "INSERT INTO Users(userType,email,password,firstName,lastNames,dateOfBirth,phoneNumber) VALUES(?,?,?,?,?,?,?)",
        newUser.userType, newUser.email, newUser.password, newUser.firstName,
        newUser.lastName, newUser.dateOfBirth, newUser.phoneNumber);
    return getUser(newUser.email);
  }

  @Override public int getUserID(String email)
  {
    try (Connection connection = helper.getConnection())
    {
      ResultSet rs = helper
          .executeQuery(connection, "SELECT userid FROM users WHERE email = ? ",
              email);
      List<Integer> integers = new ArrayList<>();
      while (rs.next())
      {
        integers.add(rs.getInt("userid"));
      }
      return integers.get(0);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return 0;
  }

  @Override public void modifyUser(User newUser,String oldEmail)
  {
    int id = getUserID(oldEmail);
    String email = newUser.email;
    helper.executeUpdate(
        "UPDATE users SET email = ?,password = ?,firstname = ?,lastnames = ?,dateofbirth = ?, phonenumber = ? WHERE userid = ?",
        newUser.email, newUser.password, newUser.firstName, newUser.lastName,
        newUser.dateOfBirth, newUser.phoneNumber,id);
  }
}
