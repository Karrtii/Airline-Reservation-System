using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace Client.Model
{
    public class Airport
    {
        [JsonPropertyName("IATACode")]
        public string IATACode { get; set; }
        [JsonPropertyName("airportName")]
        public string airportName { get; set; }
        [JsonPropertyName("city")]
        public string city { get; set; }
        [JsonPropertyName("country")]
        public string country { get; set; }

        public Airport(string IATACode,string airportName,string city,string country) 
        {
            this.IATACode = IATACode;
            this.airportName = airportName;
            this.city = city;
            this.country = country;
        }
        public Airport() 
        {
        }
    }
}
