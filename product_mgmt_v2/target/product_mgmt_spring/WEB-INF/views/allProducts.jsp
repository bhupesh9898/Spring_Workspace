<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

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
		<p class="lead">Here is the list of all products available in the
			store :</p>
		<hr class="my-4">
		<div class="container" style="width: 600px">

			<div class="row row-cols-3">
				<c:forEach var="productName" items="${productNames}">
					<div class="col  border pt-1 pb-1">
						<a href="displayOneByName${productName}" class="h5"> 
						<c:out value="${productName}" />
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<a class="btn btn-primary" href="index.jsp" role="button">Home</a>
	</div>
</body>

</html>
