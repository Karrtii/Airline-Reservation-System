# Airline-Reservation-System
This is a distributed and heterogeneous system where customers can reserve airplane tickets, and operators can manage the system.

This distributed system is using the three-tier architecture, where the presentation, application and data tiers are separated.

![image](https://user-images.githubusercontent.com/71009398/109881595-dc5e0100-7c78-11eb-96e8-ea0392cb6896.png)

The presentation tier is constructed in Blazor, using C#. The application tier, component-based middleware, is created using the Sring Boot framework, coded in Java. The data tier consists of the Data Access Objects and is implemented in Java. The database is made in PostgreSQL. 

The communication between the presentation and application tiers is webservices using RESTfull webservices. Sockets are used for the communication between the application and data tiers. The data tier can perform CRUD operations on the database via JDBC.

