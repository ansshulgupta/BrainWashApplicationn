<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html align='center'>
<head>

<%@ include file ="/Pages/sharedpage/header.jsp" %>
    <p>Welcome to <%=session.getAttribute("username") %></p>    
     <p align ='right'><a href="${pageContext.request.contextPath}/Pages/User/menu.jsp">Menu</a></p>
    <p align ='right'><a href="${pageContext.request.contextPath}/LoggingoutProcess">Logout</a></p>
<p align='right'><a href="${pageContext.request.contextPath}/Pages/User/take_exam.jsp">Retake Exam</a></p>

<title>Score</title>
</head>
<body>

<%

int score =(Integer)session.getAttribute("getScore");

	out.print("Your score : "+score);

%>


</body>
</html>