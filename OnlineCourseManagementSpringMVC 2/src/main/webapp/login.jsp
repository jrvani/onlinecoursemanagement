<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>LOGIN Page</h2>
	<hr />
	<form action="/login" method="post">
		<table>
			<tr>
				<td>User-name</td>
				<td><input type="text" name="username" /></td>

			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" /></td>
				
			</tr>
			
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>