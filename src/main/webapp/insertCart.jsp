<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@  page import="com.onlineelectronicshop.daoImpl.*"%>
  <%@ page import="com.onlineelectronicshop.model.*"%>
  
  <%@ page import="com.onlineelectronicshop.model.Order" %>
  <%@ page import="java.util.List" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
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

<c:set var="component" scope="session" value="${componentName}"/> 
 <c:set var="componentId" scope="session" value="${componentId}"/> 
 <c:set var="price" scope="session" value="${price}"/> 
<center>
<h1>Insert cart</h1>
</center>
<form action="insertCartServlet" method="post">
<center>
<input type="hidden" value="${componentId}" name="compantId"><br><br>
<label>ComponentName</label>
<input type="text" value="${component}" name="CompantName"><br><br>
<lable>Price</lable>
<input type="number" value="${price}" name="price"><br>
<br>
<button type="submit">Submit</button>
<span><a href="viewHomePage.jsp">Home</a></span>
</center>
</form>
</body>
</html>