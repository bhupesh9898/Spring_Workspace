<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Insert Product</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
</head>

<body>



	<form action="deleteProduct" name="form" method="post">

		<div class="form-group   p-3 mb-2 bg-info text-white">

			<div class="jumbotron text-center bg-info">
				<h2 class="display-1 text-warning">${msg}</h2>
			</div>
			</br>
			<h1 class="display-3 text-warning text-center mb-4">Delete Page</h1>
			</br>
			<div class="container" style="width: 35%;">


				<label for="productId" class="mt-2">Product ID</label>
				 <input type="number" class="form-control"
					id="productId" placeholder="Enter Product ID" name="id"> 

				<div class="text-center mt-4">
					<button id="btn-insert" type="submit" class=" btn btn-success mr-3"
						style="width: 10rem;">Delete</button>
					<a class="btn btn-primary" href="index.jsp" role="button">Home</a>
				</div>

			</div>
		</div>
	</form>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
</body>

</html>