<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.BrainWash.model.*"%>

<html>

<head>
<%@ include file ="/Pages/sharedpage/header.jsp" %>
    <p>Welcome to <%=session.getAttribute("username") %></p>
     <p align ='right'><a href="${pageContext.request.contextPath}/Pages/User/menu.jsp" >Menu</a>
    <a href="${pageContext.request.contextPath}/LoggingoutProcess">Logout</a></p>

<p align='right'>Time 60 sec</p>
</head>
<body>

	<%
    List<SpellingBook> listOfSpellingsBookObject = (List<SpellingBook>)request.getAttribute("getSpellingsForExam");
    
	listOfSpellingsBookObject.size();
    
	for (SpellingBook getSpellingBookForExam : listOfSpellingsBookObject)
	{
		
		getSpellingBookForExam.getId();
		getSpellingBookForExam.getSpellingName();
		getSpellingBookForExam.getSpellingPronounce();
		getSpellingBookForExam.getSpellingMeaning();
		getSpellingBookForExam.getCreatedBy();
		getSpellingBookForExam.getCreatedAt();
		getSpellingBookForExam.getSpellingStatus();
		

%>

	<form action="#" method="post">
		<p>Choose the correct</p>

		<ol>
			<%= getSpellingBookForExam.getSpellingName()%> :
			<input type="radio" name="elepant" id="option" value="elephnt"	required/><%= getSpellingBookForExam.getSpellingMeaning()%> (<%= getSpellingBookForExam.getSpellingPronounce()%>)
			
			
			<input type = "hidden" name = "takeAction" value = "<%=getSpellingBookForExam.getId() %>" />
		</ol>

		<input type="submit" value="Get Score">
	</form>
<%
}
	
    %>





</body>
</html>