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
<th>Assignment Id</th>
<th>Assignment Name</th>
<th>Assignment deadline</th>
<th>score</th>
</tr>
<core:forEach items="${ass}" var="ass" >
<tr>
<td>${ass.assignmentId}</td>
<td>${ass.assignmentName}</td>
<td>${ass.deadline}</td>
<td>${ass.score}</td>
</tr>
</core:forEach>
</table>
</body>
</html>