<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
The course :
<table>
<tr>
<th>Course Id</th>
<th>Course Name</th>
<th>Course Description</th>
<th>Course Duration</th>
<th>Assignments</th>
</tr>
<tr>
<td>${course.courseId}</td>
<td>${course.courseName}</td>
<td>${course.courseDescription}</td>
<td>${course.courseDurationInMonths}</td>
<td>${course.assignments }</td>
</tr>
</table>
</body>
</html>