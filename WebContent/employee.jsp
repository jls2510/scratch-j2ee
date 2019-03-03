<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<jsp:useBean id='employee' scope='session' class='com.ping23.model.EmployeeBean' />
<jsp:setProperty name='employee' property='firstName' value='Elvis' />
<jsp:setProperty name='employee' property='lastName' value='Presley'/>
<jsp:setProperty name='employee' property='startYear' value='1935'/>
<jsp:setProperty name='employee' property='payRate' value='19.35'/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Bean Demo</title>
</head>
<body>

	Employee Data
	<br />
	<table border='1'>
		<tr>
			<td>First Name</td>
			<td><jsp:getProperty name='employee' property='firstName' /></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><jsp:getProperty name='employee' property='lastName' /></td>
		</tr>
		<tr>
			<td>Start Year</td>
			<td><jsp:getProperty name='employee' property='startYear' /></td>
		</tr>
		<tr>
			<td>Pay Rate</td>
			<td><jsp:getProperty name='employee' property='payRate' /></td>
		</tr>


	</table>

</body>
</html>