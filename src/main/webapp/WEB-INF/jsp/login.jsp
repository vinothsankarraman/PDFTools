<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<h2 class="header">PDF Tools Login</h2>
<hr>
<form action="signupform">
	<p style="color: purple;font-family: Century Gothic; font-size: 15px; font-weight: bold;" align="right">New User? <button type="submit" class="button button1">SignUp >></button></p>
</form>
<form method="POST" action="homepage" >
	<div class="container">
		<label for="userid" class="lbl" ><b>Registered Email Address: </b></label>
		 <input  type="text" placeholder="Enter Email Address" name="userid" required><br>
		 
		<label for="password" class="lbl"><b>Password: </b></label>
		 <input type="password" placeholder="Enter Password" name="password" required><br>
					
		<button type="submit" class="button button1">Login</button>
		<br><br>	
		
		<c:if test="${errormessage ne null }">
		<p style="color: red;">${errormessage}</p>
			
		</c:if>
		</div>		
	</form>

</body>
</html>