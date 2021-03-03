-----------STRONG ENTITIES-----------

Users(userId, userType, email, password, firstName, lastName, dateOfBirth, phoneNumber)
PRIMARY KEY(userId)

Passenger(passportNumber, passportExpirationDate, firstName, lastName, dateOfBirth, gender, nationality, createdBy)
PRIMARY KEY(passportNumber)
FOREIGN KEY(createdBy) REFERENCES Users(userId)

Airplane(registrationNumber, planeType, numberOfSeats)
PRIMARY KEY(registrationNumber)

Flight(flightId, numberOfSeats, flies, status)
PRIMARY KEY(flightId)
FOREIGN KEY(flies) REFERENCES Airplane(registrationNumber)

Airport(iataCode, airportName, city, country)
PRIMARY KEY(iataCode)

-----------WEAK ENTITIES------------

Ticket(bought, reserved, price, luggage, seatNumber)
PRIMARY KEY(passportNumber)
PRIMARY KEY(reserved)
FOREIGN KEY(reserved) REFERENCES Flight(flightId)
FOREIGN KEY(bought) REFERENCES Passenger(passportNumber)

Arrival(arrivalTime, comes, arrives)
FOREIGN KEY(comes) REFERENCES Airport(iataCode)
FOREIGN KEY(arrives) REFERENCES Flight(flightId)

Departure(departureTime, leaves, departs)
FOREIGN KEY(leaves) REFERENCES Airport(iataCode)
FOREIGN KEY(departs) REFERENCES Flight(flightId)























