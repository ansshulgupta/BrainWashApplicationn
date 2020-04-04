<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html align='center'>

<head>

		<meta charset="UTF-8">
		<title>${pageContext.request.servletPath}</title>
		<p>Welcome to BrainWash Application</p>
    <p>Welcome to <%=session.getAttribute("adminname") %></p>
    <p align ='right'><a href="${pageContext.request.contextPath}/LoggingoutProcess">Logout</a></p>
</head>

<body>
    
    
        <ol>
            <a href="${pageContext.request.contextPath}/Pages/Admin/addspelling.jsp">Add your spellings</a><br>
            <a href="${pageContext.request.contextPath}/Pages/Admin/makequestion.jsp">Make Your Question</a><br>
            <a href="${pageContext.request.contextPath}/Pages/Admin/setpaperforuser.jsp">Set Paper</a><br>
           
            </ol>
  
    
</body>


</html>