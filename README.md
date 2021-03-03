# Airline-Reservation-System
This is a distributed and heterogeneous system where customers can reserve airplane tickets, and operators can manage the system.

**About the airline reservation system**

Customers can search for available flights depending on their departing and arriving cities, and the departure date.

![image](https://user-images.githubusercontent.com/71009398/109882953-f4cf1b00-7c7a-11eb-9737-870bbd2909ed.png)

Based on how many persons the customer wants to create tickets for, the customer fills in the required information, luggage option and seat number.

![image](https://user-images.githubusercontent.com/71009398/109883179-4d9eb380-7c7b-11eb-80a8-ae2b8a08a6ce.png)

![image](https://user-images.githubusercontent.com/71009398/109883184-5099a400-7c7b-11eb-9b52-314b0d112e81.png)

![image](https://user-images.githubusercontent.com/71009398/109883190-542d2b00-7c7b-11eb-858f-1680d3d8a87a.png)

At the end, the customer needs to fill in the payment information.

![image](https://user-images.githubusercontent.com/71009398/109883244-6c9d4580-7c7b-11eb-861e-48327e65a93b.png)

Once the payment is successful, the customer can view the reserved ticket(s).

![image](https://user-images.githubusercontent.com/71009398/109883333-8ccd0480-7c7b-11eb-929e-9d68ae6ea348.png)

On the operator side, the operator can create new flights, and cancel and delay existing flights. Customers who have reserved seats on cancelled or delayed flights will get notifications informing them of the statud of their reservation.

![image](https://user-images.githubusercontent.com/71009398/109883620-f8af6d00-7c7b-11eb-8ea2-f63ec59acd5a.png)

![image](https://user-images.githubusercontent.com/71009398/109883627-fbaa5d80-7c7b-11eb-9b64-c4280a2aa7c9.png)

**Design of the airline reservation system**

This distributed system is using the three-tier architecture, where the presentation, application and data tiers are separated.

![image](https://user-images.githubusercontent.com/71009398/109882596-6e1a3e00-7c7a-11eb-9587-0a5c15477d26.png)

The presentation tier is constructed in _Blazor_, using _C#_. The application tier, component-based middleware, is created using the _Sring Boot_ framework, coded in _Java_. The data tier consists of the _Data Access Objects_ and is implemented in _Java_. The database is made in _PostgreSQL_. 

The communication between the presentation and application tiers is webservices using _RESTful_ webservices. Sockets are used for the communication between the application and data tiers. The data tier can perform CRUD operations on the database via _JDBC_.

The diagram below shows the package diagram for the airline reservation system.

![image](https://user-images.githubusercontent.com/71009398/109883973-825f3a80-7c7c-11eb-9f30-ce97932fbdc0.png)

Further in-depth documentation of the airline reservation system can be found under the _Documentation_ folder.
