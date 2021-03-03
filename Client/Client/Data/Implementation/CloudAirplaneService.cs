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
    public class CloudAirplaneService : IAirplaneService
    {

        public async Task<IList<Airplane>> GetFlights()
        {
            HttpClient client = new HttpClient();
            string message = await client.GetStringAsync("https://localhost:8443/airplanes");
            List<Airplane> result = JsonSerializer.Deserialize<List<Airplane>>(message);
            return result;
        }

        public async Task<Airplane> getRegNumByType(string type)
        {
            HttpClient client = new HttpClient();
            StringContent content = new StringContent(JsonSerializer.Serialize(type), Encoding.UTF8, "application/json");
            HttpResponseMessage message = await client.PutAsync("https://localhost:8443/airplanes", content);
            string response = await message.Content.ReadAsStringAsync();
            Airplane result = JsonSerializer.Deserialize<Airplane>(response);
            return result;
        }

        public async Task<Airplane> getTypeByFlightID(int flightID)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage message = await client.GetAsync("https://localhost:8443/airplanes/type?flightID=" + flightID);
            string response = await message.Content.ReadAsStringAsync();
            Airplane result = JsonSerializer.Deserialize<Airplane>(response);
            return result;
        }
    }
}
