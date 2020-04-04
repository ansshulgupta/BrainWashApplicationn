<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.BrainWash.model.*"%>

<!DOCTYPE html>
<html align = 'center'>
<head>

	<%@ include file ="/Pages/sharedpage/header.jsp" %>
    <p>Welcome to <%=session.getAttribute("username") %></p>
     <p align ='right'><a href="${pageContext.request.contextPath}/Pages/User/menu.jsp" >Menu</a>
    <a href="${pageContext.request.contextPath}/LoggingoutProcess">Logout</a></p>
    

<script>
function disable() {
  document.getElementById("option1").disabled = true;
  document.getElementById("option2").disabled = true;
  document.getElementById("option3").disabled = true;
  document.getElementById("option4").disabled = true;
  
  document.getElementById("recorded").innerHTML="recorded";
   
}
</script>

<!-- timer script -->
<script language="javascript">

var Timer;
var TotalSeconds;

function CreateTimer(TimerID, Time) 
{
    Timer = document.getElementById(TimerID);
    TotalSeconds = Time;
    UpdateTimer()
    window.setTimeout("Tick()", 1000);
}

function Tick() 
{
    TotalSeconds -= 1;
    if(TotalSeconds ==-1)
      {
    alert("Time Up");
    //window.open("/Pages/User/timedout.html");
  
      }
   else
     {
    UpdateTimer()
    window.setTimeout("Tick()", 1000);
     }
}

function UpdateTimer() {
    Timer.innerHTML = "time lefts : "+parseInt(TotalSeconds/60)+" min : "+parseInt(TotalSeconds%60)+"sec";
}
</script>

		<p align='right' id="timer"></p>    
    <script type="text/javascript">window.onload = CreateTimer("timer", 30);</script>

</head>
<body>

<%
		int i=1;
	List<QuestionBook> getAllQuestions = (List<QuestionBook>)session.getAttribute("getAllQuestions");
    
		out.print("<p>Total Questions: "+getAllQuestions.size()+" </p>"); 
    
  for(QuestionBook getQuestion : getAllQuestions)
	{
			
%> 
			<form action="${pageContext.request.contextPath}/AdminMakeQuestionProcess"  method="post">
				<table align = 'center'>
			     	<tr><td><input type="hidden" name="questionid" value="<%=getQuestion.getQuestionid()%>" />
					<tr><td><% out.print("<p>Question :"+i+" <p>"+getQuestion.getQuestion());%></td></tr>
					<tr><td><input type="radio" name="option" id="option1"   value="<%=getQuestion.getOption1()%>" required /><%=getQuestion.getOption1()%></td></tr>	
					<tr><td><input type="radio" name="option" id="option2"   value="<%=getQuestion.getOption2()%>" required /><%=getQuestion.getOption2() %></td></tr>	
					<tr><td><input type="radio" name="option" id="option3"   value="<%=getQuestion.getOption3()%>" required /><%=getQuestion.getOption3() %></td></tr>	
					<tr><td><input type="radio" name="option" id="option4"   value="<%=getQuestion.getOption4()%>" required /><%=getQuestion.getOption4() %></td></tr>			
	                 <tr><td><input type="hidden" name="takeAction" value="CheckAnswer" />
	                
	                <tr><td><p id ="recorded"></p></td></tr>
	                <tr><td><input type="submit" value="Submit"/></td></tr>
	             </table>
	          </form>
          
          
<%
i++;
}
  %>

				<button><a href ="${pageContext.request.contextPath}/AdminMakeQuestionProcess?takeAction=getScore">GetScore</a></button>


</body>
</html>