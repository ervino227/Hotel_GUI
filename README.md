# Hotel_GUI
### A mock Hotel GUI project using Java, Swing, and MySQL 

The main purpose of this program was for me to get comfortable using mySQL database and the JDBC.

Main screen features:
  - Add a new reservation to the database
  - Manage existing reservations
  - Manage hotel rooms
  - Edit and update guest information 
![JWk9yu.jpg](https://iili.io/JWk9yu.jpg)

<!--
image for new reservations screen
-->
Reservation details are created and stored in a mySQL database
- only rooms that have an 'open' status are available
![JWkKGV.jpg](https://iili.io/JWkKGV.jpg)

<!--
image for managing reservations
-->
Existing reservations can be deleted from the database

![JWkn8F.jpg](https://iili.io/JWkn8F.jpg)


<!--
image for managing rooms
-->
Rooms can also be disabled for maintenance or cleaning, if there is no reservation

![JWkoyg.jpg](https://iili.io/JWkoyg.jpg)

### Should you decide to clone this repo,

Make sure you have installed:
  - Java
  - mySQL

furthermore, in the file **DBConnector.java** be sure to provide your password for the mySQL database.
```
static final String USER = "root";
static final String PASS = "";
```
