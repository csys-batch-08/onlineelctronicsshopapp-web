<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>
<style>
body {
	background-image: url("assests/images/electronic new.jpg");
	background-repeat: no repeat;
	background-size: cover;
	font-family: Cambria;
}

.sidebar-container {
	position: fixed;
	width: 220px;
	height: 100%;
	left: 0;
	overflow-x: hidden;
	overflow-y: auto;
	background: #1a1a1a;
	color: #fff;
}

.content-container {
	padding-top: 20px;
}

.sidebar-logo {
	padding: 10px 15px 10px 30px;
	font-size: 20px;
	background-color: #2574A9;
}

.sidebar-navigation {
	padding: 0;
	margin: 0;
	list-style-type: none;
	position: relative;
}

.sidebar-navigation li {
	background-color: transparent;
	position: relative;
	display: inline-block;
	width: 100%;
	line-height: 20px;
}

.sidebar-navigation li a {
	padding: 10px 15px 10px 30px;
	display: block;
	color: #fff;
}

.sidebar-navigation li .fa {
	margin-right: 10px;
}

.sidebar-navigation li a:active, .sidebar-navigation li a:hover,
	.sidebar-navigation li a:focus {
	text-decoration: none;
	outline: none;
}

.sidebar-navigation li::before {
	background-color: #2574A9;
	position: absolute;
	content: '';
	height: 100%;
	left: 0;
	top: 0;
	-webkit-transition: width 0.2s ease-in;
	transition: width 0.2s ease-in;
	width: 3px;
	z-index: -1;
}

.sidebar-navigation li:hover::before {
	width: 100%;
}

.sidebar-navigation .header {
	font-size: 12px;
	text-transform: uppercase;
	background-color: #151515;
	padding: 10px 15px 10px 30px;
}

.sidebar-navigation .header::before {
	background-color: transparent;
}

.content-container {
	padding-left: 220px;
}
</style>
</head>
<body>
	<div class="sidebar-container">
		<div class="sidebar-logo">Admin Page</div>

		<ul class="sidebar-navigation">
			<li class="header">Sales</li>
			<li><a href="calculateAmount.jsp"> <i class="fa fa-home"
					aria-hidden="true"></i>Calculate Amount
			</a></li>
			<li><a href="OrderListServlet"> <i class="fa fa-tachometer"
					aria-hidden="true"></i>View Orders
			</a></li>
			<li class="header">User side</li>
			<li><a href="ShowUserServlet"> <i class="fa fa-users"
					aria-hidden="true"></i>Show all users
			</a></li>
			<li><a href="ViewComponentServlet"> <i class="fa fa-cog"
					aria-hidden="true"></i>Show Components
			</a></li>
			<li><a href="UpdateShowComponentServlet"> <i
					class="fa fa-info-circle" aria-hidden="true"></i>Update component
			</a></li>
			<li><a href="insertComponent.jsp"> <i
					class="fa fa-info-circle" aria-hidden="true"></i>Add new Product
			</a></li>
			<li><a href="DeleteProductServlet"> <i
					class="fa fa-info-circle" aria-hidden="true"></i>Delete component
			</a></li>
			<li><a href="ShowInactiveComponentServlet"> <i
					class="fa fa-info-circle" aria-hidden="true"></i>Inactive component
			</a></li>

			<li><a href="viewHomePage.jsp"> <i class="fa fa-info-circle"
					aria-hidden="true"></i>Logout
			</a></li>



		</ul>
	</div>

</body>
</html>