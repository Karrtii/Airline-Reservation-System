package DAO;

import Shared.Passenger;

import java.util.List;

public interface PassengerDAO
{
  Passenger getPassenger(int passportNum);
  Passenger RegisterPassenger(Passenger newPassenger, String email);
  List<Passenger> getMyPassengers(String email);
}
