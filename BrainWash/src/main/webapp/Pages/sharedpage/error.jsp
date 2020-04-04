<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html  align='center' >

<head>
    
    
    <p>Welcome to <%=session.getAttribute("username") %></p>
    
</head>
<body>
   
    
    <%
    
    String errorMessage=(String)request.getAttribute("errorMessage");
    if(errorMessage!=null)
    {
    out.print("<p>"+errorMessage+"</p>");
    }
     %>
    
    
    <p align ='right'>
     <a href="${pageContext.request.contextPath}/Pages/User/menu.jsp">Menu</a>
     <a href="LoggingoutProcess">Logout</a>
     </p>
    

    
</body>
</html>