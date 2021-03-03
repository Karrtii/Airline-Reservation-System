using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace Client.Model
{
    public class Airplane
    {
        [JsonPropertyName("registrationNumber")]
        public int registrationNumber { get; set; }
        [JsonPropertyName("planeType")]
        public string planeType { get; set; }
        [JsonPropertyName("numberOfSeats")]
        public int numberOfSeats { get; set; }

        public Airplane()
        {
        }

        public Airplane(int registrationNumber,string planeType,int numberOfSeats) 
        {
            this.registrationNumber = registrationNumber;
            this.planeType = planeType;
            this.numberOfSeats = numberOfSeats;
        }
    }
}
