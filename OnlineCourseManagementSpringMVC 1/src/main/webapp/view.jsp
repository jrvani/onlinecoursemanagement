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
<table>
<tr>
<th>Course Id</th>
<th>Course Name</th>
<th>Course Description</th>
<th>Course Duration</th>
</tr>
<core:forEach items="${courseV}" var="courseV" >
<tr>
<td>${courseV.courseId}</td>
<td>${courseV.courseName}</td>
<td>${courseV.courseDescription}</td>
<td>${courseV.courseDurationInMonths}</td>
</tr>
</core:forEach>
</table>
</body>
</html>