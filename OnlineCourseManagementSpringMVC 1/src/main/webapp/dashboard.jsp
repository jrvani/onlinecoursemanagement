<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome 
<p>${sessionScope.username }</p>
<a href="addCourse.jsp"> add Course</a>
<a href="/viewCourse"> view Course</a>
<a href="deleteCourse.jsp"> delete Course</a>
<a href="assignment.jsp">Assignments</a>

<a href ="/logout">Log out</a>
</body>
</html>