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
<jsp:include page="index.jsp"></jsp:include>
<h3>All Authors Info: </h3>
<div class="container">
		<a href="/bookmanagement/addauthor"> Create New</a>
		<div class="row">
			<div class="col">No.</div>
			<div class="col">Name</div>
			<div class="col">Address</div>
			<div class="col">Contact</div>
			<div class="col">Email</div>
			<div class="col"></div>
		</div>
		<c:forEach var="author" items="${authors}">
			<div class="row">
			<div class="col">${author.id}</div>
			<div class="col">${author.name}</div>
			<div class="col">${author.address}</div>
			<div class="col">${author.copyright_contace}</div>
			<div class="col">${author.contact_email}</div>
			<div class="col">
				<a href="editauthor/${author.id}">Edit</a> ||
				<a href="deleteauthor/${author.id}">Delete</a>
			</div>
			
		</div>
		</c:forEach>
		
	</div>
</body>
</html>