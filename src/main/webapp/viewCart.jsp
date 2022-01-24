<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.onlineelectronicshop.model.Cart"%>
<%@page import="com.onlineelectronicshop.daoImpl.CartDaoImpl"%>
<%@page import="com.onlineelectronicshop.daoImpl.ComponentDaoImpl"%>
 <%@ page import="com.onlineelectronicshop.model.Components" %>
 <%@ page import="java.util.List" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view Cart</title>

<style>

body{
    
    background-image: url("electronic new.jpg");
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
}

</style>
<h3 style=color:white>Cart</h3>
<%
int userId=(int) session.getAttribute("userId");
CartDaoImpl cartDao=new CartDaoImpl();
int compid=(int) session.getAttribute("compID");
List<Components> componentsList=cartDao.fetchCart(userId);
for(Components component:componentsList){
%>
</head>
<body>

<table>


<tbody>
<tr>
<td style="visibility:hidden;"><%=component.getComponentId() %></td>
<td style="visibility:hidden;"><%=component.getComponentName() %>
<td style="visibility:hidden;"><%=component.getCategoryName() %>
<td style="visibility:hidden;"><%=component.getPrice() %>
</tr>
<form action="OrderServlet" method="post"><br>
<input type="hidden" name="componentId" value="<%=compid %>">
<br><br>
<span>Component Name: <%=component.getComponentName()%> </span><br>

<br><br>
<lable>Enter quantity</lable>
<input type="number" name="quantity" min="1" required>
<br>

<input type="number" name="price" value="<%=component.getPrice() %>">
<br><br>
<lable>Enter address </lable>
<input type="text" name="address" required>
<br>
<button type="submit">Buy</button>
</form>
</table>

<%} %>

</body>
</html>