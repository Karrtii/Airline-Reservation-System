using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Client.Security
{
    public class SecurityService
    {
        // Flight Details
        public string passengerPassportFlightDetails { get; set; }
        public string flightIDFlightDetails { get; set; }

        //Flight Result
        public string originFlightResult { get; set; }
        public string destinationFlightResult { get; set; }
        public string wishedDepartureFlightResult { get; set; }
        public string adultsFlightResult { get; set; }
        public string childrenFlightResult { get; set; }

        //Picked Flight
        public string flightIDPickedFlight { get; set; }
        public string adultPickedFlight { get; set; }
        public string childrenPickedFlight { get; set; }
        public string pricePickedFlight { get; set; }
        public string returningPickedFlight { get; set; }
    }
}
