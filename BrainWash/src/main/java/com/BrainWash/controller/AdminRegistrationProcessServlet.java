package com.BrainWash.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BrainWash.businesslogic.AdminLoginCrudProcess;
import com.BrainWash.businesslogic.UserRegistrationCrudProcess;
import com.BrainWash.businesslogicinterface.InterfaceForAdmin;
import com.BrainWash.businesslogicinterface.InterfaceForUserRegistration;
import com.BrainWash.model.UserLogin;
import com.BrainWash.model.UserRegister;

/**
 * Servlet implementation class AdminRegistrationProcessServlet
 */
public class AdminRegistrationProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	HttpSession adminSession =null;
	InterfaceForAdmin ifa = null;
	
	public AdminRegistrationProcessServlet()
	{
		 
		ifa = new AdminLoginCrudProcess();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		adminSession=request.getSession();
		
		String takeAction=request.getParameter("takeAction");
		System.out.println(takeAction);
		
		
		if(takeAction.equals("admin_registration"))
		{
			adminRegistration(request, response);			
		}
		else if(takeAction.equals("adminlogin"))
		{
			adminLoginValidation(request, response);
		}
	}
	
	
	
	public void adminRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
			 String adminid=request.getParameter("adminid");
			 String password=request.getParameter("password");
			 String adminname=request.getParameter("adminname");
			// String createdDate = request.getParameter("date");
			
			/*
			 * AdminLogin adminlogin=new AdminLogin();
			 *  adminlogin.setEmail(email);
			 * adminlogin.setPassword(password); 
			 * adminlogin.setName(name);
			 */
		   
		  String status= ifa.adminRegistration(adminid,password,adminname);
		  
		  
		  if(status=="success")
		  {			   
			  adminSession.setAttribute("adminname",adminname);
			  request.getRequestDispatcher("/Pages/Admin/admin_menu.jsp").forward(request, response);
			  
		  }else {
			  
			  request.setAttribute("errorMessage",status);
			  request.getRequestDispatcher("/Pages/Admin/adminlogin.jsp").forward(request, response);
			  
		  }
		   
			
		
		
	}
	
	public void adminLoginValidation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 String adminid=request.getParameter("adminid");
		 String password=request.getParameter("password");
		
		/*
		  AdminLogin adminlogin=new AdminLogin(); 
		 adminlogin.setEmail(email);
		  adminlogin.setPassword(password);
		 */
		
		
		String adminname = ifa.adminLoginValidation(adminid, password);
			
		
			if(adminname!=null)
			{
				adminSession.setAttribute("adminname",adminname);
				response.sendRedirect(request.getContextPath()+"/Pages/Admin/admin_menu.jsp");
				  
			}
			else {
				request.setAttribute("errorMessage","No Data Found ");
			    request.getRequestDispatcher("/Pages/Admin/adminlogin.jsp").forward(request, response);
				  
			}
		
	}	
	
	
	
	
	
	
	

}
