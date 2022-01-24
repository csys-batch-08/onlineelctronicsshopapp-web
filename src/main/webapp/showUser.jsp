<%@ page import="com.onlineelectronicshop.daoImpl.UserDaoImpl"%>
  <%@ page import="com.onlineelectronicshop.model.User"%>
  <%@ page import="java.util.List" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show all user</title>
<style>
table,td,tr{
border:1px solid black;
border-collapse:collapse;
}
body{
    
    background-image: url("all home page.jpg");
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
}
</style>
</head>
<body>
<form >
<table>
<tr>
<td style=color:white>UserName</td>
<td style=color:white>EmailId</td>
<td style=color:white>Password</td>
<td style=color:white>ContactNumber</td>
<td style=color:white>Address</td>
</tr>
<%UserDaoImpl userDao=new UserDaoImpl();			
List<User> UsersList=userDao.showAllUser();
for(int i=0;i<UsersList.size();i++) {
	User user=UsersList.get(i);
%>
<tr>
<td style=color:white><%=user.getUserName()%></td>
<td style=color:white><%=user.getEmailId() %></td>
<td style=color:white><%=user.getPassword() %></td>
<td style=color:white><%=user.getContactNumber()%></td>
<td style=color:white><%=user.getAddress()%></td>
</tr><%}%>
</table>
</form>
</body>
</html>