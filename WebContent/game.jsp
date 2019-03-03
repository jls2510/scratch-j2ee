<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="main.gamestuff.GameNumber"%>

<%
    // retrieve the guess
    GameNumber guess =
        new GameNumber(Integer.parseInt(request.getParameter("guess")));
    // retrieve min and max
    GameNumber minimum = new GameNumber(
        Integer.parseInt(request.getParameter("minimum")));
    GameNumber maximum = new GameNumber(
        Integer.parseInt(request.getParameter("maximum")));

    // retrieve how many guesses have been made
    GameNumber guessNumber = new GameNumber(
        Integer.parseInt(request.getParameter("guessNumber")));

    // retrieve the target value
    GameNumber target = new GameNumber(
        Integer.parseInt(request.getParameter("target")));

    String message = "";
    if (guess.getValue() == target.getValue())
    {
        message = "Congratulations! You got it right in "
            + guessNumber.getValue() + " guesses!";

    }
    else
    {
        guessNumber.increment();
        if (guess.getValue() < target.getValue())
        {
            message = "Too low - guess higher.";
        }
        else
        {
            message = "Too high - guess lower.";
        }
    }
    
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guessing Game</title>
</head>
<body>

	<h1>Welcome to the Guessing Game</h1>
	
	<p><%= message %></p>
	
	<%if (guess.getValue() == target.getValue()) { %>
	
		<a href="index.jsp">Play Again</a>
		
    <% }  else { %>
    
	<p>
		Please guess a number between
		<%=minimum.getValue()%>
		and
		<%=maximum.getValue()%>.
	</p>

	<form name='gameForm' id='gameForm' action='game.jsp' method='get'>
		<p>
			Guess #
			<%=guessNumber.getValue()%>: <input type='text' name='guess'
				id='guess' />
		</p>

		<input type='submit' name='submit' id='submit' value='Go!' /> <input
			type='hidden' name='minimum' value=<%=minimum.getValue()%> /> <input
			type='hidden' name='maximum' value=<%=maximum.getValue()%> /> <input
			type='hidden' name='target' value=<%=target.getValue()%> /> <input
			type='hidden' name='guessNumber' value=<%=guessNumber.getValue()%> />

	</form>
    
    <% } %>
	
</body>
</html>