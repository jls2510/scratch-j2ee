<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="main.gamestuff.GameNumber"%>

<%
    // set min and max
    GameNumber minimum = new GameNumber(0);
    GameNumber maximum = new GameNumber(1000);
    
    // how many guesses have been made
    GameNumber guessNumber = new GameNumber(1);
    
    // set the target value
    GameNumber target = new GameNumber();
    target.setRandom(minimum.getValue(), maximum.getValue());
    
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guessing Game</title>
</head>
<body>

<h1>Welcome to the Guessing Game</h1>

<p>
Please guess a number between <%= minimum.getValue() %> and <%= maximum.getValue() %>.
</p>

<form name='gameForm' id='gameForm' action='doGuess' method='get'>
<p>
Guess # <%= guessNumber.getValue() %>:
<input type='text' name='guess' id='guess'/>
</p>

<input type='submit' name='submit' id='submit' value='Go!' />

<input type='hidden' name='minimum' value=<%= minimum.getValue() %> />
<input type='hidden' name='maximum' value=<%= maximum.getValue() %> />
<input type='hidden' name='target' value=<%= target.getValue() %> />
<input type='hidden' name='guessNumber' value=<%= guessNumber.getValue() %> />

</form>

</body>
</html>