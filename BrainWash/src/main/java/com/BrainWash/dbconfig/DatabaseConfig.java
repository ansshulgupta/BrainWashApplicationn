package com.BrainWash.dbconfig;

import java.sql.*;


public class DatabaseConfig {

	private Connection connection=null;
	
	public Connection getDatabaseConnection()
	{
		String databaseUrl = "jdbc:mysql://localhost/brainwash";
		String databaseUserName="root";
		String databasePassword="discover";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(databaseUrl, databaseUserName, databasePassword);
			System.out.println("Database connected......");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Database driver issue");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Database connection issue either databaseUrl or databaseUserName or databasePassword");
			e.printStackTrace();
		}	
		
		return connection;
	}
	
	
	
}
