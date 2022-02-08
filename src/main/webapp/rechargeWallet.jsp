<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recharge wallet</title>
<style>
.menu-bar {
	background: white;
	
}

.menu-bar ul {
	display: inline-flex;
	list-style: none;
	color: #fff;
}

.menu-bar ul li a {
	padding: 10px 10px;
	font-size: 17px;
	text-decoration:none;
}




body{
    
    background-image: url("assets/images/electronic new.jpg");
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
}

table,td,tr{
border:1px solid black;
border-collapse:collapse;
}

#wallet{
align-content:center;
margin-left: 500px;
}
</style>
</head>
<body>
<nav>
		<div class="menu-bar">
			<ul>
				<li><a href="viewHomePage.jsp">Home</a></li>
				<li><a href="MyProfile.jsp">My profile</a></li>
                <li><a href="MyOrders.jsp">MyOrders</a></li>
                <li><a href="contactUs.jsp">Contact Us</a></li>             
    </ul>
    </div>
    <br>
    </nav>	
<div id="wallet">
<form action="RechargeWalletServlet" method="post">
<fieldset>
<h1>Recharge your wallet</h1>
 
         <label for="Amount">Amount:</label><br>
         <input type="text" name="wallbal" id="wallbal" placeholder="Enter Amount" Pattern="[1-9][0-9]+" maxlength="3" min="0"><br><br>
        <button type="submit">Recharge Wallet</button>
             
    </fieldset>
    <br>
    </form>
    </div>
</body>
</html>