# REST-aurant-IT
## Overall Description
My project will revolve around the design and development of a restaurant Manager. The restaurant manager will have two types of users. An admin user and normal users. Admins should be able to run the application as their primary system. In other words, they should be able to manage their menu through the application, organize their table bookings, and generate receipts for their customers. Regular users should be able to look at the menu, and book a table online it is safe to conclude that this web application is composed of two modules. An admin module, and a user module. Both of the modules are linked and therefore update the same database.

## Requirements
### Functional Requirements

- **Roles / Actors**
  - There are two roles / types of actors: customer, admin
  
- **Customer Functionalities**
   - Customers shall be able to book a table by date and by time
   - Customers shall be able to have a look at the menu items as well as their price
   - Customers shall be able to update a booking
   - Customers shall be able to cancel a booking
 
- **Admin Functionalities**
  - Admins shall be able to print receipts for their customers
  - Admins shall be able to  access the history of their sales on a weekly basis
  - Admins shall be able to access the history of their sales on a monthly basis
  - Admins shall be able to cancel a table booking
  - Admins shall be able to add a table booking
  - Admins shall be able to update a table booking
  - Admins shall be able to add menu items
  - Admins shall be able to remove menu items
  - Admins shall be able to update the pricing of Menu items
  
### Non-functional Requirements

- **Performance**
  - The system shall allow the client to pass Google Lighthouse performance test with at least 80% 
  
- **Scalability**
  - The system shall scale *out* to preserve performance even when the load grows, at a reasonable cost
  
- **Security**
  - The confidentiality and integrity of all data traffic shall be protected
  - The authenticity of both the client and the server shall be ensured
  - Service high availability shall be ensured, i.e., no single point of failure (SPoF) shall be accepted
  
- **Extensibility**
  -If the owners of the restaurant want to extend to other locations, the system should support such a feature  

## Architecture
- **Physical Architecture - Initial**
<p align="center">
  <img src="src/main/resources/Architecture1.JPG">
</p>
<p align="center">
The firewall will analyze incoming traffic based on pre-established security rules. The application server will host the application’s business logic. The database server will  store the data required to manage and effectively run the restaurant.
  </p>

- **Physical Architecture - Protocols & Software**
<p align="center">
   <img src="src/main/resources/Architecture2.JPG">
</p>
<p align="center">
The client will communicate with the firewall through the use of Rest and the HTTPS protocol, therefore all the packets sent by the client will be encrypted. The firewall will relay the request to the application server via the rest and http protocol.  The application server will run Spring Boot as a backend framework on top of the Java Runtime Environment.  Finally, the database server will consist of a PostgreSQL Database Management System.
  </p>

- **Physical Architecture - Resilient (No SPoF) / Scalable**
<p align="center">
  <img src="src/main/resources/Architecture3.JPG">
</p>
<p align="center">
As per the non-functional requirements of this project, the system should support high availability and must have no single point of failure. To satisfy these requirements, a cluster of firewalls, load balancers and application servers will be used. Another non-functional requirement that will be satisfied with this architecture is scalability. 

  </p>

- **Logical Architecture - Inside an Application Server**
<p align="center">
  <img src="src/main/resources/LogicalArchitecture.JPG">
</p>

## Design
### Class Diagrams
- **Entity Class Diagram**
<p align="center">
  <img src="src/main/resources/ERdiagram.jpg">
</p>

- I decided to add the restaurant class to support extensibility, since that I specified within the specifications that the owners could open other restaurants in new locations.
- Auditable is a super-class specific to the spring framework and JPA and has attributes such as Createdby, CreatedDate, lastModifiedby, lastModifiedDate, since these attributes   are common to all the entities.
- Each restaurant has 1 to many table bookings and orders
- Each Restaurant has one and only menu 
- A menu has 1 to many menu lines, (Pasta, pizza etc…)
- An order has 1 to many order lines which will be used to generate receipts for customers.
 



- **Repositories and Services Class Diagram**
<p align="center">
  <img src="src/main/resources/RepositoryDiagram.jpg">
</p>

<p align="center">
Since I switched to the spring Framework, I can use the crud repository superclass provided by the spring framework. I identified the user, TableBooking and order as services given their complexity. Each service will make use of its own repository as specified within the diagram. 
  </p>

### Sequence Diagrams
- **Data-driven Sequence Diagram**
<p align="center">
  <img src="src/main/resources/SequenceDiagram1.JPG">
</p>
<p align="center">
Since I switched to the Spring framework I can make use of the REST auto-exposed repositories that will manage all the entities specified in the entity class diagram. The client will indeed remotely call one or more repositories through HTTPS/Rest, these repositories will perform CRUD operations (Update, Delete, add…). These entities are mapped directly to a PostgreSQL database through the use of Hibernate.
  </p>

- **Service-driven Sequence Diagram**
<p align="center">
  <img src="src/main/resources/SequenceDiagram2.JPG">
</p>
<p align="center">
A service, as mentioned in class, is fundamentally more complex than simple Crud operations. The client remotely calls a Rest Controller which will call the adequate service. The service in turn calls the repository associated with that service (for instance, the booking service will call the booking repository). The repository will in turn perform crud operations in the adequate table within the database. If Data needs to be returned, the cycle is reversed, the data is sent by the repository to the service then to the REST controller which will remotely return the data to the user.

  </p>


