<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>assignments</title>
</head>
<body>
<h2>ASSIGNMENTS</h2>
<hr/>
<table border="1">
<tr>
<th>ASSIGNMENT ID</th>
<th>Assignment Name</th>
</tr>
<core:forEach items="${ass}" var="ass" >

<tr>
<td>${ass.assignmentId }</td>
<td>${ass.assignmentName }</td>
<td>
<a href="/viewAssignment?aid=${ass.assignmentId }">View</a>
</td>
<td>
<input type="button" onClick="location.href='/deleteAssignment?assname=${ass.assignmentName}'" value="delete"/>
</td>
</tr>

</core:forEach>
</table>
<input type="button" onClick="location.href='/loadAddAssignment'" value="Add Assignment">
</body>

</html>