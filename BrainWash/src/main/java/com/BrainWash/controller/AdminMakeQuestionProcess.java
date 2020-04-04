package com.BrainWash.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;

import com.BrainWash.businesslogic.AdminMakeQuestionCrudProcess;
import com.BrainWash.businesslogicinterface.InterfaceForAdminMakeQuestion;
import com.BrainWash.model.QuestionBook;
import com.BrainWash.model.SpellingBook;

/**
 * Servlet implementation class AdminMakeQuestionProcess
 */
public class AdminMakeQuestionProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InterfaceForAdminMakeQuestion ifamq=null;
	private QuestionBook questionBook= null;
	private static int scoreOfUserExam=0;
	HttpSession adminSession,session=null;
	
	
	public AdminMakeQuestionProcess()
	{
		ifamq=new AdminMakeQuestionCrudProcess();
		
	}
	
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
		
		adminSession=request.getSession(false);
		session=request.getSession(false);
		
		response.setContentType("text/html;charset=UTF-8");
		
		String takeAction=request.getParameter("takeAction");
		System.out.println(takeAction);
		
		
		if(takeAction.equals("AdminInsertQuestion"))
		{
			addQuestion(request, response);			
		}
		else if(takeAction.equals("AdminUpdateQuestion"))
		{
			updateQuestion(request, response);
		}
		else if(takeAction.equals("AdminDeleteQuestion"))
		{
			deleteQuestion(request, response);
		}
		else if(takeAction.equals("WriteEnglishExam"))
		{
			getAllQuestions(request, response);
		}
		else if(takeAction.equals("CheckAnswer"))
		{
			checkAnswer(request, response);
		}
		else if(takeAction.equals("getScore"))
		{
			getScore(request, response);
		}
		
		} catch (Exception e) {
			
			request.setAttribute("errorMessage","something went wrong");
			request.getRequestDispatcher("/Pages/sharedpage/error.jsp").forward(request, response);
			System.out.println(e.getMessage());
			  e.printStackTrace();
		}
	}

	
	public void addQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String question= request.getParameter("question");
		String option1= request.getParameter("option1");
		String option2= request.getParameter("option2");
		String option3= request.getParameter("option3");
		String option4= request.getParameter("option4");
		String answer=request.getParameter("answer");
		String category=request.getParameter("category");
		
		questionBook = new QuestionBook(); //prepare modal
		  
		questionBook.setQuestion(question);
		questionBook.setOption1(option1);
		questionBook.setOption2(option2);
		questionBook.setOption3(option3);
		questionBook.setOption4(option4);
		questionBook.setAnswer(answer);
		questionBook.setQuestioncategory(category);
		questionBook.setQuestionstatus("active");
		  
		//call method for add spelling 
		  boolean status= ifamq.addQuestion(questionBook);	  
		  
		  if(status==true) { 
			  
		  request.setAttribute("successMsg","Question added Successful...Please continue to add more");
		  request.getRequestDispatcher("/Pages/Admin/makequestion.jsp").forward(request, response);
		  
		  }else {
		  
		  request.setAttribute("errorMessage","something went wrong");
		  request.getRequestDispatcher("/Pages/sharedpage/error.jsp").forward(request, response);
		  
		  }
	}
	
	public void updateQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}
	
	public void deleteQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}
	
	public void getAllQuestions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<QuestionBook> getAllQuestions= ifamq.getAllQuestions();
		
	     
	     if(getAllQuestions.size()!=0) { 
			  
	    	 session.setAttribute("getAllQuestions",getAllQuestions);
			  //request.getRequestDispatcher("/Pages/User/take_exam.jsp").forward(request, response);
			  
			  request.getRequestDispatcher("/Pages/User/take_exam.jsp").forward(request, response);
			  
			  }else {
				  
			  request.setAttribute("errorMessage","No paper set right now ");
			  request.getRequestDispatcher("/Pages/sharedpage/error.jsp").forward(request, response);
			  
			  }
		
	}
	
	public void checkAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		int questionid= Integer.parseInt(request.getParameter("questionid"));
		String option= request.getParameter("option");
				  
		System.out.println(questionid);
		System.out.println(option);
		//call method for check answer
	    scoreOfUserExam= ifamq.checkAnswer(questionid,option,scoreOfUserExam);
		  
		 System.out.println(scoreOfUserExam);
		  
		 request.getRequestDispatcher("/Pages/User/take_exam.jsp").forward(request, response);
		  
	}
	
	public void getScore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println(scoreOfUserExam);
		session.setAttribute("getScore",scoreOfUserExam);
		  request.getRequestDispatcher("/Pages/User/score.jsp").forward(request, response);
		  
	}
	
	
	/*
	 * public void getExistingQuestionByName() {
	 * 
	 * }
	 */
}

