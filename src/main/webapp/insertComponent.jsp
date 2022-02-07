<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Components</title>
<style>
body{
    
    background-image: url("assests/images/electronic new.jpg");
    background-repeat:no repeat;
    background-size: cover;
   
    font-family: Cambria;
}
</style>
</head>
<body>
<h1>Add new Component</h1>
<form action="insertComponentServlet" method="post">
<label>enter component name</label><br>
<input type="text" name="componentName" id="componentName"><br>
<label>enter category Name</label><br>
<input type="text" name="categoryName" id="categoryName"><br>
<label>enter Description</label><br>
<textarea id="description" name="description" rows="4" cols="50"></textarea><br>
<label>enter Price</label><br>
<input type="number" name="price" id="Price" min="0"><br>
<label>status availability</label><br>
<input type="text" name="available" id="available"><br>

<input type="file" name="componentImage">
<input type="submit" value="submit">
</form>
</body>
</html>