<%@page import="com.onlineelectronicshop.model.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@  page import="com.onlineelectronicshop.daoImpl.ComponentDaoImpl"%>
  <%@ page import="com.onlineelectronicshop.model.Components" %>
  <%@ page import="com.onlineelectronicshop.daoImpl.UserDaoImpl" %>
  <%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Component</title>

<style>

body{
    
    background-image: url("electronic new.jpg");
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
}

</style>




</head>
<body>
<h1>Buy</h1>
<%double price=(double)(session.getAttribute("price")); %>
<%int userId=(int)session.getAttribute("userId"); %>
<%ComponentDaoImpl comDao=new ComponentDaoImpl();
Order order=new Order();
String componentName=request.getParameter("componentName");
session.setAttribute("ComponentName", componentName);
int comId=comDao.findComponentId(componentName);
%>

<form action="BuyServlet" method="post"><br>

<label>Address</label><br>
<input id="address" name="address" ><br>
<label>quantity</label><br>
<input type="number" name="quantity"><br>
<button type="submit">order</button>
</form>
</body>
</html>