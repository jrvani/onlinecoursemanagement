<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
	font-weight: bold;
	font-style: italic;
}
</style>
</head>
<body>
	<h2>Register</h2>
	<hr />
	<form:form action="/register" method="post" modelAttribute="instructorDto">
		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error"></form:errors></td>

			</tr>
			<tr>
				<td>user-name</td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>password</td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
