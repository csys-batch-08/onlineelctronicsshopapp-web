<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.onlineelectronicshop.daoImpl.UserDaoImpl" %>
    <%@ page import="com.onlineelectronicshop.model.User" %>
  <%@ page import="java.util.List" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My profile</title>

<style>
.menu-bar{
    background:#fff;
    text-align: center;
}
.menu-bar ul{
    display:inline-flex;
    list-style: none;
    color: #fff;
}
.menu-bar ul li
{
width: 330px;
margin: 1px;
padding: 1px;
}
.menu-bar ul li a{
padding: 4px 4px;
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



@use postcss-preset-env {
  stage: 0;
}

:root {
  --color-background: #b3c6ff;
  --color-primary: #4d79ff;
  --font-family-base: Poppin, sans-serif;
  --font-size-h1: 1.25rem;
  --font-size-h2: 1rem;
}


* {
  box-sizing: inherit;
}

html {
  box-sizing: border-box;
}

body {
  background-color: var(--color-background);
  display: grid;
  font-family: var(--font-family-base);
  line-height: 2.5;
  margin: 0;
  min-block-size: 100vh;
  padding: 5vmin;
  place-items: center;
}
fieldset {
  border: 0;
  margin: 0;
  padding: 0;
}

h5 {
  font-size: var(--font-size-h1);
  line-height: 1.2;
  margin-block: 0 1.5em;
}



legend {
  font-weight: 600;
  margin-block-end: 0.5em;
  padding: 0;
}

input {
  border: 0;
  color: inherit;
  font: inherit;
}
.card {
  border-radius: 1em;
  background-color: var(--color-primary);
  color: #fff;
  padding: 1em;
}
.button:focus,
.button:hover {
  background-color: #007acc;
}

.button--full {
  inline-size: 100%;
}


</style>
</head>
<body>
<nav>
<div class="menu-bar">
        <ul>
            <li><a href="viewHomePage.jsp">Home</a></li>
            <li><a href="rechargeWallet.jsp">wallet</a></li>
            <li><a href="ShowComponentServlet">Components</a></li>
            <li><a href="index.jsp">Logout</a></li>            
    </ul>
    </div>
    <br>
    </nav>


<div class="card">
<center><h1>My Profile</h1></center>

<c:forEach items="${listOfUser}" var="users">

<h5>User name:${users.userName}</h5>
<br>
<h5>Email id:${users.emailId}</h5>
<br>
<h5>Wallet amount:${users.wallet}Rs</h5>

<br>

</c:forEach>
</div>
</body>
</html>