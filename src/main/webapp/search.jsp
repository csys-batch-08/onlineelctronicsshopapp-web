<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  page import="com.onlineelectronicshop.daoImpl.ComponentDaoImpl"%>
<%@ page import="com.onlineelectronicshop.model.Components"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</head>
<body>


	//Users user = (Users) session.getAttribute("CurrentUser");


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
		List<Components> searchpro = (List<Components>)session.getAttribute("list");
		for (int i = 0; i < searchpro.size(); i++) {
			Components comDao1 = searchpro.get(i);
		%>
		<tr>
			<td><img alter="#alter" src="images1/<%=comDao1.getImage()%>"
				width="200" height="200"></td>
			<td><%=comDao1.getComponentId()%></td>
			<td><%=comDao1.getComponentName()%></td>
			<td><%=comDao1.getCategoryName()%></td>
			<td><%=comDao1.getDescription()%></td>
			<td><%=comDao1.getPrice()%></td>
			<td><a
				href="insertCart.jsp?componentId=<%=comDao1.getComponentId()%>&compantName=<%=comDao1.getComponentName()%>&price=<%=comDao1.getPrice()%>">Add
					to cart</a></td>
		</tr>
		<%
		}
		%>
	</table>




</body>
</html>