<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@  page import="com.onlineelectronicshop.daoImpl.ComponentDaoImpl"%>
  <%@ page import="com.onlineelectronicshop.model.Components" %>
  <%@ page import="com.onlineelectronicshop.daoImpl.UserDaoImpl" %>
  <%@ page import="java.util.List" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view components</title>

<style>
table,td,tr{
border:1px solid black;
border-collapse:collapse;
}
body{
    
    background-image: url("electronic new.jpg");
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
}

</style>
</head>
<body>
<form>
<table>
<tr>
<td>Componentid</td>
<td>ComponentName</td>
<td>CategoryName</td>
<td>Description</td>
<td>TotalPrice</td>

</tr>
<%
ComponentDaoImpl comDao=new ComponentDaoImpl();	
UserDaoImpl userDaoImpl=new UserDaoImpl();
List<Components> componentList=comDao.showComponent();

for(int i=0;i<componentList.size();i++)
{
Components comDao1=componentList.get(i);

 %>
<tr>
<td><%=comDao1.getComponentId() %></td>
<td><%=comDao1.getComponentName()%></td>
<td><%=comDao1.getCategoryName()%></td>
<td><%=comDao1.getDescription() %></td>
<td><%=comDao1.getPrice()%></td>
</tr>
<%} %>
</table>
</body>
</html>