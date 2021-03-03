package Model;

import DAO.*;
import Shared.*;

public class PersistenceModel implements Persistence
{
  public static final String JDBCURL = "jdbc:postgresql://localhost:5432/Airline?currentSchema=airline";
  public static final String username = "postgres";
  public static final String password = "batman7728";

  private FlightsDAO flightsDAO;
  private UsersDAO usersDAO;
  private AirplanesDAO airplanesDAO;
  private AirportsDAO airportsDAO;
  private DepartureDAO departureDAO;
  private ArrivalDAO arrivalDAO;
  private PassengerDAO passengerDAO;
  private TicketDAO ticketDAO;

  public PersistenceModel()
  {
    this.airportsDAO = new AirportsDAOImplementation(JDBCURL, username,
        password);
    this.flightsDAO = new FlightsDAOImplementation(JDBCURL, username, password);
    this.usersDAO = new UsersDAOImplementation(JDBCURL, username, password);
    this.airplanesDAO = new AirplanesDAOImplementation(JDBCURL, username,
        password);
    this.departureDAO = new DepartureDAOImplementation(JDBCURL, username,
        password);
    this.arrivalDAO = new ArrivalDAOImplementation(JDBCURL, username, password);
    this.passengerDAO = new PassengerDAOImplementation(JDBCURL, username,
        password);
    this.ticketDAO = new TicketDAOImplementation(JDBCURL, username, password);
  }

  @Override public Request handlerRequest(Request request)
  {
    Request request1 = new Request(null, null);
    switch (request.getType())
    {
      case "GETUser":
        request1 = new Request(null,
            usersDAO.getUser(request.getArg().toString()));
        break;
      case "REGISTERUser":
        request1 = new Request(null, usersDAO.addUser((User) request.getArg()));
        break;
      case "ADDFlight":
        flightsDAO
            .addFlight((Flight) request.getArg(), (Arrival) request.getArg2(),
                (Departure) request.getArg3());
        break;
      case "GETFlights":
        request1 = new Request(null, flightsDAO.getFlights());
        break;
      case "GETPlanes":
        request1 = new Request(null, airplanesDAO.getPlanes());
        break;
      case "GETAirports":
        request1 = new Request(null, airportsDAO.getAirports());
        break;
      case "GETAirplaneByType":
        request1 = new Request(null,
            airplanesDAO.getAirplaneByType(request.getArg().toString()));
        break;
      case "GETIATACodeByName":
        request1 = new Request(null,
            airportsDAO.getAirportByName(request.getArg().toString()));
        break;
      case "GETDepartureByName":
        request1 = new Request(null, departureDAO.getAllDepartures());
        break;
      case "GETArrivalByName":
        request1 = new Request(null, arrivalDAO.getAllArrivals());
        break;
      case "GETFlightByID":
        request1 = new Request(null,
            flightsDAO.getFlightById((int) request.getArg()));
        break;
      case "GETArrival":
        request1 = new Request(null,
            arrivalDAO.getArrivalById((int) request.getArg()));
        break;
      case "GETDeparture":
        request1 = new Request(null,
            departureDAO.getDepartureByID((int) request.getArg()));
        break;
      case "GETAirportByIATA":
        request1 = new Request(null,
            airportsDAO.getAirportByIATA(request.getArg().toString()));
        break;
      case "GETPassenger":
        request1 = new Request(null,
            passengerDAO.getPassenger((int) request.getArg()));
        break;
      case "RegisterPassenger":
        request1 = new Request(null, passengerDAO
            .RegisterPassenger((Passenger) request.getArg(),
                request.getStringArg().toString()));
        break;
      case "CheckAvailability":
        request1 = new Request(null, ticketDAO
            .getTicket((int) request.getArg(), (int) request.getArg2()));
        break;
      case "BookAFlight":
        ticketDAO
            .CreateTicket((Ticket) request.getArg(), (int) request.getArg2(),
                (int) request.getArg3(), (int) request.getArg4());
        break;
      case "GetTickets":
        request1 = new Request(null,
            ticketDAO.getTickets((int) request.getArg()));
        break;
      case "GETMyPassengers":
        request1 = new Request(null,
            passengerDAO.getMyPassengers(request.getArg().toString()));
        break;
      case "GETMyFlights":
        request1 = new Request(null,
            flightsDAO.getFlightsByPassport((int) request.getArg()));
        break;
      case "GETTicket":
        request1 = new Request(null, ticketDAO
            .getTicketPassport((int) request.getArg(),
                Integer.parseInt(request.getStringArg())));
        break;
      case "REMOVETicket":
        ticketDAO.removeTicket((int) request.getArg(),
            Integer.parseInt(request.getStringArg()));
        break;
      case "ModifyUser":
        usersDAO.modifyUser((User) request.getArg(),request.getStringArg());
        break;
      case "SETFinished": flightsDAO.setStatusToFinished((int)request.getArg());
        break;
      case "SETFlightStatus": flightsDAO.setStatusOfFlight((int)request.getArg(),request.getStringArg());
        break;
      case "DELAYFlight": arrivalDAO.delay((int)request.getArg(),Integer.parseInt(request.getStringArg()));
        departureDAO.delay((int)request.getArg(),Integer.parseInt(request.getStringArg()));
        break;
      case "GETTypeById": request1 = new Request(null, airplanesDAO.getTypeByID((int)request.getArg()));
        break;
    }
    return request1;
  }

}
