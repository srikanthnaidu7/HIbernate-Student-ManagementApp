<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>STUDENT LIST</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
	integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
	integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
	crossorigin="anonymous"></script>

</head>
<body>
	<h1 align="center">Student List</h1>
	<div align="center">
		<div align="center">
			<!-- <form action="/Student-ManagementApp/addstudent">
				<input class="btn btn-outline-success" type="submit" value="ADD">
			</form> -->
			<a href="/Student-ManagementApp/addstudent"
				class="btn btn-outline-success">ADD</a>
		</div>
		<table class="table table-striped table-bordered">

			<thead>
				<tr class="warning">
					<th>Student Id</th>
					<th>Name</th>
					<th>Mobile</th>
					<th>Country</th>
					<th>Email</th>
				</tr>
			</thead>
			<c:forEach var="student" items="${students}">
				<tr class="info">
					<td class="success">${student.id}</td>
					<td>${student.name}</td>
					<td>${student.mobile}</td>
					<td>${student.country}</td>
					<td>${student.email}</td>
					<td><a
						href="/Student-ManagementApp/updateStudent?userId=${student.id}">Update</a></td>
					<td><a
						href="/Student-ManagementApp/deleteStudent?userId=${student.id}"
						onclick="if(!confirm('Are you sure you want to delete this Student Record')) return false">Delete</a>
					</td>
				</tr>
			</c:forEach>


		</table>
	</div>
</body>
</html>