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

</style>
<body>
<nav>
		<div class="menu-bar">
			<ul>
				<li><a href="viewHomePage.jsp">Home</a></li>
				<li><a href="MyProfileServlet">My profile</a></li>
                <li><a href="rechargeWallet.jsp">Wallet</a><li>
                <li><a href="ShowOrderServlet">MyOrders</a></li>
                <li><a href="CancelOrderRefundServlet">CancelOrder</a></li>  
                <li><a href="contactUs.jsp">Contact Us</a></li>             
    </ul>
    </div>
    <br>
    </nav>	
<h3 style=color:white>Cart</h3>
<c:forEach items="${viewCart}" var="cart">
</head>
<form action="OrderServlet" method="post"><br>
<input type="hidden" name="componentId" value="${cart.componentId}">
<br><br>
<span>Component Name:${cart.componentName}</span><br>

<br><br>
<label>Enter quantity</label>
<input type="number" name="quantity" min="1" required><br>
<br>
<label>Component Price:</label>
<input type="number" name="price" value="${cart.price}">
<br><br>
<label>Enter address </label><br>

<textarea id="description" name="address" rows="4" cols="50"></textarea><br>
<br>
<button type="submit">Buy</button>

</form>


</c:forEach>

</body>
</html>