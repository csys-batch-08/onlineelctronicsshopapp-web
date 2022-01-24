<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@  page import="com.onlineelectronicshop.daoImpl.*"%>
  <%@ page import="com.onlineelectronicshop.model.*"%>
  
  <%@ page import="com.onlineelectronicshop.model.Order" %>
  <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cart</title>
<style>
table,td,tr{
border:1px solid white;
border-collapse:collapse;
}


body{
    
    background-image: url("electronic new.jpg");
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
}
<!--<%//CartDaoImpl cartDao=new CartDaoImpl();

//Cart cart=new Cart();
//cartDao.insertCart(cart);
%>-->
<%//int productId=Integer.parseInt(request.getParameter("produId"));%>
<%//int cartId1=Integer.parseInt(request.getParameter(""));%>
<%String compantName=request.getParameter("compantName");
Double price=Double.parseDouble(request.getParameter("price"));
int compantId=Integer.parseInt(request.getParameter("componentId"));
session.setAttribute("price", price);
%>
</style>
</head>
<body>
<center>
<h1>Insert cart</h1>
</center>
<form action="insertCartServlet" method="post">
<center>
<input type="hidden" value="<%=compantId%>" name="compantId"><br><br>
<label>ComponentName</label>
<input type="text" value="<%=compantName %>" name="CompantName"><br><br>
<lable>Price</lable>
<input type="number" value="<%=price%>" name="price"><br>
<br>
<button type="submit">submit</button>
<span><a href="Home.jsp">Home</a></span>
</center>
</form>
</body>
</html>