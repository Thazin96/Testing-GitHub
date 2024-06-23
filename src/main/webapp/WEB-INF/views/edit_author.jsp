<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
	<div class="container">
	
	<h4>Update Author Info</h4>
	<div class="text-danger">${error_msg}</div>
	<form:form action="/bookmanagement/editauthor" method="post" modelAttribute="author">
	<div class="col-sm-3">
			<form:input type="hidden" class="form-control" path='id'></form:input>
		</div>
		
		
		<div class="mb-4">
			<form:label path='name' class="form-label">Name</form:label>
		
		<div class="col-sm-3">
			<form:input type="text" class="form-control" path='name'></form:input>
		</div>
		<form:errors path='name' cssClass='text-danger'></form:errors>
		</div>
		
		
		<div class="mb-4">
			<form:label path='address' class="form-label">Address</form:label>
		
		<div class="col-sm-3">
			<form:input type="text" class="form-control" path='address'></form:input>
		</div>
		<form:errors path='address' cssClass='text-danger'></form:errors>
		</div>
		<div class="mb-4">
			<form:label path='copyright_contace' class="form-label">Contact</form:label>
		
		<div class="col-sm-3">
			<form:input type="text" class="form-control" path='copyright_contace'></form:input>
		</div>
		<form:errors path='copyright_contace' cssClass='text-danger'></form:errors>
		</div>
		<div class="mb-4">
			<form:label path='contact_email' class="form-label">Email</form:label>
		
		<div class="col-sm-3">
			<form:input type="text" class="form-control" path='contact_email'></form:input>
		</div>
		<form:errors path='contact_email' cssClass='text-danger'></form:errors>
		</div>
		<div class="mb-4">
			<input type="submit" value="EditAuthor" class="btn-btn-primary">
		</div>
	</form:form>
	</div>

</body>
</html>