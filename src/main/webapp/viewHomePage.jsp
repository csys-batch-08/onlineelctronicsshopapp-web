<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>view home</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<style>
.sidebar {
  margin: 0;
  padding: 0;
  width: 300px;
  background-color: #000033;
  position: fixed;
  height: 100%;
  overflow: auto;
}

.sidebar a {
  display: block;
  color: white;
  padding: 16px;
  text-decoration: none;
}


.sidebar a.active {
  background-color: #6699ff;
  color: white;
}


.sidebar a:hover:not(.active) {
  background-color: #555;
  color: white;
}


div.content {
  margin-left: 200px;
  padding: 1px 16px;
  height: 1000px;
}


@media screen and (max-width: 700px) {
  .sidebar {
    width: 100%;
    height: auto;
    position: relative;
  }
  .sidebar a {float: left;}
  div.content {margin-left: 0;}
}


@media screen and (max-width: 400px) {
  .sidebar a {
    text-align: center;
    float: none;
  }
}

body {
  background-image: url('assests/images/slideshow.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}

</style>
</head>
<body>
<div class="sidebar">
  <a class="active" href="index.jsp">Home</a>
  <a href="ShowComponentServlet">Components</a>
 <a href="MyProfileServlet"><em class="fa fa-fw fa-user"></em>My profile</a>
 <a href="rechargeWallet.jsp"><em class="fas fa-wallet"></em> Wallet</a>
 <a href="ShowOrderServlet">MyOrders</a>
 <a href="CancelOrderRefundServlet">CancelOrder</a>
 <a href="index.jsp"><em class="fa fa-fw fa-user"></em>Logout</a>
</div>
</body>
</html>