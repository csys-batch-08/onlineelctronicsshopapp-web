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

<%
int userId=(int) session.getAttribute("userId");
CartDaoImpl cartDao=new CartDaoImpl();

List<Components> componentsList=cartDao.fetchCart(userId);
for(Components component:componentsList){
%>
</head>
<body>
<h3 style=color:white>Cart</h3>
<table>


<tbody>

<!--
<td style="visibility:hidden;"><%=component.getComponentId() %></td>
<td style="visibility:hidden;"><%=component.getComponentName() %>
<td style="visibility:hidden;"><%=component.getCategoryName() %>
<td style="visibility:hidden;"><%=component.getPrice() %>
</tr>
-->
<%int componentId=Integer.parseInt(request.getParameter("componentId"));%>
<%String componentName=request.getParameter("compantName"); %>
<%Double price=Double.parseDouble(request.getParameter("price")); %>

<form action="BuyServlet" method="post"><br>
<input type="hidden" name="componentId" value="<%=componentId %>">
<br><br>
<span>Component Name: <%=componentName%> </span><br>

<br><br>
<lable>Enter quantity</lable>
<input type="number" name="quantity" min="1" required>
<br>

<input type="number" name="price" value="<%=price %>">
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


