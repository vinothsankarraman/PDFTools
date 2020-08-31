<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<h2 class="header">PDF Tools SignUp</h2>
<p align="right"><a href="/" class="button button1" role="button">Login</a></p>
<hr>
<form method="POST" action="home" >
	<div class="container">
		<label for="userid" class="lbl" ><b> Email Address: </b></label>
		 <input  type="text" placeholder="Enter Email Address" name="userid" required><br>
		 
		<label for="password" class="lbl" ><b>Password: </b></label>
		 <input  type="password" placeholder="Enter Password" name="password" required><br>
					
		<button type="submit" class="button button1">Sign Up</button>
		<br><br>	
		
		<c:if test="${errormessage ne null }">
		<p style="color: red;">${errormessage}</p>
		<!-- <script>
			$(document).ready(function(){
	
				var uri = window.location.toString();
	
				if (uri.indexOf("?") > 0) {
	
				    var clean_uri = uri.substring(0, uri.indexOf("?"));
	
				    window.history.replaceState({}, document.title, clean_uri);
	
				}
	
			});
			</script> -->
		</c:if>
	</div>
	</form>

</body>
</html>