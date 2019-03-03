<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.ping23.gamestuff.GameNumber"%>

<%
    String message = (String) request.getAttribute("message");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guessing Game</title>
</head>
<body>

	<h1>Welcome to the Guessing Game</h1>

	<p><%=message%></p>

	<a href="index.jsp">Play Again</a>
</body>
</html>