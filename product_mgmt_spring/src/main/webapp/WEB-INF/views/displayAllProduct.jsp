<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<title>Display All</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
</head>

<body>
	<div class="jumbotron text-center">
		<h3>
			<spring:message code="welcome.springmvc" text="Welcome" />
		</h3>
		<h1 class="display-4">All Products</h1>
		<p class="lead">Here is the list of all products available in the
			store :</p>
		<hr class="my-4">
		<div class="container" style="width: 500px">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Product Name</th>
						<th scope="col">Product Cost</th>
					</tr>
				</thead>
				<c:forEach var="table" items="${products}">
					<tr>
						<td><c:out value="${table.productId}" /></td>
						<td><c:out value="${table.productName}" /></td>
						<td><c:out value="${table.productCost}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<a class="btn btn-primary" href="index.jsp" role="button">Home</a>

		<p>
			Change Language : <a href="?lang=en">English</a>|<a
				href="?lang=hi_IN">Hindi</a>
		</p>

	</div>
</body>

</html>
