<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
    <link rel="stylesheet" href="style2.css">


</head>
<body>
<%-- <%String error=(String)session.getAttribute("invalid");
if(error!=null){
%>
<h1><%=error %></h1>
<%} %> --%>
<form action="LoginServlet" class="form" method="post">
        <div class="loginbox">
        <h1>Login Here</h1>
        
            <p>Email</p>
            <input type="text" name= "loginemail" placeholder="Enter email" required>
            <p>Password</p>
            <input type="Password" name="loginpassword" placeholder="Enter Password" required>
            <input type="submit" name="login" value="Login"><br>
            <a href="#">Forget your Password?</a><br>
            <a href="index.jsp">Don't have account?</a>
            </div>
        </form>
       
</body>
</html>
