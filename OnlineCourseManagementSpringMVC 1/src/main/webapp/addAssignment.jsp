<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/addAssignment" method="post">
<table>
<tr> <td>Assignment name</td>
     <td><input type="text" name="assignmentName"></td>
     </tr>
     
     <tr> <td>Assignment Date</td>
     <td><input type="text" name="deadline"></td>
     </tr>
     <tr> <td>Assignment Score</td>
     <td><input type="text" name="score"></td>
     </tr>
     <tr>
     <td><input type="submit" value="submit"></td>
     </tr>
     
</table>
</form>
</body>
</html>