package com.BrainWash.businesslogic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BrainWash.businesslogicinterface.InterfaceForAdminSpelling;
import com.BrainWash.dbconfig.DatabaseConfig;
import com.BrainWash.model.SpellingBook;

public class AdminSpellingCrudProcess implements InterfaceForAdminSpelling {

	private Connection connection = null;
	private PreparedStatement preStatement = null;
	private ResultSet rs=null;
	private SpellingBook spellingBook=null;
	//Db table
	private String table = "spellingbook";
	//database query
	private String insertSpellingQuery;
	private String getSpellingBySpellingNameQuery;
	private String getAllSpellingByNamesQuery;
	//
	List<SpellingBook> listOfSpellings=null;


	// constructor for get database connection
	
	public AdminSpellingCrudProcess() { 

		connection = new DatabaseConfig().getDatabaseConnection();
	}

	//insert spelling method......................
	
	public String insertSpelling(SpellingBook spellingBook) { 

		System.out.println(spellingBook.getSpellingPronounce());
		System.out.println(spellingBook.getSpellingMeaning());
		String insertStatus = "oops something went wrong";

		insertSpellingQuery = "insert into " + table
				+ " (spellingname,spellingPronounce,spellingMeaning,createdBy,createdAt,spellingStatus) values (?,?,?,?,?,?)";

		try {
			preStatement = connection.prepareStatement(insertSpellingQuery);

			preStatement.setString(1, spellingBook.getSpellingName());
			preStatement.setString(2, spellingBook.getSpellingPronounce());
			preStatement.setString(3, spellingBook.getSpellingMeaning());
			preStatement.setString(4, spellingBook.getCreatedBy());
			preStatement.setDate(5, (Date) spellingBook.getCreatedAt());
			preStatement.setString(6, spellingBook.getSpellingStatus());

			
			if (preStatement.executeUpdate() > 0) {
				insertStatus = "success";
			}

		} catch (SQLException e) {
			System.out.println("Insert Spelling Query is not correct...!!! "+e.getMessage());
			e.printStackTrace();
		}

		return insertStatus;

	}
	
	//get Spelling By SpellingName method......................

	public List<SpellingBook> getSpellingBySpellingName(String spellingName) {
		
		listOfSpellings = new ArrayList();
		
		getSpellingBySpellingNameQuery = "select * from "+table+" where spellingname=?";
		
		try {
			preStatement=connection.prepareStatement(getSpellingBySpellingNameQuery);
			
			preStatement.setString(1, spellingName);
			
			rs=	preStatement.executeQuery();
		
		while(rs.next())
		{
			// addd spelling to the list collection
			
			
			 spellingBook=new SpellingBook();
			  
			 spellingBook.setId(rs.getLong("spellingId"));
			 spellingBook.setSpellingName(rs.getString("spellingName"));
			 spellingBook.setSpellingPronounce(rs.getString("spellingPronounce"));
			 spellingBook.setSpellingMeaning(rs.getString("spellingMeaning"));
			 spellingBook.setCreatedBy(rs.getString("createdBy"));
			 spellingBook.setCreatedAt(rs.getDate("createdAt"));
			 spellingBook.setSpellingStatus(rs.getString("spellingStatus"));
			
			 listOfSpellings.add(spellingBook);
			 
			
		}					
			
		} catch (SQLException e) {
			System.out.println("getSpellingBySpellingNameQuery is not correct...!!! "+e.getMessage());
			e.printStackTrace();
		}
		
		return listOfSpellings;
	}

	//get All SpellingNames method......................
	public List<SpellingBook> getAllSpellingNames() {
		

		// add spelling to the list collection
		listOfSpellings = new ArrayList();
	
		getAllSpellingByNamesQuery = "select * from "+table+" ";
		
		try {
			preStatement=connection.prepareStatement(getAllSpellingByNamesQuery);
			rs=	preStatement.executeQuery();
			
			while(rs.next())
			{
				
				 spellingBook=new SpellingBook();
				  
				 spellingBook.setId(rs.getLong("spellingId"));
				 spellingBook.setSpellingName(rs.getString("spellingName"));
				 spellingBook.setSpellingPronounce(rs.getString("spellingPronounce"));
				 spellingBook.setSpellingMeaning(rs.getString("spellingMeaning"));
				 spellingBook.setCreatedBy(rs.getString("createdBy"));
				 spellingBook.setCreatedAt(rs.getDate("createdAt"));
				 spellingBook.setSpellingStatus(rs.getString("spellingStatus"));
				
				 listOfSpellings.add(spellingBook);
			}	
			} catch (SQLException e) {
				System.out.println("getAllSpellingByNamesQuery is not correct...!!! "+e.getMessage());
				e.printStackTrace();
		}
		
		return listOfSpellings;
	}
	
	
	
	
	
	
	
	
	
	
	

}
