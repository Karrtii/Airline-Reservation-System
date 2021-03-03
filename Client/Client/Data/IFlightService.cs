using Client.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Client.Data
{
    public interface IFlightService
    {
        Task<IList<Flight>> GetFlights();
        Task<Flight> AddFlight(Flight newFlight,Arrival newArrival, Departure newDeparture);
        Task CheckFlights();
        Task<Flight> SetFlightStatus(string status,int flightid);
        Task<Flight> DelayFlight(int flightID, int minutes);
    }
}
