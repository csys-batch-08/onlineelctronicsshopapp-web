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


</head>
<body>
<h3 style=color:white>Cart</h3>
<form action="BuyServlet" method="post"><br>
<c:if test="${componentId!=null }">
<input type="hidden" name="componentId" value="${componentId}">
</c:if>
<br><br>
<c:if test="${componentName!=null }">
        <p>ComponentName:${componentName}<p>
        </c:if>


<br><br>
<lable>Enter quantity</lable>
<input type="number" name="quantity" min="1" required>
<br>
<c:if test="${price!=null }">
       
<input type="number" name="price" value="${price}">
</c:if>
<br><br>
<lable>Enter address </lable>
<br>
<textarea id="description" name="address" rows="4" cols="50"></textarea><br>

<button type="submit">Buy</button>
</form>
</body>
</html>
