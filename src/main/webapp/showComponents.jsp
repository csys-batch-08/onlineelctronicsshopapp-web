<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  page import="com.onlineelectronicshop.daoImpl.ComponentDaoImpl"%>
<%@ page import="com.onlineelectronicshop.model.Components"%>
<%@ page import="com.onlineelectronicshop.daoImpl.UserDaoImpl"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>list of components</title>

<style>
{
padding:0;
margin:0;    

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
  width: 500px;
  margin: auto;
  border: 1px solid #ccc;
  overflow: hidden;
  font-family: Roboto;
}



a.btn {
  text-decoration: none;
  font-size: 18px;
  background-color: blue;
  color: white;
  display: block;
  padding: 3px 5px;
  margin-bottom: 10px;
  width: 30%;
  border-radius: 0.5em;
}

search{
margin-left:300px;
}


body {
	background-image: url("assests/images/website-banner-1.jpg");
	background-repeat: no repeat;
	background-size: cover;
	font-family: Cambria;
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
				

<br>
	<form action="SearchComponentServlet">
	<label for="search"></label>
	<input style="float:right;" type="text" name="search" id="search" placeholder="Search component name and category name here!">
	<input style="float:right;" type="submit" value="search">
	</form>
		<br>
	
		 <table>
		<caption></caption>
		<tbody>
		
		<th id="tableHead"></th>
		<tr>
		<c:set var="count" value="1" />
<c:forEach items="${showComponent}" var="component">
            <td>
			<table id="components">
			<caption></caption>
			<tbody>
			<tr>
			<th id="tableHead"></th>
			    
				<td><img alter="#alter" src="assests/images/${component.image}"
					width="200" height="200"><br>
					
				<span style="visibility:hidden;">${component.componentId}</span><br><br>
				
				Component Name:${component.componentName}<br><br>
				Category Name:${ component.categoryName}<br><br>
				Description:${component.description}<br><br>
				Price:${component.price}Rs<br><br>
				<a class="btn" href="CartServlet?componentId=${component.componentId}&compantName=${component.componentName}&price=${component.price}">AddToCart</a>
				<a class="btn" href="ProceedBuyServlet?componentId=${component.componentId}&compantName=${component.componentName}&price=${component.price}">Buy</a>
				
                
				</tr>
				</tbody>
				</table>
				
				</td>
				<c:choose>
						<c:when test="${count==2}">
							<c:set var="count" value="1" />
							</tr>
			                <tr>
		  
						</c:when>
				<c:otherwise>
					<c:set var="count" value="${count+1}" />
				</c:otherwise>
				</c:choose>
                </td>	
				</c:forEach>
				<br>
					</table>
</body>
</html>
