package com.BrainWash.businesslogic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.BrainWash.businesslogicinterface.InterfaceForUserRegistration;
import com.BrainWash.dbconfig.DatabaseConfig;
import com.BrainWash.model.UserLogin;
import com.BrainWash.model.UserRegister;

public class UserRegistrationCrudProcess implements InterfaceForUserRegistration {

	private Connection connection = null;
	private PreparedStatement ps = null;
	private String table = "userdetails";
	private ResultSet rs = null;

	public UserRegistrationCrudProcess() { // constructor

		connection = new DatabaseConfig().getDatabaseConnection();
	}

	public String userLoginValidation(UserLogin userlogin) {

		try {

			String retrieveLoginData = "select * from " + table + " where email=? and password =?";

			ps = connection.prepareStatement(retrieveLoginData);

			System.out.println(userlogin.getEmail());
			System.out.println(userlogin.getPassword());

			ps.setString(1, userlogin.getEmail());
			ps.setString(2, userlogin.getPassword());

			rs = ps.executeQuery();
			
			if(rs.next())
			{
				/*
				 System.out.println(rs.getString("email"));
				 System.out.println(rs.getString("password"));
				 */
				
				return rs.getString("name");
			}
						

		} catch (SQLException e) {
			System.out.println("User login Query is not correct...!!! " + e.getMessage());
			e.printStackTrace();
		}

		return null;
	}
	
	// register method
	
public String registerUser(UserRegister userRegister) {
		
		String insertStatus="oops something went wrong";
		
		try {
		
		String insertQuery="insert into userdetails(email,name,password,dateofbirth,userstatus) values (?,?,?,?,?)";
		
		
			ps=	connection.prepareStatement(insertQuery);
			ps.setString(1, userRegister.getEmail());
			ps.setString(2, userRegister.getName());
			ps.setString(3, userRegister.getPassword());
			ps.setDate(4, (Date) userRegister.getDateOfBirth());
			ps.setString(5, userRegister.getUserStatus());
			
			if(ps.executeUpdate()>0)
			{
				insertStatus= "success";
			}
					
			
		} catch (SQLException e) {
			System.out.println("Insert Query is not correct...!!! "+e.getMessage());
			e.printStackTrace();
		}
		return insertStatus;

}
}
