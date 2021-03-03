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
    public class CloudPassengerService : IPassengerService
    {
        public async Task<string> CheckPassenger(Passenger passenger)
        {
            HttpClient client = new HttpClient();
            HttpContent content = new StringContent(JsonSerializer.Serialize(passenger), Encoding.UTF8, "application/json");
            HttpResponseMessage message = await client.PutAsync("https://localhost:8443/passengers", content);
            string jsonObj = await message.Content.ReadAsStringAsync();
            return jsonObj;
        }

        public async Task<List<Passenger>> getMyPassengers(string email)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage message = await client.GetAsync("https://localhost:8443/passengers?email=" + email);
            string jsonObj = await message.Content.ReadAsStringAsync();
            List<Passenger> result = JsonSerializer.Deserialize<List<Passenger>>(jsonObj);
            return result;
        }

        public async Task<Passenger> getPassenger(int passportNumber)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage message = await client.GetAsync("https://localhost:8443/passengers/get?id=" + passportNumber);
            string jsonObj = await message.Content.ReadAsStringAsync();
            Passenger result = JsonSerializer.Deserialize<Passenger>(jsonObj);
            return result;
        }

        public async Task registerPassenger(Passenger passenger, string username)
        {
            HttpClient client = new HttpClient();
            HttpContent content = new StringContent(JsonSerializer.Serialize(passenger), Encoding.UTF8, "application/json");
            HttpResponseMessage message = await client.PostAsync("https://localhost:8443/passengers?email=" + username, content);
            string jsonObj = await message.Content.ReadAsStringAsync();
            Passenger result = JsonSerializer.Deserialize<Passenger>(jsonObj);
        }
    }
}
