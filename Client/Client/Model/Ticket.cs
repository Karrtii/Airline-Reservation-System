using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace Client.Model
{
    public class Ticket
    {
        public Ticket(int price, string luggage)
        {
            this.price = price;
            this.luggage = luggage;
        }

        public Ticket(int price, string luggage,int seat)
        {
            this.price = price;
            this.luggage = luggage;
            this.seat = seat;
        }

        public Ticket()
        {
        }

        [JsonPropertyName("price")]
        public int price { get; set; }
        [JsonPropertyName("luggage")]
        public string luggage { get; set; }
        [JsonPropertyName("seat")]
        public int seat { get; set; }

        public override string ToString()
        {
            return "Price: " + price + " Luggage: " + luggage;
        }
    }
}
