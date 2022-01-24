<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  page import="com.onlineelectronicshop.daoImpl.ComponentDaoImpl"%>
<%@ page import="com.onlineelectronicshop.model.Components"%>
<%@ page import="com.onlineelectronicshop.daoImpl.UserDaoImpl"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list of components</title>

<style>
{
padding
:
0
;

    
margin
:
0
;

    

}
body {
	background-image: url("home background.jpg");
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
	text-decoration:none;
}

.button {
	background-color: rgba(218, 19, 19, 0.555);
	text-decoration: none;
	display: -moz-inline-box;
	padding: 5px 5px;
}
.btn{
background-color:#00061a;
	text-decoration: none;
	display: -moz-inline-box;
	padding: 5px 5px;
     text-color:#fff;

}


search{
margin-left:300px;



}

body {
	background-image: url("electronic new.jpg");
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
				<li><a href="MyProfile.jsp">My profile</a></li>
                <li><a href="rechargeWallet.jsp">Wallet</a><li>
                <li><a href="MyOrders.jsp">MyOrders</a></li>
                <li><a href="cancelOrder.jsp">CancelOrder</a></li>  
                <li><a href="contactUs.jsp">Contact Us</a></li>             
    </ul>
    </div>
    <br>
    </nav>	
				<!--  <li class="example"><input type="text" placeholder="Search.." name="components"></li>
            <li><a href="SearchComponts.jsp">search</a></li> -->

<br>
	<form action="SearchComponentServlet">
	<label for="search"></label>
	<input style="float:right;" type="text" name="search" id="search" placeholder="Search component name and category name here!">
	<input style="float:right;" type="submit" value="search">
	</form>
		<br>
	<form>
		<table id="components">
		
			<%
			ComponentDaoImpl comDao = new ComponentDaoImpl();
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			List<Components> componentList = comDao.showComponent();

			for (int i = 0; i < componentList.size(); i++) {
				Components comDao1 = componentList.get(i);

				session.setAttribute("componentName", comDao1.getComponentName());
				session.setAttribute("price", comDao1.getPrice());
				session.setAttribute("Category", comDao1.getCategoryName());
			%>
			<tr>
				<td><img alter="#alter" src="images1/<%=comDao1.getImage()%>"
					width="200" height="200"><br>
					
				<span style="visibility:hidden;"><%=comDao1.getComponentId()%></span><br><br>
				Component Name:<%=comDao1.getComponentName()%><br><br>
				Category Name:<%=comDao1.getCategoryName()%><br><br>
				Description:<%=comDao1.getDescription()%><br><br>
				Price:<%=comDao1.getPrice()%><br><br>
				<a class="btn" href="insertCart.jsp?componentId=<%=comDao1.getComponentId()%>&compantName=<%=comDao1.getComponentName()%>&price=<%=comDao1.getPrice()%>">AddToCart</a>&nbsp;
				<a class="btn" href="BuyComponent.jsp?componentId=<%=comDao1.getComponentId()%>&compantName=<%=comDao1.getComponentName()%>&price=<%=comDao1.getPrice()%>">Buy</a>&nbsp;
				<br>
				</td>		
			</tr>
			<%
			}
			%>	
	</table>
	</form>
</body>
</html>
