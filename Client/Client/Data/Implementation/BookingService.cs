using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Client.Model;

namespace Client.Data.Implementation
{
    public class BookingService : IBookingService
    {
        List<Passenger> passengers;
        List<Ticket> luggage;
        List<string> seats;
        List<int> alreadyReservedSeats;
        string username;
        int flightid;
        int price = 0;
        List<int> prices;
        int numberOfPassengers = 0;
        bool returning;
        int Adults;
        int Children;
        public int showCancel { get; set; } = 0;
        public int showDelay { get; set; } = 0;

        public void setAlreadyReservedSeats(List<int> seats) 
        {
            alreadyReservedSeats = new List<int>(seats);
        }
        public List<int> getAlreadyReservedSeats() 
        {
            return alreadyReservedSeats;
        }
        public void setUsername(string username) 
        {
            this.username = username;
        }

        public string getUsername() 
        {
            return this.username;
        }
        
        public List<Passenger> getPassengers()
        {
            return this.passengers;
        }

        public void SaveInfo(int numberOfPassengers)
        {
            this.numberOfPassengers = numberOfPassengers;
        }

        public void SavePassengerData(List<Passenger> passengers, int price)
        {
            this.passengers = new List<Passenger>(passengers);
            this.price = price;
            SaveInfo(passengers.Count);
        }

        public void SaveLuggageData(List<Ticket> luggage) 
        {
            this.luggage = new List<Ticket>(luggage);
            foreach(Ticket t in luggage) 
            {
                t.price += this.price;
            }
        }

        public int getFlightID() 
        {
            return flightid;
        }
        public void setFlightID(int id)
        {
            this.flightid = id;
        }
        public int getPrice() 
        {
            return price;
        }
        public void SaveSeatInfo(List<string> seats, int price)
        {
            this.seats = new List<string>(seats);
            for(int i = 0; i < seats.Count; i++) 
            {
                if (seats[i].Length != 6)
                {
                    luggage[i].price += price;
                }
            }
        }

        public List<string> getSeatInfo() 
        {
            return seats;
        }

        public bool IsReturning()
        {
            return this.returning;
        }

        public void setReturn(bool returning)
        {
            this.returning = returning;
        }

        public void setAdultsChildren(int adults, int children)
        {
            this.Adults = adults;
            this.Children = children;
        }

        public int getAdults()
        {
            return Adults;
        }

        public int getChildren()
        {
            return Children;
        }

        public List<Ticket> getLuggage()
        {
            return luggage;
        }

        public int getWarning()
        {
            return showCancel;
        }

        public int getDelay()
        {
            return showDelay;
        }

        public void setWarning(int num)
        {
            showCancel = num;
        }

        public void setDelay(int num)
        {
            showDelay = num;
        }
    }
}
