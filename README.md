1. The jdk for the project is 1.8 please.
2. You will need maven please install it and create the appropriate environmental variables.
3. Make sure your JAVAHOME points to 1.8
4. Install Postgres it will be our database
5. Add a user with username 'postgres' and password 'password'
6. Add a database called StockMarket.
7. You can change the database settings in the application.properties under src/main/resources
8. To run the project you can set up a Spring boot project in your IDE the main class is com.stocks.Application. If not using an IDE, in a command prompt type "mvn spring-boot:run"
9. Go to localhost:8090
10. The home page should have the documentation for the api along with a simple interface. The helper.html page in the root of the project also has the api documentation.