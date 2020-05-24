import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/";

	// Database credentials
	static final String USER = "root";
	static final String PASS = " ";

	Connection conn = null;
	Statement stmt = null;
	
	//empty constructor 
	public DBConnector() {

	}
	
	/**
	 * Method for creating a guest in the database 
	 * @param g the guest to add to the database 
	 */
	public void createGuest(Guest g) {
		//if the fields for the name are not empty...
		if (!g.getFirstName().isEmpty() && !g.getLastName().isEmpty()) {
			try {
				// STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");
				// STEP 3: Open a connection
				conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);
				// STEP 4: Execute a query
				stmt = conn.createStatement();
				String sql = "INSERT INTO guesttable (`firstName`, `lastName`, `Address`, `City`, `State`, `Phone`, `Email`) "
						+ "VALUES ('" + g.getFirstName() + "','" + g.getLastName() + "','" + g.getAddress() + "','"
						+ g.getCity() + "','" + g.getState() + "','" + g.getPhone() + "','" + g.getEmail() + "');";
				stmt.executeUpdate(sql);
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {

				} // nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // end finally try
			} // end try
		} else
			System.out.println("Missing fields");

	}

	/**
	 * Creates a new reservation entry in the database
	 * @param r the reservation object containing the values of the reservation
	 */
	public void createReservation(Reservation r) {
		if (!r.getSuiteSelected().isEmpty() && r.getNumAdults() > 0) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);
				stmt = conn.createStatement();
				String sql = "INSERT INTO `hotelsystem`.`reservations` (`firstName`, `lastName`, `numAdults`, `numChild`, `Check-In`,`numNights`, `SuiteType`, `roomNumber`) "
						+ "VALUES ('" + r.getFirstName() + "', '" + r.getLastName() + "', " + r.getNumAdults() + ", "
						+ r.getNumChildren() + ", '" +  r.getCheckIn() + "', " +  r.getNumNights() + " , '" + r.getSuiteSelected() + "' , '" + r.getRoomNum() + "');";
				stmt.executeUpdate(sql);
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {

				} // nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // end finally try
			} // end try
		} else
			System.out.println("Missing fields");
	}

	/**
	 * Deletes an existing reservation in the database 
	 * @param resNum the reservation id (primary key) associated with the reservation 
	 */
	public void deleteReservation(int resNum) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);
			stmt = conn.createStatement();
			String sql = "DELETE FROM `reservations` WHERE `idreservations` = '"+ resNum +"' ;";
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {

			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}
	
	/**
	 * Returns a list of reservations in the database 
	 * @return a 2-dimensional Object array of reservation details 
	 */
	public Object[][] getReservations() {
		Object[][] array = null;

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM reservations;";

			ResultSet results = stmt.executeQuery(sql);
			results.last();
			int numRows = results.getRow();
			array = new Object[numRows][9];
			results.first();
			for (int i = 1; i <= numRows; i++) {
				int id = results.getInt("idreservations");
				String firstName = results.getString(2);
				String lastName = results.getString(3);
				int adults = results.getInt(4);
				int children = results.getInt(5);
				String checkIn = results.getString(6);
				int nights = results.getInt(7);
				String suite = results.getString(8);
				int roomNum = results.getInt(9);

				array[i - 1][0] = id;
				array[i - 1][1] = firstName;
				array[i - 1][2] = lastName;
				array[i - 1][3] = adults;
				array[i - 1][4] = children;
				array[i - 1][5] = checkIn;
				array[i - 1][6] = nights;
				array[i - 1][7] = suite;
				array[i - 1][8] = roomNum;

				results.next();
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {

			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return array;

	}

	
	/**
	 * Returns a list of all the hotel rooms 
	 * @return a 2-dimensional Object array of hotel rooms (any status)
	 */
	public Object[][] getRooms() {
		Object[][] array = null;

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();

			String sql = "SELECT * FROM hotelRooms;";

			ResultSet results = stmt.executeQuery(sql);
			results.last();
			int numRows = results.getRow();
			array = new Object[numRows][3];
			results.first();
			for (int i = 1; i <= numRows; i++) {
				int roomNum = results.getInt(1);
				String roomType = results.getString(2);
				String roomStatus = results.getString(3);

				array[i - 1][0] = roomNum;
				array[i - 1][1] = roomType;
				array[i - 1][2] = roomStatus;

				results.next();
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {

			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return array;
	}
	
	/**
	 * Returns a list of all guests in the database 
	 * @return a 2-dimensional Object array of guests who made reservations
	 */
	public Object[][] getGuests() {
		Object[][] array = null;

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM guesttable;";

			ResultSet results = stmt.executeQuery(sql);
			results.last();
			int numRows = results.getRow();
			array = new Object[numRows][8];
			results.first();
			for (int i = 1; i <= numRows; i++) {
				int id = results.getInt(1);
				String firstName = results.getString(2);
				String lastName = results.getString(3);
				String address = results.getString(4);
				String city = results.getString(5);
				String state = results.getString(6);
				String phone = results.getString(7);
				String email = results.getString(8);

				array[i - 1][0] = id;
				array[i - 1][1] = firstName;
				array[i - 1][2] = lastName;
				array[i - 1][3] = address;
				array[i - 1][4] = city;
				array[i - 1][5] = state;
				array[i - 1][6] = phone;
				array[i - 1][7] = email;

				results.next();
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {

			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return array;
	}
	
	/**
	 * Updates the fields in a row in the guesttable in the database 
	 * @param guestNum the primary key representing the guest number
	 * @param address the street address of the guest
	 * @param city the city of the guest 
	 * @param state the state of the guest
	 * @param phone the phone number of the guest 
	 * @param email the email of the guest 
	 */
	public void updateGuest(int guestNum, String address, String city, String state, String phone, String email) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);
			stmt = conn.createStatement();
			String sql = "UPDATE guesttable SET address = '" + address + "', city = '" + city + "', state = '" + state + "', phone = '" + phone + "', email = '" + email + "' WHERE guestNumber = " + guestNum + ";";
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {

			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}
	
	/**
	 * Retrieves a room number for a reservation depending on the type of room selected 
	 * @param suiteType the type of room selected (Master, Queen, Twin, Family)
	 * @return a room number with an 'Open' status and matching room type 
	 */
	public int getRoomNumber(String suiteType) {
		int id = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM hotelrooms WHERE roomType = '" + suiteType + "' AND status = 'Open';";
			ResultSet results = stmt.executeQuery(sql);
			results.first();
			id = results.getInt(1);
			
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {

			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return id;
	}
	
	/**
	 * Allows a room to be disabled for cleaning/maintenance
	 * @param roomNum the room number 
	 * @param roomStatus the current status of the room 
	 */
	public void changeRoomStatus(int roomNum, String roomStatus) {
		if (roomStatus.equals("Open")) {
			// set to closed
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);
				stmt = conn.createStatement();
				String sql = "UPDATE hotelrooms SET status = 'Closed' WHERE roomNumber = " + roomNum + ";";
				stmt.executeUpdate(sql);
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {

				} // nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // end finally try
			} // end try
		} else if (roomStatus.equals("Closed")) {
			// set to open
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);
				stmt = conn.createStatement();
				String sql = "UPDATE hotelrooms SET status = 'Open' WHERE roomNumber = " + roomNum + ";";
				stmt.executeUpdate(sql);
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {

				} // nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // end finally try
			} // end try
		}
	}

	/**
	 * Set a rooms status to 'Reserved'
	 * @param room the room number to be reserved 
	 */
	public void reserveRoom(int room) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);
			stmt = conn.createStatement();
			String sql = "UPDATE hotelrooms SET status = 'Reserved' WHERE roomNumber = " + room + ";";
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {

			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}
	
	/**
	 * Get the number of Master Suites available 
	 * @return a number representing 'Open' Master Suites
	 */
	public int getNumMasterRooms() {

		int numRooms = 0;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM hotelrooms WHERE roomtype = 'Master' and status = 'Open';";
			ResultSet result = stmt.executeQuery(sql);

			while (result.next()) {
				numRooms++;
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {

			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return numRooms;
	}

	/**
	 * Get the number of Queen Suites available 
	 * @return a number representing 'Open' Queen Suites
	 */
	public int getNumQueenRooms() {
		int numRooms = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM hotelrooms WHERE roomtype = 'Queen' and status = 'Open';";

			ResultSet result = stmt.executeQuery(sql);

			while (result.next()) {
				numRooms++;
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {

			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return numRooms;
	}

	/**
	 * Get the number of Twin Suites available
	 * @return a number representing 'Open' Twin Suites
	 */
	public int getNumTwinRooms() {
		int numRooms = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM hotelrooms WHERE roomtype = 'Twin' and status = 'Open';";

			ResultSet result = stmt.executeQuery(sql);

			while (result.next()) {
				numRooms++;
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {

			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return numRooms;
	}

	/**
	 * Get the number of Family Suites available 
	 * @return a number representing 'Open' Family Suites
	 */
	public int getNumFamilyRooms() {

		int numRooms = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM hotelrooms WHERE roomtype = 'Family' and status = 'Open';";

			ResultSet result = stmt.executeQuery(sql);

			while (result.next()) {
				numRooms++;
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {

			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return numRooms;
	}

	/**
	 * Open a room that was previously reserved
	 * @param roomNum the room the remove reserved status from 
	 */
	public void clearRoom(int roomNum) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);
			stmt = conn.createStatement();
			String sql = "UPDATE hotelrooms SET status = 'Open' WHERE roomNumber = " + roomNum + ";";
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {

			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}

}
