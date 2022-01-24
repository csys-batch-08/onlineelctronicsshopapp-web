<%@page import="java.sql.ResultSet"%>
<%@page import="com.onlineelectronicshop.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.onlineelectronicshop.daoImpl.ComponentDaoImpl" %>
     <%@ page import="com.onlineelectronicshop.daoImpl.OrderDaoImpl" %>
      <%@ page import="com.onlineelectronicshop.daoImpl.InvoiceDaoImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice</title>


<style>
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

h1 {
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
<form action="viewHomePage.jsp">
<header class="header">
   <center>
    <h1>Invoice</h1></center>
  </header>
  <div class="card">
<%
User user=(User)session.getAttribute("CurrentUser");
InvoiceDaoImpl invoice=new InvoiceDaoImpl();

ResultSet rs=invoice.showBill(user.getUserid());
if(rs.next()){ %>
	<h1>User name:<%=rs.getString(1) %></h1>
<h1>Component name:<%=rs.getString(2) %></h1>
<h1>Quantity:<%=rs.getInt(3) %></h1>
<h1>Price:<%=rs.getDouble(4) %></h1>
<h1>Order date:<%=rs.getDate(5) %></h1>

<%} %>
<button type="submit">Home</button>
</form>
</body>
</html>