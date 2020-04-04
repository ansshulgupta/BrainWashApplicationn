<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html align='center'>

<head>
    <meta charset="UTF-8">
<title>userlogin</title>
<p>Welcome to BrainWash Application</p>
    
</head>
<body>

<%
String errorMessage=(String)request.getAttribute("errorMessage");

if(errorMessage!=null)
{
	out.print("<p>"+errorMessage+"</p>");
}
%>
    
    <form action="${pageContext.request.contextPath}/UserRegistrationProcessServlet" method="post">

       <p>Email</p><input type="email" name="email" id="email" required>
       <p>Password</p><input type="password" name ="password" required/>
       <input type="hidden" name ="takeAction" value ="userlogin"/>
       
        <P> <input type="submit" value="Login"> </P>

    </form>
    
    
<p><a href="${pageContext.request.contextPath}/Pages/User/user_register.jsp">User Registration</a></p>

    
    
</body>
</html>