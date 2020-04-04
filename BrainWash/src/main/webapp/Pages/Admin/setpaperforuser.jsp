<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<title>Set Paper</title>
<p>Welcome to <%=session.getAttribute("adminname") %></p>    
     <p align ='right'><a href="${pageContext.request.contextPath}/Pages/Admin/admin_menu.jsp">Menu</a></p>
    <p align ='right'><a href="${pageContext.request.contextPath}/LoggingoutProcess">Logout</a></p>
</head>
<body>

</body>
</html>