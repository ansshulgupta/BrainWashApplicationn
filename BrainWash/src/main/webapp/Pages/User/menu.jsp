<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html align='center'>

<head>

<%@ include file ="/Pages/sharedpage/header.jsp" %>
    <p>Welcome to <%=session.getAttribute("username") %></p>
    <p align ='right'><a href="${pageContext.request.contextPath}/LoggingoutProcess">Logout</a></p>
</head>
<body>
    
   <ol>
    <a href="${pageContext.request.contextPath}/AdminMakeQuestionProcess?takeAction=WriteEnglishExam">Take English Exam</a></br>
    <a href="${pageContext.request.contextPath}/AdminInsertSpellingServlet?takeAction=WriteSpellingCheckerExam" >Take Spelling Checker Exam</a></br><!--${pageContext.request.contextPath}/AdminInsertSpellingServlet?takeAction=WriteSpellingCheckerExam -->
    <a href="#">Image Checker</a></br> <!-- imagechecker.jsp -->
    <a href="#">Question and Answer</a></br> <!-- questionandanswer.jsp -->
   </ol>
    
</body>
</html>