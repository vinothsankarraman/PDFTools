<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Split PDF</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<h1 class="header">Split PDF</h1>
	<a href="main" class="home home1" role="button">Back to Home</a>
	<hr>
	<form method="POST" action="split" enctype="multipart/form-data">

			<div class="container">

			<label for="choosefile" class="lbl">Select the PDF File : </label> <input
				type="file" name="file" accept=".pdf" required><br>
			<br>
			 <label for="startindex" class="lbl">Enter the Start Page Number: </label> 
			<input type="text"  placeholder="Start Page Number" name="startindex" required>
			<br><br>
			<label for="endindex" class="lbl">Enter the End Page Number:</label> 
			<input type="text"  placeholder="End Page Number" name="endindex" required>

		</div>
		
		<br>
		<br>

		<div class="buttondiv">
			<button type="submit" class="button button1">SplitPDF</button>
		</div>
		<br>
		<br>
		<c:if test="${errormessage ne null }">
			<p style="color: red;">${errormessage}</p>

		</c:if>
	</form>


</body>
</html>