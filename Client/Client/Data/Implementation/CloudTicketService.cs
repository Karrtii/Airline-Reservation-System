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
    public class CloudTicketService : ITicketService
    {

        public async Task BookAFlight(int passportNum, int flightID, int seatNum, Ticket luggage)
        {
            HttpClient client = new HttpClient();
            HttpContent content = new StringContent(JsonSerializer.Serialize(luggage), Encoding.UTF8, "application/json");
            HttpResponseMessage message = await client.PostAsync("https://localhost:8443/tickets?passNum=" + passportNum+"&id="+flightID+"&seatNum="+seatNum, content);
            string jsonObj = await message.Content.ReadAsStringAsync();
        }

        public async Task cancelFlight(int passportNumber, int flightID)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage message = await client.DeleteAsync("https://localhost:8443/tickets?flightID=" + flightID+"&passNum="+passportNumber);
        }

        public async Task<string> CheckAvailability(int seatNum, int flightID)
        {
            HttpClient client = new HttpClient();
            HttpContent content = new StringContent(JsonSerializer.Serialize(seatNum), Encoding.UTF8, "application/json");
            HttpResponseMessage message = await client.PutAsync("https://localhost:8443/tickets?flightID=" + flightID, content);
            string jsonObj = await message.Content.ReadAsStringAsync();
            return jsonObj;
        }

        public async Task<Ticket> getTicket(int passporNumber, int flightID)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage message = await client.GetAsync("https://localhost:8443/tickets/get?passNum=" + passporNumber+"&flightID=" + flightID);
            string jsonObj = await message.Content.ReadAsStringAsync();
            Ticket tickets = JsonSerializer.Deserialize<Ticket>(jsonObj);
            return tickets;
        }

        public async Task<List<int>> getTickets(int flightID)
        {
            HttpClient client = new HttpClient();
            HttpResponseMessage message = await client.GetAsync("https://localhost:8443/tickets?flightID=" + flightID);
            string jsonObj = await message.Content.ReadAsStringAsync();
            List<int> tickets = JsonSerializer.Deserialize<List<int>>(jsonObj);
            return tickets;
        }
    }
}
