<%@page import="com.onlineelectronicshop.model.Components"%>
<%@page import="java.util.List"%>
<%@page import="com.onlineelectronicshop.daoImpl.ComponentDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search components</title>


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
				<li><a href="MyProfile.jsp">My profile</a></li>
                <li><a href="rechargeWallet.jsp">Wallet</a><li>
                <li><a href="MyOrders.jsp">MyOrders</a></li>
                <li><a href="cancelOrder.jsp">CancelOrder</a></li>  
                <li><a href="contactUs.jsp">Contact Us</a></li>             
    </ul>
    </div>
    <br>
    </nav>	

<form>
<table>
<div>
<h1>Components</h1>
</div>
<%List<Components>user=(List<Components>)session.getAttribute("list");
for(int i=0;i<user.size();i++)
{
	Components comDao1=	user.get(i);
%>
<tr>
<td>
<div class="card">
<div class="product-right">

<img alter="#alter" src="images1/<%=comDao1.getImage()%>" width="200"height="200"><br>
</div>
<div class="product-total">
<span style="visibility:hidden;"><%=comDao1.getComponentId() %></span><br><br>
Component Name:<%=comDao1.getComponentName()%><br><br>
Category Name:<%=comDao1.getCategoryName()%><br><br>
Description:<%=comDao1.getDescription()%><br><br>
Price:<%=comDao1.getPrice()%><br><br>
<a class="btn" href="insertCart.jsp?componentId=<%=comDao1.getComponentId()%>&compantName=<%=comDao1.getComponentName()%>&price=<%=comDao1.getPrice()%>">AddToCart</a>&nbsp;
<a class="btn" href="BuyComponent.jsp?componentId=<%=comDao1.getComponentId()%>&compantName=<%=comDao1.getComponentName()%>&price=<%=comDao1.getPrice()%>">Buy</a>&nbsp;
</td>
</tr>
</div>
</div>
<%} %>
</table>
</form>
</body>

</html>