using System;
using System.Collections.Generic;
using System.Linq;
using Client.Model;
using System.Threading.Tasks;

namespace Client.Data
{
    public interface IFlightInfoService
    {
        Task<List<FlightInfo>> getFlights(string fromWhere,string toWhere,int numberOfPassengers,DateTime departure,DateTime departureback);
        Task<FlightInfo> getFlightInfo(int flightid);
        Task<List<FlightInfo>> getFlightInfoPass(string email);
        Task<List<FlightInfo>> getFlightInfoPassFinished(string email, string status);
        Task<List<FlightInfo>> getFlightInfos();
        Task<string> checkIfDelayedOrCancelled(string phrase,string email);
    }
}
