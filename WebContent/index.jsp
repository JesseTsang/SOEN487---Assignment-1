<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>SOEN487 - Assignment 1 - Exercise 1</title>
</head>
<body>

<h1>Hello! Please enter your username and password.</h1>

<table>
	<tr>
		<td>Username: </td>
		<td>[Unrestricted]</td>
	</tr>
	<tr>
		<td>Password: </td>
		<td>admin</td>
	</tr>
</table>

<br/>


<form action="ControllerServlet" method="post">
	<table>
		<tr>
			<td>Name: </td>
			<td><input type="text" name="userName"><br/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password"><br/></td>
		</tr>
	</table>
	<input type="submit" value="Login">
</form>

</body>
</html>