<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.onlineelectronicshop.daoImpl.OrderDaoImpl" %>
     <%@ page import="com.onlineelectronicshop.daoImpl.*" %>
     <%@ page import="com.onlineelectronicshop.model.*" %>
  <%@ page import="java.util.List" %>
  <%@ page import="java.time.LocalDate" %>
<%@page import="java.sql.ResultSet" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancel order</title>
<style>
body{
    
    background-image: url("electronic new.jpg");
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
}

.menu-bar {
	background: white;
	
}

.menu-bar ul {
	display: inline-flex;
	list-style: none;
	color: #fff;
}

.menu-bar ul li a {
	padding: 10px 10px;
	font-size: 17px;
	text-decoration:none;
}

table,td,tr{
border:1px solid black;
border-collapse:collapse;}
</style>
</head>
<body>
<nav>
		<div class="menu-bar">
			<ul>
				<li><a href="viewHomePage.jsp">Home</a></li>
				<li><a href="MyProfile.jsp">My profile</a></li>
                <li><a href="rechargeWallet.jsp">Wallet</a><li>
                <li><a href="MyOrders.jsp">MyOrders</a></li>
                <li><a href="contactUs.jsp">Contact Us</a></li>             
    </ul>
    </div>
    <br>
    </nav>	


<h1>My Orders</h1>
<table>
<tr>
<td>orderid</td>
<td>User Name</td>
<td>Component Name</td>
<td>Quantity</td>
<td>Price</td>
<td>Order Date</td>
</tr>

<!-- 
or(int i=0;i<orderList.size();i++){
	Order order=orderList.get(i);
LocalDate date=orderList.get(i).getOrderDate();
System.out.println(date);

-->


<tr>
<c:forEach items="${listOfOrder}" var="orderList">
			<c:set var="User" scope="session" value="${User}" />
			<c:set var="componentName" scope="session" value="${componentName}" />
<jsp:useBean id="component" class="com.onlineelectronicshop.daoImpl.ComponentDaoImpl"/>

			<tr>
			    <td>${orderList.orderid}</td>
				<td>${User.userName}</td>
				<td>${component.findComponent(orderList.componentId)}</td>
				<td>${orderList.quantity}</td>
				<td>${orderList.totalPrice}</td>
				<td>${orderList.orderDate}</td>
				<td><a href="CancelOrderServlet?orderId=${orderList.orderid}&refundprice=${orderList.totalPrice}">Cancel</a></td>

			</tr>
		</c:forEach>

</tr>


</table>

<c:if test="${not empty sessionScope.cancel}">
<h1>${sessionScope.cancel}</h1>

</c:if>  

</body>
</html>