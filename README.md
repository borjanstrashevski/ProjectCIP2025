Auction & Bidding API Project
This is my project for the CIP course, 2025.
I made a REST API for auctions and bidding using Spring Boot and H2 database.



Features

•	You can create, see, update, and delete auctions (CRUD).

•	Every endpoint needs an API key for security.

•	The data is saved in H2 in-memory database.

•	I tested the API with Postman.

•	If API key is missing or wrong, you get an error.

•	You can see all data in the H2 console.


How to Run

1.	Clone the project from GitHub:
git clone https://github.com/your-username/your-repo-name.git

2.	Open the project in IntelliJ, Eclipse, or another Java IDE.

3.	Run the application (run DemoApplication.java or use mvn spring-boot:run).

4.	The API will be available at:
http://localhost:8080

API Key

•	Every request must have this header:
X-API-Key: 25042004

•	If you do not send the API key or if it is wrong, you will get an error message.






Example Endpoints

POST /api/v1/auctions - Create auction
GET /api/v1/auctions - List all auctions
GET /api/v1/auctions/{id} - Get auction by ID
PATCH /api/v1/auctions/{id}/status - Change auction status
PUT /api/v1/auctions/{id} - Update all auction data
DELETE /api/v1/auctions/{id} - Delete auction

All endpoints need the API key header.


H2 Console

•	Open this link in your browser: http://localhost:8080/h2-console

•	JDBC URL: jdbc:h2:mem:actionandbiddingdb

•	User: sa

•	Password: boki12321 (or leave blank if not set)

•	Here you can see the tables and all data.


How to Test

•	Use Postman to send requests to the API.

•	Always add the header: X-API-Key: 25042004

•	Try to create, see, update, and delete auctions.

•	Try sending request without API key to see the error.









Thank you for reading about my project!

Borjan Strashevski
![image](https://github.com/user-attachments/assets/b41c5a2a-c03c-4883-822d-25576124e75f)
