package Shared;

import java.io.Serializable;
import java.sql.Timestamp;

public class Passenger implements Serializable
{
  private int passportNumber;
  private Timestamp passportExpirationDate;
  private String firstname;
  private String lastname;
  private Timestamp dateOfBirth;
  private String gender;
  private String nationality;

  public Passenger(int passportNumber, Timestamp passportExpirationDate,
      String firstname, String lastname, Timestamp dateOfBirth, String gender,
      String nationality)
  {
    this.passportNumber = passportNumber;
    this.passportExpirationDate = passportExpirationDate;
    this.firstname = firstname;
    this.lastname = lastname;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.nationality = nationality;
  }

  public Passenger()
  {
  }

  public int getPassportNumber()
  {
    return passportNumber;
  }

  public Timestamp getPassportExpirationDate()
  {
    return passportExpirationDate;
  }

  public String getFirstname()
  {
    return firstname;
  }

  public String getLastname()
  {
    return lastname;
  }

  public Timestamp getDateOfBirth()
  {
    return dateOfBirth;
  }

  public String getGender()
  {
    return gender;
  }

  public String getNationality()
  {
    return nationality;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Passenger))
      return false;
    Passenger other = (Passenger) obj;
    return passportNumber==other.passportNumber;
  }

  @Override public String toString()
  {
    return "Passenger{" + "passportNumber=" + passportNumber
        + ", passportExpirationDate=" + passportExpirationDate + ", firstname='"
        + firstname + '\'' + ", lastname='" + lastname + '\'' + ", dateOfBirth="
        + dateOfBirth + ", gender=" + gender + ", nationality='" + nationality
        + '\'' + '}';
  }
}
