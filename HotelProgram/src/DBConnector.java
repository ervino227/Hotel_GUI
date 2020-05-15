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
	static final String PASS = "";

	Connection conn = null;
	Statement stmt = null;

	public DBConnector() {
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating database...");
		      stmt = conn.createStatement();
		      
		      String sql = "CREATE DATABASE mySTUDENTS";
		      stmt.executeUpdate(sql);
		      System.out.println("Database created successfully...");
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

	public void createGuest() {

	}

	public void createReservation() {

	}
	
	public void closeConnection() {
		
	}

}
