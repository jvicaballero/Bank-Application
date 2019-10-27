package edu.cuny.csi.csc330.bankmanagement;

import java.sql.*;
import javax.swing.*;

public class sqlLiteConnection {
	
	Connection conn = null;
	
	public static Connection dbConnector(){
		try {
			Class.forName("org.sqlite.JDBC");
			//Connects to path where database is located//
			Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/janmarkusmilan/eclipse-workspace/Bank Management Project/src/edu/cuny/csi/csc330/bankmanagement/Bank Accounts.db");
			return conn;
		} 
		catch(Exception e) {	//If not connected print the exception//
			System.out.print(e);
		  	return null;
		}	
	}
}

