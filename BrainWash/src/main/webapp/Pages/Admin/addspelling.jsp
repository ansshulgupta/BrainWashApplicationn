<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<title>Add Spelling</title>
<p>Welcome to <%=session.getAttribute("adminname") %></p>    
     <p align ='right'><a href="${pageContext.request.contextPath}/Pages/Admin/admin_menu.jsp">Menu</a></p>
    <p align ='right'><a href="${pageContext.request.contextPath}/LoggingoutProcess">Logout</a></p>
</head>

<body>

	<p align='center'>Add your spelling</p>

	<form action="${pageContext.request.contextPath}/AdminInsertSpellingServlet" method="post" align='center'>

		<label>Spelling name:</label> <input type="text" name="spellingName" id="#" required> 
		
		<label>pronounce:</label> <input type="text" name="spellingPronounce" id="#" required>
		
		<label>meaning :</label> <input type="text" name="spellingMeaning" id="#" required> 
		
		 <input type="hidden" name="takeAction" value="AdminInsertSpelling" /> <br> <br>
			
			<input type="submit" value="Add">
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