<%@page import="com.onlineelectronicshop.model.Components"%>
<%@page import="java.util.List"%>
<%@page import="com.onlineelectronicshop.daoImpl.ComponentDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search components</title>


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

.card {
  max-width: 50rem;
  position: relative;
  
  display: flex;
  top: 50%;
  left: 80%;
   background-color:#3333ff;
  transform: translate(-50%, -50%);
  box-shadow: -2rem 2rem 3.2rem rgba(0, 0, 0, 0.2);
}

.product-right {
  background: #fff;
  height: auto;
  width: 100%;
 
  border-top-right-radius: 0.5rem;
  border-bottom-right-radius: 0.5rem;
  display: flex;
  justify-content: center;
  align-items: center;
}
.btn{
background-color:#00061a;
	text-decoration: none;
	display: -moz-inline-box;
	padding: 5px 5px;
     text-color:#fff;

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
                <li><a href="ShowOrderServlet">CancelOrder</a></li>  
                <li><a href="contactUs.jsp">Contact Us</a></li>             
    </ul>
    </div>
    <br>
    </nav>	

<form>
<h1>Components</h1>

<table>

<c:forEach items="${list}" var="search" >
<tr>
<td>

<div class="product-right">

<img alter="#alter" src="assests/images/${search.image}" width="200"height="200"><br>
</div>

<span style="visibility:hidden;">${search.componentId}</span><br><br>
				Component Name:${search.componentName}<br><br>
				Category Name:${ search.categoryName}<br><br>
				Description:${search.description}<br><br>
				Price:${search.price}<br><br>
				<a class="btn" href="CartServlet?componentId=${search.componentId}&compantName=${search.componentName}&price=${search.price}">AddToCart</a>&nbsp;
				<a class="btn" href="ProceedBuyServlet?componentId=${search.componentId}&compantName=${search.componentName}&price=${search.price}">Buy</a>&nbsp;
</td>
</tr>
</c:forEach>
</table>
</form>
</body>

</html>
