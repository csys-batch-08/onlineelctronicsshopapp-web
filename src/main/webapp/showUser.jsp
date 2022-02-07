<%@ page import="com.onlineelectronicshop.daoImpl.UserDaoImpl"%>
<%@ page import="com.onlineelectronicshop.model.User"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show all user</title>
<style>
table, td, tr {
	border: 1px solid black;
	border-collapse: collapse;
}

body {
	background-image: url("assests/images/electronic new.jpg");
	background-repeat: no repeat;
	background-size: cover;
	font-family: Cambria;
}
</style>
</head>
<body>
	<h1>User list</h1>
	<form>
		<table>
			<tr>
				<th>UserName</th>
				<th>EmailId</th>
				<th>Password</th>
				<th>ContactNumber</th>
				<th>Address</th>
			</tr>
			<c:forEach items="${listOfUser}" var="user">
				<tr>
					<td>${user.userName}</td>
					<td>${user.emailId}</td>
					<td>${user.password}</td>
					<td>${user.contactNumber}</td>
					<td>${user.address}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>