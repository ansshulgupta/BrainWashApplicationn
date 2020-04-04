<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html align='center'>
<head>

<meta charset="UTF-8">
<title>${pageContext.request.servletPath}</title>
<p>Welcome to BrainWash Application</p>

</head>
<body>

<p><a href="${pageContext.request.contextPath}/Pages/Admin/adminlogin.jsp">Admin Login</a></p>
<p><a href="${pageContext.request.contextPath}/Pages/User/userlogin.jsp">User Login</a></p>
<p><a href="${pageContext.request.contextPath}/Pages/User/user_register.jsp">User Registration</a></p>


</body>
</html>