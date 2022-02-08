<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  page import="com.onlineelectronicshop.daoImpl.ComponentDaoImpl"%>
<%@ page import="com.onlineelectronicshop.model.Components"%>
<%@ page import="com.onlineelectronicshop.daoImpl.UserDaoImpl"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>view components</title>

<style>
table, td, tr {
	border: 1px solid black;
	border-collapse: collapse;
}

body {
	background-image: url("assests/images/electronic new.jpg");
	background-repeat: no repeat;
	background-size: cover;
	font-family: Cambria;
}

#viewComponent {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#viewComponent td, viewComponent th {
	border: 1px solid #ddd;
	padding: 8px;
}

#viewComponent tr:hover {
	background-color: #a3c2c2;
}

#viewComponent th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #0080ff;
	color: black;
}
</style>
</head>
<body>
	<h1>Component list</h1>
	<form>
		<table id="viewComponent">
			<tr>
				<th>componentImage</th>
				<th>ComponentId</th>
				<th>ComponentName</th>
				<th>CategoryName</th>
				<th>Description</th>
				<th>TotalPrice</th>

			</tr>
			<c:forEach items="${componentList}" var="componentList">
				<tr>
					<td><img alt="#componentimage"
						src="assests/images/${componentList.image}" width="200"
						height="200"></td>
					<td>${componentList.componentId}</td>
					<td>${componentList.componentName}</td>
					<td>${componentList.categoryName}</td>
					<td>${componentList.description}</td>
					<td>${componentList.price}</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>