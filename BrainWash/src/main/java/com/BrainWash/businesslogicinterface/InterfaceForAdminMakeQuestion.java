package com.BrainWash.businesslogicinterface;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BrainWash.model.QuestionBook;

public interface InterfaceForAdminMakeQuestion {
	
	
	public boolean addQuestion(QuestionBook questionBook);
	
	public List<QuestionBook> getAllQuestions() ;
	
	public int checkAnswer(int questionId,String option,int result);
	
	/*
	 * public boolean updateQuestion();
	 * 
	 * public boolean deleteQuestion();
	 */
		
	/*
	 * public void getExistingQuestionByName() ;
	 */

}
