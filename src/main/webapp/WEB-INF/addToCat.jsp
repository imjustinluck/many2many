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
			
			<h1><c:out value="${category.name }"></c:out></h1>
			<div style="display:flex">
				<div>
					<h3>Products</h3>
					<c:forEach items="${category.products }" var="p">
						<li>
						<c:out value="${p.name }"></c:out>
						</li>
					</c:forEach>
				</div>
				<div>
					<form action="/categories/${category.id }" method="POST">
						<h3>Add A Product:</h3>
						<select name="productId" >
							<c:forEach items="${products }" var="prod">
								<option value="${prod.id }">
								<c:out value="${prod.name }"></c:out>
								</option>
							</c:forEach>
						</select>
						<button>Submit</button>
					</form>
				</div>
			</div>
		</div>
	
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
	
</html>