using Client.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace Client.Data.Implementation
{
    public class CloudFlightService : IFlightService
    {
        public async Task<Flight> AddFlight(Flight newFlight,Arrival newArrival, Departure newDeparture)
        {
            HttpClient client = new HttpClient();
            newFlight.id = 0;
            newArrival.flightID = 0;
            newDeparture.flightID = 0;
            StringContent content = new StringContent(JsonSerializer.Serialize(new FlightInfo(newFlight,newArrival,newDeparture)), Encoding.UTF8, "application/json");
            HttpResponseMessage message = await client.PostAsync("https://localhost:8443/flights", content);
            string adult2 = await message.Content.ReadAsStringAsync();
            Flight adult3 = JsonSerializer.Deserialize<Flight>(adult2);
            return adult3;
        }

        public async Task CheckFlights()
        {
            HttpClient client = new HttpClient();
            await client.DeleteAsync("https://localhost:8443/flights");
        }

        public async Task<Flight> DelayFlight(int flightID, int minutes)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage message = await client.GetAsync("https://localhost:8443/flights/delay?minutes=" + minutes + "&flightID=" + flightID);
            string jsonObj = await message.Content.ReadAsStringAsync();
            Flight result = JsonSerializer.Deserialize<Flight>(jsonObj);
            return result;
        }

        public async Task<IList<Flight>> GetFlights()
        {
            HttpClient client = new HttpClient();
            string message = await client.GetStringAsync("https://localhost:8443/flights");
            List<Flight> result = JsonSerializer.Deserialize<List<Flight>>(message);
            return result;
        }

        public async Task<Flight> SetFlightStatus(string status,int flightID)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage message = await client.GetAsync("https://localhost:8443/flights/status?stat=" + status+"&flightID="+flightID);
            string jsonObj = await message.Content.ReadAsStringAsync();
            Flight result = JsonSerializer.Deserialize<Flight>(jsonObj);
            return result;
        }
    }
}
