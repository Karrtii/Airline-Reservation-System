using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Client.Model;

namespace Client.Data
{
    public interface IPassengerService
    {
        Task registerPassenger(Passenger passenger, string username);
        Task<List<Passenger>> getMyPassengers(string email);
        Task<string> CheckPassenger(Passenger passenger);
        Task<Passenger> getPassenger(int passportNumber);
    }
}
