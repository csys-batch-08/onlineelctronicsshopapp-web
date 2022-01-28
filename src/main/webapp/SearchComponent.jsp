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
<title>Search component</title>
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
<c:forEach items="${showComponent}" var="component" >

			
			<tr>
				<td><img alter="#alter" src="images1/${component.image}"
					width="200" height="200"><br>
					
				<span style="visibility:hidden;">${component.componentId}</span><br><br>
				Component Name:${component.componentName}<br><br>
				Category Name:${ component.categoryName}<br><br>
				Description:${component.description}<br><br>
				Price:${component.price}<br><br>
				<a class="btn" href="insertCart.jsp?componentId=${component.componentId}&compantName=${component.componentName}&price=${component.price}">AddToCart</a>&nbsp;
				<a class="btn" href="BuyComponent.jsp?componentId=${component.componentId}&compantName=${component.componentName}&price=${component.price}">Buy</a>&nbsp;
				<br>
				</td>		
			</tr>
			</c:forEach>

</table>		 
</body>
</html>