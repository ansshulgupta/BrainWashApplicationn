<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html align='center'>

<head>
    <meta charset="UTF-8">
<title>Adminlogin</title>
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
    
<!-- Login form --> 
    
    <form action="${pageContext.request.contextPath}/AdminRegistrationProcessServlet" method="post">

        <p>Admin Id<input type="text" name ="adminid" required />Admin Password<input type="password" name ="password" required/>
         <input type="hidden" name ="takeAction" value ="adminlogin" required/>
        <input type="submit" value="Admin Login"> </P>

    </form>
    
<!-- Registration form -->

<form action="${pageContext.request.contextPath}/AdminRegistrationProcessServlet" method="post">

        <p>Admin Id   : <input type="text" name ="adminid" required /></p>
        <p>Password  : <input type="password" name ="password" required/></p>
        <p>Name      : <input type="text" name ="adminname" required/></P>
        <input type="hidden" name ="takeAction" value ="admin_registration" required/>
         <input type="submit" value="Admin Register"c/>

    </form>




    
</body>
</html>