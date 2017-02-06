<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SOEN487 - Assignment 1 - Exercise 1</title>
</head>
<body>

<%@page import = "com.assignment1.model.LoginBean"%>

<h1>Welcome! You have successfully loggin in!</h1>

<% 
	LoginBean bean = (LoginBean) request.getAttribute("bean");
	out.print("Welcome, " + bean.getName() + "!");
%>

<form action="RSSControllerServlet" method="post">
	<table>
		<tr>
			<td>URL: </td>
			<td><input type="text" name="url"><br/></td>
		</tr>
	</table>
	<input type="submit" value="Submit">
</form>

</body>
</html>