<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function add()
{
	alert("i m here");
	window.location="/addAssignment.jsp";
}

function view()
{
	window.location="/viewAssignment";
}

function deleteAss()
{
	window.location="/deleteAssignment.jsp";
}



</script>
</head>
<body>
<button onclick="add()">add assignment</button>
<input type="button" value="view assignment" onClick="view()">
 
<button onclick="deleteAss()">delete assignment</button>



</body>
</html>