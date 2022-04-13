<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dash-board</title>
</head>
<body>
<h1>DASHBOARD</h1>
<hr/>
<h2>Welcome  ${sessionScope.username }</h2>
<a href="/loadCourses">Courses</a><br>
<a href="/loadAssignment">Assignments</a><br>

<a href ="/logout">Log out</a>
</body>
</html>