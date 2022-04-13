<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/add" method="post">
<table border="1">
<tr> <td>Course name</td>
     <td><input type="text" name="courseName"></td>
     </tr>
     
     <tr> <td>Course Description</td>
     <td><input type="text" name="courseDescription"></td>
     </tr>
     <tr> <td>Course Duration</td>
     <td><input type="text" name="courseDurationInMonths"></td>
     </tr>
     <tr>
     <td><input type="submit" value="submit"></td>
     </tr>
     
</table>
</form>
<p>${success }</p>
</body>
</html>