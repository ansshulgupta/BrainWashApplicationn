package com.BrainWash.businesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BrainWash.businesslogicinterface.InterfaceForAdminMakeQuestion;
import com.BrainWash.dbconfig.DatabaseConfig;
import com.BrainWash.model.QuestionBook;
import com.BrainWash.model.SpellingBook;

public class AdminMakeQuestionCrudProcess implements InterfaceForAdminMakeQuestion {

	private Connection connection = null;
	private PreparedStatement preStatement = null;
	private ResultSet rs = null;
	private QuestionBook questionBook = null;
	private List listOfQuestions = null;
	// Db table
	private String dbTable = "QuestionBank";
	// database query
	private String insertQuestionQuery;
	private String getAllQuestionQuery;
	private String getAllQuestionByQuestionNamesQuery;
	private String checkAnswerQuery;

	// constructor for get database connection

	public AdminMakeQuestionCrudProcess() {

		connection = new DatabaseConfig().getDatabaseConnection();
	}

	// add question method
	public boolean addQuestion(QuestionBook questionBook) {

		boolean insertStatus = false;

		insertQuestionQuery = "insert into " + dbTable
				+ " (question,option1,option2,option3,option4,answer,questioncategory,questionstatus) values (?,?,?,?,?,?,?,?)";

		try {
			preStatement = connection.prepareStatement(insertQuestionQuery);

			preStatement.setString(1, questionBook.getQuestion());
			preStatement.setString(2, questionBook.getOption1());
			preStatement.setString(3, questionBook.getOption2());
			preStatement.setString(4, questionBook.getOption3());
			preStatement.setString(5, questionBook.getOption4());
			preStatement.setString(6, questionBook.getAnswer());
			preStatement.setString(7, questionBook.getQuestioncategory());
			preStatement.setString(8, questionBook.getQuestionstatus());

			if (preStatement.executeUpdate() > 0) {
				insertStatus = true;
			}

		} catch (SQLException e) {
			System.out.println("insertQuestionQuery is not correct...!!! " + e.getMessage());
			e.printStackTrace();
		}
		return insertStatus;
	}

	public List<QuestionBook> getAllQuestions() {

		listOfQuestions = new ArrayList();

		getAllQuestionQuery = "select * from " + dbTable + " ";

		try {
			preStatement = connection.prepareStatement(getAllQuestionQuery);
			rs = preStatement.executeQuery();

			while (rs.next()) {
				// add question list in to the list Model

				questionBook = new QuestionBook();

				questionBook.setQuestionid(rs.getInt("questionid"));
				questionBook.setQuestion(rs.getString("question"));
				questionBook.setOption1(rs.getString("option1"));
				questionBook.setOption2(rs.getString("option2"));
				questionBook.setOption3(rs.getString("option3"));
				questionBook.setOption4(rs.getString("option4"));
				questionBook.setAnswer(rs.getString("answer"));
				questionBook.setQuestioncategory(rs.getString("questioncategory"));
				questionBook.setQuestionstatus(rs.getString("questionstatus"));

				listOfQuestions.add(questionBook);
			}
		} catch (SQLException e) {
			System.out.println("getAllQuestionQuery is not correct...!!! " + e.getMessage());
			e.printStackTrace();
		}

		return listOfQuestions;
	}

	public int checkAnswer(int questionId, String option, int result) {
		
		rs=getQuestionByQuestionId(questionId);
			
		try {
			if(rs.next())
			{
				System.out.println("rs "+rs.getString("answer"));
				if(rs.getString("answer").equalsIgnoreCase(option))
				{
					result++;
				}else {
					result--;
				}
				
				
			}
		} catch (SQLException e) {
			System.out.println("Result set contains zero data...!!! " + e.getMessage());
			e.printStackTrace();
		}

			
		return result;
	}
	
	
	public ResultSet getQuestionByQuestionId(int questionId)
	{
		checkAnswerQuery = "select answer from " + dbTable + " where questionid=?";

		try {
			preStatement = connection.prepareStatement(checkAnswerQuery);
			preStatement.setInt(1, questionId);

			rs = preStatement.executeQuery();

						
		} catch (SQLException e) {
			System.out.println("checkAnswerQuery is not correct...!!! " + e.getMessage());
			e.printStackTrace();
		}
		
		
		return rs;
		
	}

}
