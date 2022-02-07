<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@  page import="com.onlineelectronicshop.daoImpl.ComponentDaoImpl"%>
  <%@ page import="com.onlineelectronicshop.model.Components" %>
  <%@ page import="com.onlineelectronicshop.daoImpl.UserDaoImpl" %>
  <%@ page import="java.util.List" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list of components</title>
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
</style>
</head>
<body>

<table>
<tr>
<td>ComponentName</td>
<td>CategoryName</td>
<td>Description</td>
<td>TotalPrice</td>
<td>Action</td>
</tr>
<c:forEach items="${showComponent}" var="component">
<tr>

<td>${component.componentName}</td>

<td>${component.categoryName}</td>
<td>${component.description}</td>
<td>${component.price}</td>



<td>
<form action="updateComponentServelt" method="post">
<label>Enter Price</label><br>
<input type="hidden" value="${component.componentName}" name="component" >
<input type="text" name="newPrice" id="price">
<button type="submit">submit</button>
</form>
</td>
</c:forEach>



</tr>


</table>

</body>
</html>