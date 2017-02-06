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

<%@page import = "com.assignment1.model.LoginBean"%>

<h1>Welcome! You have successfully loggin in!</h1>

<% 
	LoginBean bean = (LoginBean) request.getAttribute("bean");
	out.print("Welcome, " + bean.getName() + "!");
%>

<br/>

<form action="RSSControllerServlet" method="post">
	<table>
		<tr>
			<td>URL: </td>
			<td><input type="text" name="url"><br/></td>
		</tr>
		<tr>
			<td>Sample RSS: </td>
			<td>http://www.vogella.com/article.rss</td>
	</table>
	<input type="submit" value="Submit">
</form>

</body>
</html>