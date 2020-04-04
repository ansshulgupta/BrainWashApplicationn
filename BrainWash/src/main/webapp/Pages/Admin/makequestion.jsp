<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Make Question</title>
<p>Welcome to <%=session.getAttribute("adminname") %></p>    
     <p align ='right'><a href="${pageContext.request.contextPath}/Pages/Admin/admin_menu.jsp">Menu</a></p>
    <p align ='right'><a href="${pageContext.request.contextPath}/LoggingoutProcess">Logout</a></p>
</head>
<body>


					<form action="${pageContext.request.contextPath}/AdminMakeQuestionProcess" method="post"  >
					<table>
					<tr><td>Question:</td><td><textarea rows="3" cols="" name="question" ></textarea></td></tr>
					<tr><td>Option1:</td><td><input type="text" name="option1" /></td></tr>	
					<tr><td>Option2:</td><td><input type="text" name="option2" /></td></tr>
					<tr><td>Option3:</td><td><input type="text" name="option3" /></td></tr>
					<tr><td>Option4:</td><td><input type="text" name="option4" /></td></tr>
					<tr><td>Answer:</td><td><input type="text" name="answer" /></td></tr>	
					<tr><td>Category:</td><td> 
												<select name="category" >
									                <option value="dictionary" selected>Dictionary</option>
									                <option value="english">English</option>
									                <option value="hindi">Hindi</option>
									                <option value="math">Math</option>
									                <option value="science">Science</option>
							             	    </select>
							            </td></tr>		
					<tr><td><input type="hidden" name="takeAction" value="AdminInsertQuestion" /></td></tr>		            
							            	
                    <tr><td></td><td><input type="submit" value="Next"></td></tr>
                    </table>
                     </form>
                     
                     <%
				    if(request.getAttribute("successMsg")!=null)
				    {
				   	  %>
					<p align='center'><%= request.getAttribute("successMsg")%></p>
					 <%
				    }
				    
				     %>

</body>
</html>