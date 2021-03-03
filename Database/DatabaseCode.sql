CREATE SCHEMA airline;
SET SEARCH_PATH TO airline;

/* CREATE DOMAIN ENTITIES */
CREATE DOMAIN id AS INTEGER NOT NULL;
CREATE DOMAIN Names AS VARCHAR(100) NOT NULL;
CREATE DOMAIN iata AS VARCHAR(3) NOT NULL;

/* CREATE TABLES */
CREATE TABLE Users(
	userId SERIAL PRIMARY KEY,
	userType VARCHAR(8) NOT NULL CHECK(userType IN ('operator', 'customer')) DEFAULT 'customer',
	email VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
	firstName Names,
	lastNames Names,
	dateOfBirth DATE NOT NULL,
	phoneNumber DECIMAL(20) NOT NULL
);

CREATE TABLE Passenger(
    passportNumber DECIMAL(10) NOT NULL PRIMARY KEY,
    passportExpirationDate DATE NOT NULL,
    firstName Names,
    lastName Names,
    dateOfBirth DATE NOT NULL,
    gender CHAR(1) NOT NULL CHECK(gender IN ('F', 'M')),
    nationality VARCHAR(20),
    createdBy id,
    FOREIGN KEY(createdBy) REFERENCES Users(userId)
);

CREATE TABLE Airplane(
	registrationNumber Id PRIMARY KEY,
	planeType VARCHAR(100) NOT NULL,
	numberOfSeats DECIMAL(5) NOT NULL
);

CREATE TABLE Flight(
	flightId SERIAL PRIMARY KEY,
	numberOfSeats DECIMAL(5) NOT NULL,
	flies id,
	status varchar(20) NOT NULL CHECK (status in ('on time','delayed','cancelled','finished')) DEFAULT 'on time',
	FOREIGN KEY(flies) REFERENCES Airplane(registrationNumber)
);

CREATE TABLE Ticket(
    bought DECIMAL(10) NOT NULL, 
	reserved id,
	price NUMERIC(10, 2) NOT NULL CHECK(price >= 0),
    seatNumber DECIMAL(5) NOT NULL,
    luggage VARCHAR(50) NOT NULL DEFAULT 'NONE',
    FOREIGN KEY(bought) REFERENCES Passenger(passportNumber),
	FOREIGN KEY(reserved) REFERENCES Flight(flightId),
	PRIMARY KEY(reserved, bought)
);

CREATE TABLE Airport(
	iataCode iata PRIMARY KEY,
	airportName Names,
	city Names,
	country Names
);

CREATE TABLE Arrival(
	arrivalTime TIMESTAMP NOT NULL,
	comes iata,
	arrives id,
	FOREIGN KEY(comes) REFERENCES Airport(iataCode),
	FOREIGN KEY(arrives) REFERENCES Flight(flightId)
);

CREATE TABLE Departure(
	departureTime TIMESTAMP NOT NULL,
	leaves iata,
	departs id,
	FOREIGN KEY(leaves) REFERENCES Airport(iataCode),
	FOREIGN KEY(departs) REFERENCES Flight(flightId)
);

insert into airplane values (737, 'Boeing 737', 198),(919, 'Comac C919', 174),(21, 'Irkut MC21', 138);
insert into airport values ('VIE', 'Vienna Airport', 'Vienna', 'Austria'), ('CPH', 'Copenhagen Airport', 'Copenhagen', 'Denmark');