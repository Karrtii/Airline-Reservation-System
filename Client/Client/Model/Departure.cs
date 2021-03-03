using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace Client.Model
{
    public class Departure
    {
        [JsonPropertyName("departureTime")]
        public DateTime departureTime { get; set; }
        [JsonPropertyName("fromWhere")]
        public String fromWhere { get; set; }
        [JsonPropertyName("flightID")]
        public int flightID { get; set; }

        public Departure(DateTime departureTime, String fromWhere, int flightID)
        {
            this.departureTime = departureTime;
            this.fromWhere = fromWhere;
            this.flightID = flightID;
        }
        public Departure() 
        {
        }
    }
}
