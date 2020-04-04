<%

//session expired
String userName=(String)session.getAttribute("username");
if(userName==null)
{	
	request.setAttribute("errorMessage", "Session has been closed please continue to login");
	request.getRequestDispatcher("/Pages/User/userlogin.jsp").forward(request, response);
	
}


%>
<meta charset="UTF-8">
<title>${pageContext.request.servletPath}</title>
<p>Welcome to BrainWash Application</p>