<%@page import="java.sql.ResultSet"%>
<%@page import="com.onlineelectronicshop.daoImpl.OrderDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order list</title>
</head>
<style>

body{
    
    background-image: url("electronic new.jpg");
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
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

#order tr:nth-child(even){background-color: #f2f2f2;}

#order tr:hover {background-color: #ddd;}

#order th {
  padding-top: 15px;
  padding-bottom: 15px;
  text-align: left;
  background-color: #0080ff;
  color: white;
}

.menu-bar{
    background:#5ab9ea;
    text-align: center;
}
.menu-bar ul{
    display:inline-flex;
    list-style: none;
    color: #fff;
}
.menu-bar ul li
{
width: 150px;
margin: 8px;
padding: 1px;
}
.menu-bar ul li a{
padding: 8px 8px;
font-size: 17px;
 text-decoration:none;
}




</style>





<body>
<nav>
<div class="menu-bar">
        <ul>
            <li><a href="Home.jsp">Home</a></li>
            <li><a href="calculateAmount.jsp">CalculateAmount</a></li>
            <li><a href="admin.jsp">Admin</a></li>
            <li><a href="contactUs.jsp">Contact Us</a>               
    </ul>
    </div>
    <br>
    </nav>


<form>
<table id="order">

<tr>
<th>Order id</th>
<th>User id</th>
<th>Component id</th>
<th>Quantity</th>
<th>Total price</th>
<th>Address</th>
<th>Order Date</th>
<th>Order status</th>
<th>Update status</th>
</tr>
<%OrderDaoImpl orderDao=new OrderDaoImpl();	
ResultSet rs=orderDao.orderList();
while(rs.next()){
%>
<tr>
<td><%=rs.getInt(1) %></td>
<td><%=rs.getInt(2) %></td>
<td><%=rs.getInt(3) %></td>
<td><%=rs.getInt(4) %></td>
<td><%=rs.getDouble(5)%></td>
<td><%=rs.getString(6) %></td>
<td><%=rs.getDate(7) %></td>
<td><%=rs.getString(8) %></td>
<td><a href="ChangeOrderStatusServelt?orderid=<%=rs.getInt(1) %>">UpdateStatus</a></td></tr>
<%} %>
</table>
</form>
</body>
</html>