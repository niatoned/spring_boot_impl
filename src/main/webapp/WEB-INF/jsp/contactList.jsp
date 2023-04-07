<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h2>Contact list</h2>
<h3><a href="newContact">New Contact</a></h3>
<table border="1">

<thead>
<tr>
<th>Contact Id</th>
<th>Name</th>
<th>Email</th>
<th>Address</th>
<th>Telephone</th>
<th>Action</th>
</tr>
</thead>

<tbody>
<c:forEach items="${contactList}" var="contact">
<tr>
<td>${contact.contact_id}</td>
<td>${contact.name}</td>
<td>${contact.email}</td>
<td>${contact.address}</td>
<td>${contact.telephone}</td>
<td><a href="editContact?id=${contact.contact_id}">Edit</a>
<a href="deleteContact?id=${contact.contact_id}">Delete</a></td>
</tr>
</c:forEach>
</tbody>

</table></div>
</body>
</html>