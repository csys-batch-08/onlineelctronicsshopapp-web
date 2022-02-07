<%@page import="java.sql.ResultSet"%>
<%@page import="com.onlineelectronicshop.daoImpl.OrderDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order list</title>
</head>
<style>

body{
    
    background-image: url("assests/images/electronic new.jpg");
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
}
#order {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;

}

#order td, order th {
  border: 1px solid #ddd;
  padding: 8px;
}

#order tr:nth-child(even){background-color: #f2f2f2;}

#order tr:hover {background-color: #ddd;}

#order th {
  padding-top: 15px;
  padding-bottom: 15px;
  text-align: left;
  background-color: #0080ff;
  color: white;
}

.menu-bar{
    background:#5ab9ea;
    text-align: center;
}
.menu-bar ul{
    display:inline-flex;
    list-style: none;
    color: #fff;
}
.menu-bar ul li
{
width: 150px;
margin: 8px;
padding: 1px;
}
.menu-bar ul li a{
padding: 8px 8px;
font-size: 17px;
 text-decoration:none;
}




</style>





<body>
<nav>
<div class="menu-bar">
        <ul>
            <li><a href="Home.jsp">Home</a></li>
            <li><a href="calculateAmount.jsp">CalculateAmount</a></li>
            <li><a href="admin.jsp">Admin</a></li>
            <li><a href="contactUs.jsp">Contact Us</a>               
    </ul>
    </div>
    <br>
    </nav>


<form>
<table id="order">

<tr>
<th>Order id</th>
<th>componentId</th>
<th>User id</th>
<th>Quantity</th>
<th>Total price</th>
<th>Address</th>
<th>Order Date</th>
<th>Order status</th>
<th>Update status</th>
</tr>
<c:forEach items="${listOrder}" var="orders">
<tr>
<td>${orders.orderid}</td>
<td>${orders.componentId}</td>
<td>${orders.userId}</td>
<td>${orders.quantity}</td>
<td>${orders.totalPrice}</td>
<td>${orders.address}</td>
<td>${orders.orderDate}</td>
<td>${orders.orderStatus}</td>
<td><a href="ChangeOrderStatusServelt?orderid=${orders.orderid}">UpdateStatus</a></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>