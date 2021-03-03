using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace Client.Model
{
    public class Arrival
    {
        [JsonPropertyName("arrivalTime")]
        [DataType(DataType.DateTime)]
        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd hh:MM tt}", ApplyFormatInEditMode = true)]
        public DateTime arrivalTime { get; set; }
        [JsonPropertyName("fromWhere")]
        public String fromWhere { get; set; }
        [JsonPropertyName("flightID")]
        public int flightID { get; set; }

        public Arrival(DateTime arrivalTime,String fromWhere,int flightID)
        {
            this.arrivalTime = arrivalTime;
            this.fromWhere = fromWhere;
            this.flightID = flightID;
        }
        public Arrival() 
        {
        }
    }
}
