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
<title>updateProduct</title>
<style>
table,td,tr{
border:1px solid black;
border-collapse:collapse;
}

body{
    
    background-image: url("all home page.jpg");
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
}
</style>
</head>
<body>
<form action="">
<%int comId1=(int)session.getAttribute("componentId");%><br>
<lable>ComponentId:</lable>
<input type="text" name="componentId" value="<%=comId1%>"><br>
<label>Enter Price</label><br>
<input type="text" name="price" id="price">
</form>
</body>
</html>