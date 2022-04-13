<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Enter Assignment Details</h2>
<hr/>
<form:form action="/addAssignment" method="post" modelAttribute="assignmentsDTO">
<table border="1">
<tr> <td>Assignment name</td>
     <td><form:input path="assignmentName"/></td>
     <td><form:errors path="assignmentName" cssClass="error"></form:errors></td>
     </tr>
     
     <tr> <td>Assignment Date</td>
     <td><form:input path="deadline"/></td>
     <td><form:errors path="deadline" cssClass="error"></form:errors></td>
     </tr>
     <tr> <td>Assignment Score</td>
     <td><form:input path="score"/></td>
     </tr>
     <tr>
     <td><input type="submit" value="submit"></td>
     </tr>
     
</table>
</form:form>
</body>
</html>