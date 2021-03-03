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
    public class CloudFlightInfoService : IFlightInfoService
    {
        public async Task<string> checkIfDelayedOrCancelled(string phrase, string email)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage message = await client.GetAsync("https://localhost:8443/flightinfo/state?phrase=" + phrase+"&email="+email);
            string jsonObj = await message.Content.ReadAsStringAsync();
            return jsonObj;
        }

        public async Task<FlightInfo> getFlightInfo(int flightid)
        {
            HttpClient client = new HttpClient();
            StringContent content = new StringContent(JsonSerializer.Serialize(flightid), Encoding.UTF8, "application/json");
            HttpResponseMessage message = await client.PutAsync("https://localhost:8443/flightinfo", content);
            string response = await message.Content.ReadAsStringAsync();
            FlightInfo result = JsonSerializer.Deserialize<FlightInfo>(response);
            return result;
        }

        public async Task<List<FlightInfo>> getFlightInfoPass(string email)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage message = await client.GetAsync("https://localhost:8443/flightinfo?email=" + email);
            string jsonObj = await message.Content.ReadAsStringAsync();
            List<FlightInfo> result = JsonSerializer.Deserialize<List<FlightInfo>>(jsonObj);
            return result;
        }

        public async Task<List<FlightInfo>> getFlightInfoPassFinished(string email, string status)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage message = await client.GetAsync("https://localhost:8443/flightinfo/status?email=" + email+"&status="+status);
            string jsonObj = await message.Content.ReadAsStringAsync();
            List<FlightInfo> result = JsonSerializer.Deserialize<List<FlightInfo>>(jsonObj);
            return result;
        }

        public async Task<List<FlightInfo>> getFlightInfos()
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage message = await client.GetAsync("https://localhost:8443/flightinfo/allflights");
            string jsonObj = await message.Content.ReadAsStringAsync();
            List<FlightInfo> result = JsonSerializer.Deserialize<List<FlightInfo>>(jsonObj);
            return result;
        }

        public async Task<List<FlightInfo>> getFlights(string fromWhere, string toWhere, int numberOfPassengers, DateTime departure, DateTime departureback)
        {
            HttpClient client = new HttpClient();
            StringContent content = new StringContent(JsonSerializer.Serialize(new FlightInfo(new Flight(0,null,null),new Arrival(departure,null,0),new Departure(departureback,null,0))), Encoding.UTF8, "application/json");
            HttpResponseMessage message = await client.PostAsync("https://localhost:8443/flightinfo" + "?fromwhere="+fromWhere+"&towhere="+toWhere+"&numberofpassengers="+numberOfPassengers, content);
            string response = await message.Content.ReadAsStringAsync();
            List<FlightInfo> result = JsonSerializer.Deserialize<List<FlightInfo>>(response);
            return result;
        }
    }
}
