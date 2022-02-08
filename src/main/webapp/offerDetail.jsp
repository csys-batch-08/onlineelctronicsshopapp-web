<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.onlineelectronicshop.model.Cart"%>
<%@page import="com.onlineelectronicshop.daoImpl.CartDaoImpl"%>
<%@page import="com.onlineelectronicshop.daoImpl.ComponentDaoImpl"%>
 <%@ page import="com.onlineelectronicshop.model.Components" %>
 <%@ page import="java.util.List" %> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>view Cart</title>

<style>

body{
    
    background-image: url("assests/images/electronic new.jpg");
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
}

</style>

<c:forEach items="${Offers}" var="offer">
</head>
<body>




<form action="OrderServlet" method="post"><br>
<input type="hidden" name="componentId" value="${offer.componentId}">
<br><br>
<span>Component Name:${offer.componentName}</span><br>

<br><br>
<label>Enter quantity</label>
<input type="number" name="quantity" min="1" required>
<br>

<input type="number" name="price" value="${offer.price}">
<br><br>
<label>Enter address </label>
<input type="text" name="address" required>
<br>
<button type="submit">Buy</button>
</form>


</c:forEach>

</body>
</html>