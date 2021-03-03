using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Client.Model;

namespace Client.Data
{
    public interface IBookingService
    {
        List<int> getAlreadyReservedSeats();
        void setAlreadyReservedSeats(List<int> seats);
        string getUsername();
        void setUsername(string username);
        List<string> getSeatInfo();
        int getPrice();
        void SaveLuggageData(List<Ticket> luggage);
        void setAdultsChildren(int adults, int children);
        int getAdults();
        int getChildren();
        bool IsReturning();
        void setReturn(bool returning);
        int getFlightID();
        void setFlightID(int id);
        void SavePassengerData(List<Passenger> passengers, int price);
        void SaveInfo(int numberOfPassengers);
        void SaveSeatInfo(List<string> seats,int price);
        List<Passenger> getPassengers();
        List<Ticket> getLuggage();

        int getWarning();
        int getDelay();
        void setWarning(int num);
        void setDelay(int num);
    }
}
