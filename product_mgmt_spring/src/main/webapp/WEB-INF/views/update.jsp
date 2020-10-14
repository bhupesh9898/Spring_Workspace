<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Insert Product</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
</head>

<body>
	<form:form action="updateProduct" method="post" modelAttribute="product">

		<div class="form-group   p-3 mb-2 bg-info text-white">

			<div class="jumbotron text-center bg-info">
				<h2 class="display-1 text-warning">${msg}</h2>
			</div>
			</br>
			<h1 class="display-3 text-warning text-center mb-4">Update Page</h1>
			</br>
			<p>
				<form:errors path="product.*"></form:errors>
			</p>
			<div class="container" style="width: 35%;">


				<label for="productId" class="mt-2">Product ID</label>
				<form:input type="text" class="form-control" id="productId" placeholder="Enter Product ID"  path="productId"></form:input>
				<form:errors path="productId"></form:errors>
				<label for="productName" class="mt-2">Product Name</label>
				<form:input type="text" class="form-control" id="productName" placeholder="Enter Product Name" path="productName"></form:input>
				<form:errors path="productName"></form:errors>
				<label for="productCost" class="mt-2">Product Cost</label> 
				<form:input type="number" class="form-control" id="productCost" placeholder="Enter Product Cost" path="productCost"></form:input>
				<form:errors path="productCost"></form:errors>
				<div class="text-center mt-4">
					<button id="btn-insert" type="submit" class=" btn btn-success mr-3"
						style="width: 10rem;">Update</button>
					<a class="btn btn-primary" href="index.jsp" role="button">Home</a>
				</div>

			</div>
		</div>
	</form:form>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
</body>

</html>