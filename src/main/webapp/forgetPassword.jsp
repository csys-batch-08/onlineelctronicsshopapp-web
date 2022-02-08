<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>forgetPassword</title>
<link rel="stylesheet" href="style2.css">

</head>
<body>
<form action="forgetPasswordServlet" class="form">
<div class="loginbox">
<h1>Reset Password</h1><br>
            
            <p>Enter new Password</p>
            <input type="Password" name="loginpassword" placeholder="Enter Password" pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" required autofocus>
            <p>Confirm password</p>
            <input type="Password" name="loginpassword" placeholder="Enter Password" pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" required>
            <input type="submit" name="login" value="Change"><br>


</form>
</div>
</body>
</html>