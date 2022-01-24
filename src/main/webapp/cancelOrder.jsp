<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.onlineelectronicshop.daoImpl.OrderDaoImpl" %>
     <%@ page import="com.onlineelectronicshop.daoImpl.*" %>
     <%@ page import="com.onlineelectronicshop.model.*" %>
  <%@ page import="java.util.List" %>
  <%@ page import="java.time.LocalDate" %>
<%@page import="java.sql.ResultSet" %> 
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
<%
if(session.getAttribute("cancel")!=null){ %>
<h1>Order cancelled and amount refunded successfully!! </h1>

<%} %>
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
<%OrderDaoImpl orderDao=new OrderDaoImpl();	
int userId=(int) session.getAttribute("userId");
UserDaoImpl userDao=new UserDaoImpl();
ComponentDaoImpl comDao=new ComponentDaoImpl();
System.out.println(userId);
ResultSet rs=orderDao.showOrder(userId);
%>
<!-- 
or(int i=0;i<orderList.size();i++){
	Order order=orderList.get(i);
LocalDate date=orderList.get(i).getOrderDate();
System.out.println(date);

-->
<% while(rs.next()){ 
System.out.println(rs.getInt(2));
	int userid=rs.getInt(2);
int compId=rs.getInt(3);
User user=userDao.findUser(userid);
ResultSet rs1=comDao.findCompoent(compId);
if(rs1.next()){
%>

<tr>
<td><%=rs.getInt(1) %></td>
<td><%=user.getUserName() %></td>
<td><%=rs1.getString(2) %></td>
<td><%=rs.getInt(4) %></td>
<td><%=rs.getDouble(5)%></td>
<td><%=rs.getDate(7) %>
<td><a href="CancelOrderServlet?orderid=<%=rs.getInt(1) %>&refundprice=<%=rs.getDouble(5)%>">Cancel</a></td>
</tr>

<%} } %>
</table>
</body>
</html>