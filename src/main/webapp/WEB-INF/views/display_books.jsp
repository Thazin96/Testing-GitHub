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
	<h3>All Books Info</h3>
	<div class="container">
		<a href="/bookmanagement/addbook"> Create New</a>
		<div class="row">
			<div class="col">Code</div>
			<div class="col">Name</div>
			<div class="col">Price</div>
			<div class="col">Author(s)</div>
			<div class="col"></div>
		</div>
		<c:forEach var="book" items="${books}">
			<div class="row">
			<div class="col">${book.code}</div>
			<div class="col">${book.name}</div>
			<div class="col">${book.price}</div>
			<div class="col">
				<c:forEach var="author" items="${book.authors}">
					${author.name} ,
				</c:forEach>
			</div>
			
			
			<div class="col">
				<a href="editbook/${book.code}">Edit Book</a> ||
				<a href="deletebook/${book.code}">Delete Book</a>
			</div>
			
		</div>
		</c:forEach>
		
	</div>

</body>
</html>