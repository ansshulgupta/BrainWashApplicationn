package com.BrainWash.businesslogicinterface;

import com.BrainWash.model.AdminLogin;

public interface InterfaceForAdmin {

	
	
	
	public String adminLoginValidation(String adminid ,String password);
	
	public String adminRegistration(String adminid ,String password,String adminname);
	
	//public AdminLogin getAdminById(int adminId);
	
	//public String changeAdminPassword(int adminId,String resetPassword);
	
	//public String updateAdminDetails(AdminLogin adminLogin);
	
}
