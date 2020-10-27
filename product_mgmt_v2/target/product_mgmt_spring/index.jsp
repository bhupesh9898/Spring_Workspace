<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />

</head>
<body>


	<!-- NavBar -->

	<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
		<i id="child-icon" class="fas fa-child fa-3x  text-warning"></i>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active ml-3 font-weight-bold"><a
					class="nav-link" href="index.jsp">HOME</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle text-white bg-dark text-uppercase font-weight-bold"
					href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Menu </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a href="insert" class="list-group-item list-group-item-action">Insert
							Product</a> <a href="getOne"
							class="list-group-item list-group-item-action">Display
							Particular product</a> <a href="getAll"
							class="list-group-item list-group-item-action">Display All
							Product</a> <a href="delete"
							class="list-group-item list-group-item-action">Delete Product</a>
						<a href="update" class="list-group-item list-group-item-action">Update
							Product</a>
					</div></li>

				<li class="nav-item ml-2"><a
					class="nav-link text-white bg-dark text-uppercase font-weight-bold"
					href="#">Team</a></li>
				<li class="nav-item ml-2"><a
					class="nav-link text-white bg-dark text-uppercase font-weight-bold"
					href="#">Contact</a></li>
			</ul>
			<div class="input-group col-2">
				<input type="text" class="form-control" placeholder="Search">
				<div class="input-group-append">
					<button class="btn btn-secondary" type="button">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</div>
	</nav>




	<!-- Menu -->

	<div class="jumbotron text-center bg-info">

		<h1 class="display-2 text-warning"><strong class="text-white">Product Management </strong>Application</h1>
		<p class="lead text-white"><em>A product management web application project </em></p>
	</div>

	<h1 class="display-2 text-center text-warning">Menu</h1>
	<p class="lead text-secondary text-center mb-4">You can select any
		of the options below</p>

	<div class="container text-center mb-5" style="width: 45%">

		<div class="list-group">
			<a href="insert" class="list-group-item list-group-item-action">Insert
				Product</a> <a href="getOne"
				class="list-group-item list-group-item-action">Display
				Particular product</a> <a href="getAll"
				class="list-group-item list-group-item-action">Display All
				Product</a> <a href="delete"
				class="list-group-item list-group-item-action">Delete Product</a> <a
				href="update" class="list-group-item list-group-item-action">Update
				Product</a>
		</div>
	</div>




	<!-- Footer -->
	<div class="jumbotron jumbotron-fluid bg-secondary mt-5 text-white">

		<h1 class="display-4 text-center">Product Management Project</h1>
		<p class="lead text-center">
			<em>A Web Application Project based on Spring MVC Architecture</em>
		</p>
		<div class="row d-flex align-items-center justify-content-center">
			<i class="fab fa-facebook-square text-primary fa-2x ml-4"></i> <i
				class="fab fa-google-plus  text-danger fa-2x ml-4"></i> <i
				class="fab fa-twitter text-info fa-2x ml-4"></i> <i
				class="fab fa-youtube  text-danger fa-2x ml-4"></i>
		</div>
		<p class="text-center font-weight-light mt-2">-Made by Gourav
			Kaushal</p>
		<p class="text-center font-weight-light mt-2">
			Language : <a href="?language=en">English</a>|<a href="?language=hi">Hindi</a>
		</p>
	</div>




	<script src="https://kit.fontawesome.com/2d462425c0.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>