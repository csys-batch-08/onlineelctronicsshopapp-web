<%@page import="com.onlineelectronicshop.daoImpl.ComponentDaoImpl"%>
<%@ page import="com.onlineelectronicshop.model.*" %>
  <%@ page import="java.util.List" %>
  <%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String search=request.getParameter("search");
		ComponentDaoImpl comDao=new ComponentDaoImpl();	
		List<Components> componentList=comDao.findCategory();
		 List<Components> List=new ArrayList<Components>();
         for(int i=0;i<componentList.size();i++) {
        	 Components component=componentList.get(i);
        	 if(component.getComponentName().equalsIgnoreCase(search)) {
        		 List.add(component);
        	 }
        	 else if(component.getCategoryName().equalsIgnoreCase(search)) {
        		 List.add(component);
        	 }
        	 for(int j=0;j<List.size();j++) {
        		 Components component1=List.get(j);
        		 
        	 }
        	  
         }
	
		session.setAttribute("list", List);
		response.sendRedirect("search.jsp");
 %>
		 <table>
<tr>
<td>image</td>
<td>componentId</td>
<td>ComponentName</td>
<td>CategoryName</td>
<td>Description</td>
<td>TotalPrice</td>
</tr>
<%
for(int i=0;i<componentList.size();i++)
{
Components comDao1=componentList.get(i);
session.setAttribute("componentName" ,comDao1.getComponentName());
session.setAttribute("price",comDao1.getPrice());
session.setAttribute("Category",comDao1.getCategoryName()); 
%>
<tr>
<td><img alter="#alter" src="images1/<%=comDao1.getImage()%>" width="200"height="200"></td>
<td><%=comDao1.getComponentId() %></td>
<td><%=comDao1.getComponentName()%></td>
<td><%=comDao1.getCategoryName()%></td>
<td><%=comDao1.getDescription() %></td>
<td><%=comDao1.getPrice()%></td>
<td><a href="insertCart.jsp?componentId=<%=comDao1.getComponentId()%>&compantName=<%=comDao1.getComponentName()%>&price=<%=comDao1.getPrice()%>">Add to cart</a></td>
</tr>
<%} %>
</table>		 
</body>
</html>