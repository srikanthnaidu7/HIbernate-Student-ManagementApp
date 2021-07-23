<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
</head>
<body>
<div align="center">
<h1>Add Student</h1>
<div align="center"><a href="/Student-ManagementApp/showStudents" class="btn btn-primary">Go List</a></div>
	<form:form action="save-student" modelAttribute="student" method="POST">
		<form:hidden path="id"/>
	
		<label id="name">Name:</label>
		<form:input path="name" />
		</br>
		
		<label id="mobile">Mobile:</label>
		<form:input path="mobile" />
		</br>
		<label id="country">Country:</label>
		<form:input path="country" />
		</br>
		
		<label id="email">Email:</label>
		<form:input path="email" />
		</br>
		<input type="submit" class="btn btn-outline-success" value="ADD">
		
	</form:form>
</div>
</body>
</html>