package com.BrainWash.controller;

import java.io.IOException;
import java.text.*;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BrainWash.businesslogic.UserRegistrationCrudProcess;
import com.BrainWash.businesslogicinterface.InterfaceForUserRegistration;
import com.BrainWash.model.UserLogin;
import com.BrainWash.model.UserRegister;

/**
 * Servlet implementation class RegisterProcessServlet
 */
public class UserRegistrationProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpSession session =null;
	InterfaceForUserRegistration ifur = null;
	
	public UserRegistrationProcessServlet()
	{
		 
		 ifur = new UserRegistrationCrudProcess();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		session=request.getSession();
		
		String takeAction=request.getParameter("takeAction");
		System.out.println(takeAction);
		
		
		if(takeAction.equals("user_registration"))
		{
			userRegistration(request, response);			
		}
		else if(takeAction.equals("userlogin"))
		{
			userLoginValidation(request, response);
		}
		else if(takeAction.equals(""))
		{
			//(request, response);
		}
		else if(takeAction.equals(""))
		{
			//(request, response);
		}
		else if(takeAction.equals(""))
		{
			//(request, response);
		}
		else if(takeAction.equals(""))
		{
			//(request, response);
		}
		
		
		
	}
	
	
	public void userRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
			
			 String email=request.getParameter("email");
			 String name=request.getParameter("name");
			 String password=request.getParameter("password");
			// String createdDate = request.getParameter("date");
			
		   UserRegister userRegister = new UserRegister();
		   userRegister.setEmail(email);
		   userRegister.setName(name);
		   userRegister.setPassword(password);
		   
		  String status= ifur.registerUser(userRegister);
		  
		  
		  if(status=="success")
		  {			   

				session.setAttribute("username",name);
				response.sendRedirect(request.getContextPath()+"/Pages/User/menu.jsp");
			  
		  }else {
			  
			  request.setAttribute("errorMessage",status);
			  request.getRequestDispatcher("/Pages/sharedpage/error.jsp").forward(request, response);
			  
		  }
		   
			
		
		
	}
	
	public void userLoginValidation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 String email=request.getParameter("email");
		 String password=request.getParameter("password");
		
		UserLogin userlogin=new UserLogin();
		userlogin.setEmail(email);
		userlogin.setPassword(password);
		
		
		String username = ifur.userLoginValidation(userlogin);
			
		
			if(username!=null)
			{
				session.setAttribute("username",username);
				response.sendRedirect(request.getContextPath()+"/Pages/User/menu.jsp");
				  
			}
			else {
				request.setAttribute("errorMessage","No Data Found ");
			    request.getRequestDispatcher("/Pages/User/userlogin.jsp").forward(request, response);
				  
			}
		
	}
		
	
	

}
