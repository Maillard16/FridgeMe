package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnexion {

	public Connection connect(){
		Connection connect = null;
		
	    try {
	      Class.forName("org.sqlite.JDBC");
	      connect = DriverManager.getConnection("jdbc:sqlite:fridgeMe.db");
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    }
	    
	    System.out.println("Connection to database: successfull");
		
		return connect;		
	}
}
