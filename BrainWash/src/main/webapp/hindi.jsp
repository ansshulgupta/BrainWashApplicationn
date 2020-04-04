<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
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
    // Show alert Plus redirect any other page
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
</head>
<body>
<div id='timer' />
<div id="idw" />

<script type="text/javascript">window.onload = CreateTimer("timer", 120);</script>

</body>
</html>