package com.BrainWash.businesslogicinterface;

import java.sql.ResultSet;

import com.BrainWash.model.UserLogin;
import com.BrainWash.model.UserRegister;

public interface InterfaceForUserRegistration {

	
    	public String registerUser(UserRegister userRegister);
	  
    	public String userLoginValidation(UserLogin userlogin);
	
    	/*
    	 * public void editRegisterUser(String email);
    	 * 
    	 * public void deleteRegisterUser(String email);
    	 * 
    	 * public void getOneRegisterUser(String email);
    	 * 
    	 * public void getAllRegisterUser();
    	 */
}
