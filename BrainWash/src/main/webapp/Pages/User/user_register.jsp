<html>

<head>
    <p>welcome to App</p>
</head>
<body align='center'>
    
    <form action="UserRegistrationProcessServlet" method="post">

        <p>Enter Your Email</p><input type="email" name="email" id="email" required>
        <p>Enter your name</p><input type="text" name ="name" required />
        <p>Enter your Password</p><input type="password" name ="password" required/>
        <!-- <p>Enter your DOB</p><input type="date" name="date" id="date" required> -->
        <input type="hidden" name ="takeAction" value ="user_registration"/>

            <P> <input type="submit" value="SignUp"> </P>
        

    </form>
    
    <p>Already Signed up <a href="${pageContext.request.contextPath}/Pages/User/userlogin.jsp">Login</a></p>
    
    
</body>
</html>