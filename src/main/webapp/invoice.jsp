<%@page import="java.sql.ResultSet"%>
<%@page import="com.onlineelectronicshop.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.onlineelectronicshop.daoImpl.ComponentDaoImpl" %>
     <%@ page import="com.onlineelectronicshop.daoImpl.OrderDaoImpl" %>
      <%@ page import="com.onlineelectronicshop.daoImpl.InvoiceDaoImpl" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
      
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

<form>
<header class="header">
   <center>
    <h1>Invoice</h1></center>
  </header>
  <div class="card">
  
<c:forEach items="${sessionScope.invoice}" var="Invoice" >
  <span>UserName:${Invoice.get(0)}</span><br>
  <span>ComponentName:${Invoice.get(1)}</span><br>
  <span>Quantity:${Invoice.get(2)}</span><br>
 <span>Price:${Invoice.get(3)}Rs</span><br>
 
 
  <span>OrderDate:<fmt:parseDate value="${Invoice.get(4)}"   pattern="yyyy-MM-dd" var="invoiceDate" type="date"/>
<fmt:formatDate pattern="dd-MM-yyyy" value="${invoiceDate}"/></span>
  
  
  </c:forEach>

</div>
</form>
</body>
</html>