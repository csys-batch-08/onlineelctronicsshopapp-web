<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Calculate Amount</title>
<style>
.menu-bar {
	background: white;
	text-align: left;
}

.menu-bar ul {
	display: inline-flex;
	list-style: none;
	color: #fff;
}

.menu-bar ul li {
	width: 100px;
	margin: 4px;
	padding: 0px;
}

.menu-bar ul li a {
	padding: 10px 10px;
	font-size: 17px;
	text-decoration:none;
}

body{
    
    background-image: url("assests/images/electronic new.jpg");
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
}
#profile{
align-content: center;
margin-left: 550px;
}

</style>
</head>
<body>
<nav>
<div class="menu-bar">
        <ul>
            <li><a href="viewHomePage.jsp">Home</a></li>
            <li><a href="admin.jsp">AdminPage</a></li>
            <li><a href="OrderListServlet">ViewOrders</a></li>
            <li><a href="contactUs.jsp">Contact Us</a>
            
                  
    </ul>
    </div>
    <br>
    </nav>
<div id="profile">
<form action="CalculateAmount">
  <h1>CalculateAmount</h1>
  
  <label for="fromdate"><strong>FromDate</strong></label>
  <input type="date" name="fromdate" id="fromdate" required ><br><br>
  
  <label for="todate"><strong>ToDate</strong></label>
  <input type="date" name="todate" id="todate" required ><br><br>
  
  <input type="submit" value="Calculate">
  </form>
 </div>
</body>
</html>