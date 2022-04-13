<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Courses</title>
<script>


</script>
</head>
<body>
<h3>COURSES</h3>
<hr/>
<table border="1" >
<tr>
<th>COURSE ID</th>
<th>COURSE NAME</th>
</tr>

<core:forEach items="${courseV}" var="courseV" >

<tr>
<td>${courseV.courseId }</td>
<td>${courseV.courseName }</td>
<td>
<a href="/view?cid=${courseV.courseId }">View</a>
</td>
<td>
<input type="button" onClick="location.href='/loaddelete?cid=${courseV.courseId}'" value="delete"/>
</td>
</tr>


</core:forEach>

</table>
<input type="button" onClick="location.href='/loadAddCourse'" value="ADD COURSE">


</body>
</html>