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
<title>list of components</title>
<style>
table,td,tr{
border:1px solid white;
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

<table>
<tr>
<td>ComponentName</td>
<td>CategoryName</td>
<td>Description</td>
<td>TotalPrice</td>
<td>Action</td>
</tr>
<%ComponentDaoImpl comDao=new ComponentDaoImpl();	
UserDaoImpl userDaoImpl=new UserDaoImpl();
List<Components> componentList=comDao.showComponent();

for(int i=0;i<componentList.size();i++)
{
Components comDao1=componentList.get(i);
session.setAttribute("componentName" ,comDao1.getComponentName());
session.setAttribute("price",comDao1.getPrice()); %>
<tr>
<td><%=comDao1.getComponentName()%></td>
<td><%=comDao1.getCategoryName()%></td>
<td><%=comDao1.getDescription() %></td>
<td><%=comDao1.getPrice() %></td>
<td><%=comDao1.getAvailable() %></td>
<td>
<form action="updateComponentServelt" method="post">

<lable>ComponentName:</lable>
<input type="text" name="componentName" value="<%=comDao1.getComponentName()%>"></br>

<label>Enter Price</label><br>
<input type="text" name="price" id="price" min="0">
<button type="submit">submit</button>
</form>

<form action="DeleteProductServlet" method="post">
<input type="text" name="componentName" value="<%=comDao1.getComponentName()%>" style="visibility: hidden"></br>

<button type="submit" value="<%=comDao1.getComponentId()%>">Change Status</button>
</form>
</td>
</tr>
<%} %>
</table>
</form>
</body>
</html>