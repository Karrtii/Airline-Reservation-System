package DAO;

import Shared.Passenger;
import Shared.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class PassengerDAOImplementation implements PassengerDAO
{
  private DatabaseHelper<Passenger> helper;
  private UsersDAO usersDAO;

  public PassengerDAOImplementation(String jdbcURL, String username,
      String password)
  {
    helper = new DatabaseHelper<>(jdbcURL, username, password);
    usersDAO = new UsersDAOImplementation(jdbcURL, username, password);
  }

  public static class PassengerMapper implements DataMapper<Passenger>
  {

    @Override public Passenger create(ResultSet rs) throws SQLException
    {
      int passportnum = rs.getInt("passportnumber");
      Timestamp passportexpirationdate = rs
          .getTimestamp("passportexpirationdate");
      String firstname = rs.getString("firstname");
      String lastname = rs.getString("lastname");
      Timestamp dateofbirth = rs.getTimestamp("dateofbirth");
      String gender = rs.getString("gender");
      String nationality = rs.getString("nationality");
      return new Passenger(passportnum, passportexpirationdate, firstname,
          lastname, dateofbirth, gender, nationality);
    }
  }

  @Override public Passenger getPassenger(int passportNum)
  {
    return helper.mapSingle(new PassengerMapper(),
        "SELECT * FROM passenger WHERE passportnumber = ?", passportNum);
  }

  @Override public Passenger RegisterPassenger(Passenger newPassenger,
      String email)
  {
        helper.executeUpdate(
        "INSERT INTO passenger(passportnumber,passportexpirationdate,firstname,lastname,dateofbirth,gender,nationality,createdby) VALUES (?,?,?,?,?,?,?,(SELECT userid from users where email= ?))",
        newPassenger.getPassportNumber(),
        newPassenger.getPassportExpirationDate(), newPassenger.getFirstname(),
        newPassenger.getLastname(), newPassenger.getDateOfBirth(),
        newPassenger.getGender(), newPassenger.getNationality(),email);
    return newPassenger;
  }

  @Override public List<Passenger> getMyPassengers(String email)
  {
    int id = usersDAO.getUserID(email);
    return helper.map(new PassengerMapper(),"SELECT * FROM passenger WHERE createdby = ?",id);
  }
}
