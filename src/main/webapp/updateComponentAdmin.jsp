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
<title>list of components</title>
<style>
body {
	background-image: url("assests/images/electronic new.jpg");
	background-repeat: no repeat;
	background-size: cover;
	font-family: Cambria;
}

#updateComponent {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#updateComponent td, viewComponent th {
	border: 1px solid #ddd;
	padding: 8px;
}

#updateComponent tr:hover {
	background-color: #a3c2c2;
}

#updateComponent th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #0080ff;
	color: black;
}
.button {
	background-color: #00b8e6;
	border-radius: 5px;
	text-decoration: none;
	display: -moz-inline-box;
	padding: 5px 5px;
	text-color: #fff;
}

.button:hover {
	background: #40bf40;
	color: white;
}
</style>
</head>
<body>
<h1>Update component</h1>
	<table id="updateComponent">
		<tr>
			<th>ComponentName</th>
			<th>CategoryName</th>
			<th>Description</th>
			<th>TotalPrice</th>
			<th>Action</th>
		</tr>

		<tr>
			<c:forEach items="${showComponent}" var="component">


				<jsp:useBean id="component"
					class="com.onlineelectronicshop.daoImpl.ComponentDaoImpl" />
				<c:set var="componentName" scope="session" value="${componentName}" />
				<c:set var="componentName" scope="session" value="${componentName}" />

				<td>${component.componentName}</td>
				<td>${component.categoryName}</td>
				<td>${component.description}</td>
				<td>${component.updateComponent(price, comName)}</td>
				<td><label>Enter Price</label><br> <input type="text"
					name="price" id="price" min="0">
					<button type="submit">Update</button></td>
			</c:forEach>
		</tr>


	</table>

</body>
</html>