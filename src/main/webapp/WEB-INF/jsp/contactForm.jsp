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
<h2>Create / Edit Contact</h2>
<form:form action="saveContact" method="POST" modelAttribute="contact">
<table>
<form:hidden path="contact_id"/>
<tr>
<td><form:label path="name">Name</form:label></td>
<td><form:input path="name" /></td>
<td><form:errors path="name" /></td>
</tr>
<tr>
<td><form:label path="email">Email</form:label></td>
<td><form:input path="email" /></td>
<td><form:errors path="email" /></td>
</tr>
<tr>
<td><form:label path="address">Address</form:label></td>
<td><form:input path="address" /></td>
<td><form:errors path="address" /></td>
</tr>
<tr>
<td><form:label path="telephone">Telephone</form:label></td>
<td><form:input path="telephone" /></td>
<td><form:errors path="telephone" /></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Save"></td>
</tr>
</table>
</form:form>
</body>
</html>