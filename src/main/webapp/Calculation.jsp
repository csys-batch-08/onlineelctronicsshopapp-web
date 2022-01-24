<%@page import="java.sql.ResultSet"%>
<%@page import="com.onlineelectronicshop.daoImpl.OrderDaoImpl"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculation</title>
<style>

body{
    
    background-image: url("electronic new.jpg");
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
}
#Calculate {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;

}

#Calculate td, Calculate th {
  border: 1px solid #ddd;
  padding: 8px;
}

#Calculate tr:nth-child{background-color: #f2f2f2;}

#Calculate tr:hover {background-color: #ddd;}

#Calculate th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #0080ff;
  color: white;
}
</style>


</head>
<body>
<center>
<table id="Calculate"><tr>
<th>ComponentId</th>
<th>Amount</th>
</tr>
<%Date fromDate=(Date)session.getAttribute("FromDate");
Date toDate=(Date)session.getAttribute("ToDate");
OrderDaoImpl orderDao=new OrderDaoImpl();
ResultSet rs=orderDao.CalculateAmount(fromDate, toDate);
while(rs.next()){
	

%>

<tr>
<td><%=rs.getInt(1) %></td>
<td><%=rs.getDouble(2) %></td>
</tr>
<%} %>
</table>
</center>
</body>
</html>