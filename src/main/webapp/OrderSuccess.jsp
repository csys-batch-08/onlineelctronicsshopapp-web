<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OrderSuccess</title>
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
#ordersuccess{
align-content: center;
margin-left: 500px;
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
                <li><a href="cancelOrder.jsp">CancelOrder</a></li>  
                <li><a href="contactUs.jsp">Contact Us</a></li>  
                <li><a href="InvoiceServlet">View Bill</a></li>           
    </ul>
    </div>
    <br>
    </nav>	
<form action="ShowOrderServlet">
<div id="ordersuccess">

<h1>Order success! Thank You!!</h1>
<h2><i>Your Payment Is Debited from Your Wallet</i></h2>



<c:set var="Price" scope="session" value="${totalprice}"/> 
<c:set var="wallet" scope="session" value="${wallbal}"/> 

<h2><i>Your Total Amount is : ${Price}</i></h2>


<h2><i> Your Revised Wallet Amount : ${wallet}</i></h2>

<button type="submit">click to check order</button><br>
</div>
</form>
</body>
</html>