<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>Insert title here</title>
</head>

	<body>
		<div class="container">
			
			<h1>New Product!</h1>
			<div>
				<form:form action="/products/new" method="POST" modelAttribute="product">
				<p>
					<form:label path="name">Name: </form:label>
					<form:errors path="name" />
					<form:input path="name" />
				</p>
				<p>
					<form:label path="description">Description: </form:label>
					<form:errors path="description" />
					<form:textarea path="description" cols="30" rows="2" />
				</p>
				<p>
					<form:label path="price">Price: </form:label>
					<form:errors path="price" />
					<form:input path="price" />
				</p>
				<input type="submit" value="Create School" />
				</form:form>
			</div>
		</div>
	
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
	
</html>