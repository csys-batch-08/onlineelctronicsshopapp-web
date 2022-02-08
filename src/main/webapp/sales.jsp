<%@page import="java.sql.ResultSet"%>
<%@page import="com.onlineelectronicshop.daoImpl.OrderDaoImpl"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>sales</title>
<style>

body{
    
    background-image: url("assests/images/electronic new.jpg");
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

<table id="Calculate">
<tr>
<th>ComponentId</th>
<th>Amount</th>
</tr>
<c:forEach items="${sessionScope.list2}" var="calculation">

<tr>
<td>${calculation.componentId}</td>
<td>${calculation.totalPrice}</td>
</tr>
</c:forEach>
</table>
</body>
</html>