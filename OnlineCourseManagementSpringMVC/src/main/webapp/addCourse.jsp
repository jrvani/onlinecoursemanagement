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
<form:form action="/add" method="post" modelAttribute="courseDTO">
<table border="1">
<tr> <td>Course name</td>
     <td><form:input path="courseName"/></td>
     <td><form:errors path="courseName" cssClass="error"></form:errors></td>
     </tr>
     
     <tr> <td>Course Description</td>
     <td><form:input path="courseDescription"/></td>
     <td><form:errors path="courseDescription" cssClass="error"></form:errors></td>
     </tr>
     <tr> <td>Course Duration</td>
     <td><form:input path="courseDurationInMonths"/></td>
     <td><form:errors path="courseDurationInMonths" cssClass="error"></form:errors></td>
     </tr>
     
     
</table>
<input type="submit" value="submit">
  
</form:form>
</body>
</html>