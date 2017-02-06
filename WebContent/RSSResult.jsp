<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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

<title>RSS Result</title>
</head>
<body>

<table border="1">
	<tr>
    	<td>Title:</td>
        <td>Description:</td>
        <td>Link:</td>
        <td>Author:</td>
        <td>Guid:</td>
    </tr>
    <c:forEach var="feedElement" items="${feed}" >
    <tr>
    	<td>${feedElement.title}</td>
    	<td>${feedElement.description}</td>
    	<td>${feedElement.link}</td>
    	<td>${feedElement.author}</td>
    	<td>${feedElement.guid}</td>
    </tr>          
    </c:forEach>
</table> 

</body>
</html>