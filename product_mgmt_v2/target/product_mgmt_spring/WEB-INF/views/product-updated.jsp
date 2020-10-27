<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />

</head>
<body>
	<div class="jumbotron text-center bg-info">
		<h1 class="display-1 text-warning"> ${msg} </h1>
	</div>
	<div class="jumbotron text-center">
		<h1 class="display-4">Updation Successfull</h1>
		<p class="lead">Product Updated successfully with product details


		
		<h2>
			Product Details </br> Id : ${product.productId}</br> Name :
			${product.productName}</br> Cost : ${product.productCost}
		</h2>
<a class="btn btn-primary" href="index.jsp" role="button">Home</a>

	</div>
</body>
</html>