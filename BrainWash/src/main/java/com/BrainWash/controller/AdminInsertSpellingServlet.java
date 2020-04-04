package com.BrainWash.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BrainWash.businesslogic.AdminSpellingCrudProcess;
import com.BrainWash.businesslogicinterface.InterfaceForAdminSpelling;
import com.BrainWash.model.SpellingBook;

/**
 * Servlet implementation class AdminInsertSpelling
 */
public class AdminInsertSpellingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	InterfaceForAdminSpelling ifas=null;
	List<SpellingBook> getSpellingsForExam=null;
	HttpSession adminSession=null;
	
	//Constructor
	public AdminInsertSpellingServlet()
	{
		ifas=new AdminSpellingCrudProcess();
	}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		adminSession=request.getSession(false);
		
		response.setContentType("text/html;charset=UTF-8");
		
		String takeAction=request.getParameter("takeAction");
		
		if(takeAction.equals("AdminInsertSpelling"))
		{
			insertSpelling(request, response);			
		}
		else if(takeAction.equals("AdminUpdateSpelling"))
		{
			
		}
		else if(takeAction.equals("AdminDeleteSpelling"))
		{
			
		}
		else if(takeAction.equals("AdminGetAllSpellingNames"))
		{
			
		}
		else if(takeAction.equals("AdminGetSpellingBySpellingName"))
		{
			
		}
		else if(takeAction.equals("WriteSpellingCheckerExam"))
		{			
			WriteSpellingCheckerExam(request, response);
		}
		else
		{
			
		}
		
	}
	
	
	public void insertSpelling(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String spellingName,spellingPronounce,spellingMeaning;
		
		spellingName=request.getParameter("spellingName");
		spellingPronounce=request.getParameter("spellingPronounce");
		spellingMeaning=request.getParameter("spellingMeaning");
		
		System.out.println(spellingPronounce);
		System.out.println(spellingMeaning);
		
		request.setAttribute("spellingName",spellingName );
		request.setAttribute("spellingPronounce",spellingPronounce );
		request.setAttribute("spellingMeaning",spellingMeaning );
		
		//request.getRequestDispatcher("hindi.jsp").forward(request, response);
		
		  SpellingBook spellingBook = new SpellingBook(); //prepare modal
		  
		  spellingBook.setSpellingName(spellingName);
		  spellingBook.setSpellingPronounce(spellingPronounce);
		  spellingBook.setSpellingMeaning(spellingMeaning);
		  spellingBook.setCreatedBy("Admin"); 
		  spellingBook.setCreatedAt(null);
		  spellingBook.setSpellingStatus("Active");
		  
		//call method for add spelling 
		  String status= ifas.insertSpelling(spellingBook);		  
		  
		  if(status=="success") { 
			  
		  request.setAttribute("successMsg","Spelling addedd Successfull..Please continue to add more");
		  request.getRequestDispatcher("/Pages/Admin/addspelling.jsp").forward(request, response);
		  
		  }else {
		  
		  request.setAttribute("errorMessage",status);
		  request.getRequestDispatcher("/Pages/sharedpage/error.jsp").forward(
		  request, response);
		  
		  }
		
	}
	
	
	public void WriteSpellingCheckerExam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	     List<SpellingBook> getSpellingsForExam	=ifas.getAllSpellingNames();
	     
	     if(getSpellingsForExam.size()!=0) { 
			  
			  request.setAttribute("getSpellingsForExam",getSpellingsForExam);
			  request.getRequestDispatcher("/Pages/User/spellingchecker.jsp").forward(request, response);
			  
			  }else {
				  
			  request.setAttribute("errorMessage","No paper set right now ");
			  request.getRequestDispatcher("/Pages/sharedpage/error.jsp").forward(request, response);
			  
			  }
	     
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
