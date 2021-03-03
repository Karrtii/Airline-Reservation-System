using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace Client.Model
{
    public class FlightInfo
    {

        [JsonPropertyName("flight")]
        public Flight flight { get; set; }
        [JsonPropertyName("arrival")]
        public Arrival arrival { get; set; }
        [JsonPropertyName("departure")]
        public Departure departure { get; set; }
        [JsonPropertyName("passenger")]
        public Passenger passenger { get; set; }

        public FlightInfo(Flight flight,Arrival arrival,Departure departure) 
        {
            this.flight = flight;
            this.departure = departure;
            this.arrival = arrival;
        }

        public FlightInfo(Flight flight, Arrival arrival, Departure departure,Passenger passenger)
        {
            this.flight = flight;
            this.departure = departure;
            this.arrival = arrival;
            this.passenger = passenger;
        }

        public FlightInfo() 
        {
        
        }
    }
}
