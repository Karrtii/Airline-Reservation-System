using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Client.Model;

namespace Client.Data
{
    public interface IAirportService
    {
        Task<IList<Airport>> getAirports();
        Task<Airport> getAirportByName(String name);
        Task<Airport> getAirportByIATA(String iata);
    }
}
