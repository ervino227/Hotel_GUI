import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

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
			      //firstname, last name , address city phone email
			      
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
	
	public void closeConnection() {
		
	}

}
