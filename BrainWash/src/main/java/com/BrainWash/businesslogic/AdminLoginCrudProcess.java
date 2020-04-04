package com.BrainWash.businesslogic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BrainWash.businesslogicinterface.InterfaceForAdmin;
import com.BrainWash.dbconfig.DatabaseConfig;
import com.BrainWash.model.AdminLogin;
import com.BrainWash.model.SpellingBook;

public class AdminLoginCrudProcess implements InterfaceForAdmin {

	private Connection connection = null;
	private PreparedStatement ps = null;
	private AdminLogin adminLogin=null;
	private String table = "admincreds";
	private ResultSet rs = null;
	//
	private String retrieveAdminLoginData;
	private String insertAdminDataQuery;
	private String getAdminByIdQuery;
	private String adminResetPasswordQuery;

	public AdminLoginCrudProcess() { // constructor

		connection = new DatabaseConfig().getDatabaseConnection();
	}
	
	//admin login validation method...	
	
	public String adminLoginValidation(String adminid ,String password) {
		
		try {

			 retrieveAdminLoginData = "select * from " + table + " where adminid=? and adminpassword =?";

			ps = connection.prepareStatement(retrieveAdminLoginData);

			ps.setString(1, adminid);
			ps.setString(2, password);

			rs = ps.executeQuery();
			
			if(rs.next())
			{
				return (String)rs.getString("adminname");
			}
			

		} catch (SQLException e) {
			System.out.println("RetrieveAdminLoginData Query is not correct...!!! " + e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	//Register admin data method...
	
	public String adminRegistration(String adminid ,String password,String adminname) {
		
	String insertStatus="oops something went wrong";
		
		try {
		
		insertAdminDataQuery="insert into " + table +" (adminid,adminpassword,adminname) values (?,?,?)";
		
		
			ps=	connection.prepareStatement(insertAdminDataQuery);
			
			ps.setString(1, adminid);
			ps.setString(2, password);
			ps.setString(3, adminname);
			
			/*
			 * ps.setString(1, adminLogin.getAdminName()); ps.setString(2,
			 * adminLogin.getAdminPassword()); ps.setString(3,
			 * adminLogin.getAdminPhoneNo());
			 */
			
			if(ps.executeUpdate()>0)
			{
				insertStatus= "success";
			}
					
			
		} catch (SQLException e) {
			System.out.println("insertAdminDataQuery is not correct...!!! "+e.getMessage());
			e.printStackTrace();
		}
		return insertStatus;
		
		
	}
	
}
