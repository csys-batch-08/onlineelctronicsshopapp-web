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
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Orders</title>



<style>
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

body {
	background-image: url("assests/images/electronic new.jpg");
	background-repeat: no repeat;
	background-size: cover;
	font-family: Cambria;
}

table, td, tr {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<nav>
		<div class="menu-bar">
			<ul>
				<li><a href="viewHomePage.jsp">Home</a></li>
				<li><a href="ShowComponentServlet">Components</a></li>
				<li><a href="MyProfileServlet">My profile</a></li>
				<li><a href="rechargeWallet.jsp">Wallet</a>
				<li><a href="CancelOrderRefundServlet">CancelOrder</a></li>
				<li><a href="contactUs.jsp">Contact Us</a></li>
			</ul>
		</div>
		<br>
	</nav>
	<h1>My Orders</h1>
	<table>
		<tr>
			<td>User Name</td>
			<td>Component Name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Order Date</td>
		</tr>
		<c:forEach items="${listOfOrder}" var="orderList">
			<c:set var="user" scope="session" value="${UserName}" />
			<c:set var="componentName" scope="session" value="${componentName}" />

			<tr>
				<td>${user.userName}</td>
				<td>${orderList.componentName}</td>
				<td>${orderList.quantity}</td>
				<td>${orderList.totalPrice}</td>

				<td><fmt:parseDate value="${orderList.orderDate}"
						pattern="yyyy-MM-dd" var="orderDate" type="date" /> <fmt:formatDate
						pattern="dd-MM-yyyy" value="${orderDate}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>