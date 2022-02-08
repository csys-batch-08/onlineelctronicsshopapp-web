<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.onlineelectronicshop.daoImpl.OrderDaoImpl"%>
<%@ page import="com.onlineelectronicshop.daoImpl.*"%>
<%@ page import="com.onlineelectronicshop.model.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.time.LocalDate"%>
<%@page import="java.sql.ResultSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Cancel order</title>
<style>
body {
	background-image: url("assests/images/electronic new.jpg");
	background-repeat: no repeat;
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
	text-decoration: none;
}

table, td, tr {
	border: 1px solid black;
	border-collapse: collapse;
}

.btn {
	background-color: #00b8e6;
	border-radius: 5px;
	text-decoration: none;
	display: -moz-inline-box;
	padding: 5px 5px;
	text-color: #fff;
}

.btn:hover {
	background: #40bf40;
	color: white;
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

#order tr:nth-child(odd) {
	background-color: #f2f2f2;
}

#order tr:hover {
	background-color: #a3c2c2;
}

#order th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #0080ff;
	color: black;
}
</style>
</head>
<body>
<h1>Cancel order</h1>
	<script>
		function myFunction() {
			alert("Are you sure!do you want to cancel!");
		}
	</script>
	<nav>
		<div class="menu-bar">
			<ul>
				<li><a href="viewHomePage.jsp">Home</a></li>
				<li><a href="MyProfileServlet">My profile</a></li>
				<li><a href="rechargeWallet.jsp">Wallet</a>
				<li>
				<li><a href="ShowOrderServlet">MyOrders</a></li>
				<li><a href="contactUs.jsp">Contact Us</a></li>
			</ul>
		</div>
		<br>
	</nav>
	<table id="order">
		<tr>
			<th>orderId</th>
			<th>UserName</th>
			<th>ComponentName</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Order Date</th>
			<th>Action</th>
		</tr>
		<tr>
			<c:forEach items="${listOfOrder}" var="orderList">
				<c:set var="User" scope="session" value="${User}" />
				<c:set var="componentName" scope="session" value="${componentName}" />
				<tr>
					<td>${orderList.orderid}</td>
					<td>${User.userName}</td>
					<td>${orderList.componentName}</td>
					<td>${orderList.quantity}</td>
					<td>${orderList.totalPrice}Rs</td>
					
					<td><fmt:parseDate value="${orderList.orderDate}"
						pattern="yyyy-MM-dd" var="orderDatecancel" type="date" /> <fmt:formatDate
						pattern="dd-MM-yyyy" value="${orderDatecancel}" /></td>

					<td><a class="btn" onclick="myFunction()"
						href="CancelOrderServlet?orderId=${orderList.orderid}&refundprice=${orderList.totalPrice}">Cancel</a></td>
				</tr>
			</c:forEach>

		</tr>
	</table>

	<c:if test="${not empty sessionScope.cancel}">
		<h1>${sessionScope.cancel}</h1>

	</c:if>

</body>
</html>