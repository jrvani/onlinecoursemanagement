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
ASSIGNEMNTS
<hr/>
<table border="1">
<tr>
<th>Assignment Id</th>
<th>Assignment Name</th>
<th>Assignment deadline</th>
<th>score</th>
<th>Questions</th>
</tr>

<tr>
<td>${ass.assignmentId}</td>
<td>${ass.assignmentName}</td>
<td>${ass.deadline}</td>
<td>${ass.score}</td>

<td>
<table border="1">
<core:forEach items="${question }" var="question">
<tr>
<td>${question.questionId }</td>
<td>${question.questionName }</td>
<td><input type="button" onClick="location.href='/deleteQuestion?ass=${question.questionId}'" value="Delete">
</tr>
</core:forEach>
</table>
</td>


<td><input type="button" onClick="location.href='addQuestion.jsp'" value="add Question">
<input type="button" onClick="location.href='/deleteAssignment?assname=${ass.assignmentName}'" value="delete"/>
</tr>
</table>
<input type="button" onClick="location.href='/loadAddAssignment'" value="Add Assignment">

</body>
</html>