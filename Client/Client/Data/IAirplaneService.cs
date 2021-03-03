using Client.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Client.Data
{
    public interface IAirplaneService
    {
        Task<IList<Airplane>> GetFlights();
        Task<Airplane> getRegNumByType(string type);
        Task<Airplane> getTypeByFlightID(int flightID);
    }
}
