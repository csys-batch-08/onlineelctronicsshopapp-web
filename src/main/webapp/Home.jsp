<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
{
    padding:0;
    margin:0;
    
}
body{
    
    background-image: url('images1/home background.jpg');
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
}
.menu-bar{
    background:#5ab9ea;
    text-align: center;
}
.menu-bar ul{
    display:inline-flex;
    list-style: none;
    color: #fff;
}
.menu-bar ul li
{
width: 150px;
margin: 8px;
padding: 1px;
}
.menu-bar ul li a{
padding: 8px 8px;
font-size: 17px;
 text-decoration:none;
}

.button
{
    background-color: rgba(218, 19, 19, 0.555);
    text-decoration: none;
    display: -moz-inline-box;
    padding: 5px 5px;
    
}
</style>
<meta charset="ISO-8859-1">
<title>Home page</title>
 
</head>
<body>
<center>
<h3 style=color:white>Online electronic shop</h3>
</center>
<nav>
<div class="menu-bar">
        <ul>
            <li class="active">Home</li>
            <li><a href="index.jsp">Register</a></li>
            <li><a href="login.jsp">Login</a></li>
            <li><a href="contactUs.jsp">Contact Us</a>
            
                  
    </ul>
    </div>
    <br>
    </nav>
    <p style=color:white>Here's a list of all components in stock,followed by a quick guide to buying new electronic components.</p>
</html>