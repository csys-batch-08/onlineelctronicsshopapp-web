<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@  page import="com.onlineelectronicshop.daoImpl.ComponentDaoImpl"%>
  <%@ page import="com.onlineelectronicshop.model.Components" %>
  <%@ page import="com.onlineelectronicshop.daoImpl.UserDaoImpl" %>
  <%@ page import="java.util.List" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>delete component</title>
<style>
table,td,tr{
border:1px solid white;
border-collapse:collapse;
}

body{
    
    background-image: url("assests/images/electronic new.jpg");
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
}

#delete {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;

}

#delete td, delete th {
  border: 1px solid #ddd;
  padding: 8px;
}

#delete tr:nth-child{background-color: #f2f2f2;}

#delete tr:hover {background-color: #ddd;}

#delete th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #0080ff;
  color: white;
}

.btn {
	background-color: #00b8e6;
	border-radius: 5px;
	text-decoration: none;
	display: -moz-inline-box;
	padding: 5px 5px;
	text-color: #fff;
}

.btn:hover {
	background: #40bf40;
	color: white;
}
</style>
</head>
<body>
<h1>Delete component</h1>
<table id="delete">
<tr>
<th>ComponentId</th>
<th>ComponentName</th>
<th>CategoryName</th>
<th>Description</th>
<th>TotalPrice</th>
<th>ComponentStatus</th>
<th>Action</th>
</tr>


<c:forEach items="${components}" var="componentDelete">
<tr>
<td>${componentDelete.componentId}</td>
<td>${componentDelete.componentName}</td>
<td>${componentDelete.categoryName}</td>
<td>${componentDelete.description}</td>
<td>${componentDelete.price}</td>
<td>${componentDelete.available}</td>
<td><a class="btn" href="DeleteComponentAdminServlet?componentId=${componentDelete.componentId}">delete</a></td>
</c:forEach>
</tr>
</table>

</body>
</html>