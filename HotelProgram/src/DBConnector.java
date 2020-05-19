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
	static final String PASS = "";

	Connection conn = null;
	Statement stmt = null;

	public DBConnector() {
		
	
	}

	public void createGuest(Guest g) {
		if(!g.getFirstName().isEmpty() && !g.getLastName().isEmpty()) {
			try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			      conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);

			      //STEP 4: Execute a query
			      stmt = conn.createStatement();
			      //firstname, last name , address city phone email
			      
			      String sql = "INSERT INTO guesttable (`firstName`, `lastName`, `Address`, `City`, `Phone`, `Email`) "
			      		+ "VALUES ('" + g.getFirstName()+"','"+g.getLastName()+"','"+g.getAddress()+"','"+g.getCity()+"','"+g.getPhone()+"','"+g.getEmail()+"');";

			      stmt.executeUpdate(sql);
			   }
			catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }
			catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }
			finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			    	  
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
		}
		else
			System.out.println("Missing fields");
			
	}

	public void createReservation(Reservation r) {
		if(!r.getSuiteSelected().isEmpty() && r.getNumAdults() > 0) {
			try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			      conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);

			      //STEP 4: Execute a query
			      stmt = conn.createStatement();
			      
			      
			      String sql = "INSERT INTO `hotelsystem`.`reservations` (`firstName`, `lastName`, `numAdults`, `numChild`, `numNights`, `SuiteType`) "
			      		+ "VALUES ('" + r.getFirstName() +"', '" + r.getLastName()+"', " + r.getNumAdults()+", "+r.getNumChildren()+", "+r.getNumNights()+", '"+r.getSuiteSelected()+ "');" ;

			      stmt.executeUpdate(sql);
			   }
			catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }
			catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }
			finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			    	  
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
		}
		else
			System.out.println("Missing fields");
	}
	
	public Object[][] getReservations() {
		Object[][] array = null;
		
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
		      
		      String sql = "SELECT * FROM reservations;" ;
		      
		      ResultSet results =  stmt.executeQuery(sql);
		      results.last();
		      int numRows = results.getRow();
		      array = new Object[numRows][8];
		      results.first();
		      for(int i =1; i<=numRows; i++) {
		    	  int id = results.getInt("idreservations");
		    	  String firstName = results.getString(2);
		    	  String lastName = results.getString(3);
		    	  int adults = results.getInt(4);
		    	  int children = results.getInt(5);
		    	  String checkIn = results.getString(6);
		    	  int nights = results.getInt(7);
		    	  String suite = results.getString(8);
		    	  
		    	  array[i-1][0] = id;
		    	  array[i-1][1] = firstName;
		    	  array[i-1][2] = lastName;
		    	  array[i-1][3] = adults;
		    	  array[i-1][4] = children;
		    	  array[i-1][5] = checkIn;
		    	  array[i-1][6] = nights;
		    	  array[i-1][7] = suite;
		    	  
		    	  results.next();
		      }
		     
		   }
		catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }
		catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		    	  
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		return array;
		
	}
	
	public int getNumMasterRooms() {
		
		int numRooms = 0;
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
		      
		      
		      String sql = "SELECT * FROM hotelrooms WHERE roomtype = 'Master' and status = 'Open';" ;

		      ResultSet result = stmt.executeQuery(sql);
		      
		      while(result.next()) {
		    	  numRooms++;
		      }
		   }
		catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }
		catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		    	  
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		return numRooms;
	}
	
	public int getNumQueenRooms() {
		int numRooms = 0;
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();

		      String sql = "SELECT * FROM hotelrooms WHERE roomtype = 'Queen' and status = 'Open';" ;

		      ResultSet result = stmt.executeQuery(sql);
		      
		      while(result.next()) {
		    	  numRooms++;
		      }
		   }
		catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }
		catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		    	  
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		return numRooms;
	}
	
	public int getNumTwinRooms() {
		int numRooms = 0;
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
		      
		      
		      String sql = "SELECT * FROM hotelrooms WHERE roomtype = 'Twin' and status = 'Open';" ;

		      ResultSet result = stmt.executeQuery(sql);
		      
		      while(result.next()) {
		    	  numRooms++;
		      }
		   }
		catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }
		catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		    	  
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		return numRooms;
	}
	
	public int getNumFamilyRooms() {
		int numRooms = 0;
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem", USER, PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
		      
		      
		      String sql = "SELECT * FROM hotelrooms WHERE roomtype = 'Family' and status = 'Open';" ;

		      ResultSet result = stmt.executeQuery(sql);
		      
		      while(result.next()) {
		    	  numRooms++;
		      }
		   }
		catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }
		catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		    	  
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		return numRooms;
	}
	public void closeConnection() {
		
	}

}
