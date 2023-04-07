<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Student information</h2>
<form:form action="addStudent" method="POST">
<table>
<tr>
<td><form:label path="name">Name</form:label></td>
<td><form:input path="name" /></td>
<td><form:errors path="name" /></td>
</tr>
<tr>
<td><form:label path="age">Age</form:label></td>
<td><form:input path="age" /></td>
<td><form:errors path="age" /></td>
</tr>
<tr>
<td><form:label path="Id">ID</form:label></td>
<td><form:input path="Id" /></td>
</tr>
<tr>
<td colspan="2"><input type="submit"></td>
</tr>
</table>
</form:form>
<a></a>
</body>
</html>