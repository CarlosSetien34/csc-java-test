Price Lookup REST API Project
Description
This project is a REST API developed in Java 17 using Spring Boot. The API allows you to query prices stored in an in-memory H2 database. This project can be used as a starting point for systems that need to manage and query product prices or similar items.

Technologies
Java 17
Spring Boot 3.x
H2 Database
Maven
Features
Read prices: Allows reading price records.
Price lookup: Allows querying the price of a product by its ID, date and brand.
In-memory H2 database: Simple configuration for testing and development.

Prerequisites
Before you begin, make sure you have the following installed:

JDK 17 or higher
Maven 3.x
An IDE compatible with Spring Boot (IntelliJ IDEA, Eclipse, etc.)
Installation and Running
Clone the repository:

git clone https://github.com/CarlosSetien34/csc-java-test

Build the project:
mvn clean install

Run the application:

mvn spring-boot:run

API Usage
Available Endpoints
GET /find-price-pvp/pricedate/{pricedate}/productid/{productid}/brandid/{brandid}: retrieve the price with higher priority which matches the input

Database Configuration
The H2 database is automatically configured when the application starts. You can access the H2 console at http://localhost:8080/h2-console using the following credentials:

JDBC URL: jdbc:h2:mem:testdb
User: sa
Password:

Contact
If you have any questions or suggestions, feel free to reach out:

Email: carlossetien34@gmail.com
LinkedIn: https://www.linkedin.com/in/carlos-seti%C3%A9n-cimas-859489136/
