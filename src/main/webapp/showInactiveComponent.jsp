<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  page import="com.onlineelectronicshop.daoImpl.ComponentDaoImpl"%>
<%@ page import="com.onlineelectronicshop.model.Components"%>
<%@ page import="com.onlineelectronicshop.daoImpl.UserDaoImpl"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inactive component</title>

<style>
body {
	background-image: url("assests/images/electronic new.jpg");
	background-repeat: no repeat;
	background-size: cover;
	font-family: Cambria;
}

#inactive {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#inactive td, inactive th {
	border: 1px solid #ddd;
	padding: 8px;
}

#inactive tr:hover {
	background-color: #a3c2c2;
}

#inactive th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #008ae6;
	color: black;
}
</style>
</head>
<body>
<h1>Inactive components</h1>
	<form>
		<table id="inactive">
			<tr>
				<th>componentImage</th>
				<th>ComponentId</th>
				<th>ComponentName</th>
				<th>CategoryName</th>
				<th>Description</th>
				<th>TotalPrice</th>

			</tr>
			<c:forEach items="${InactivecomponentList}" var="Inactivecomponent">
				<tr>
					<td><img alter="#alter"
						src="assests/images/${Inactivecomponent.image}" width="200"
						height="200"></td>
					<td>${Inactivecomponent.componentId}</td>
					<td>${Inactivecomponent.componentName}</td>
					<td>${Inactivecomponent.categoryName}</td>
					<td>${Inactivecomponent.description}</td>
					<td>${Inactivecomponent.price}</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>