<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="cyber.java.jsp.model.Product"%>
<%@ page import="cyber.java.jsp.util.UrlUtils"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product</title>
<link rel="stylesheet" href="styles.css">
<link rel="shortcut icon" href="visual.ico" type="image/x-icon">
<!-- Bootstrp CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="container-fluid">
	<h1 class="fw-light fst-italic text-center m-4">
		<i class="fa fa-user p-1" aria-hidden="true"></i> Product Management
	</h1>



	<table class="table fst-italic $line-height-sm table-dark table-striped">
		<thead class="table-dark ">
			<tr>
				<th>No.</th>
				<th>Code</th>
				<th>Name</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Function</th>
			</tr>

		</thead>
		<tbody>
			<c:forEach var="product" varStatus="loop" items="${products}">
				<tr>
					<td>${loop.count }</td>
					<td>${product.code }</td>
					<td>${product.name }</td>
					<td>${product.quantity }</td>
					<td>${product.price }</td>

					<td><a
						href="<%=request.getContextPath() + UrlUtils.PRODUCT_DELETE %>?code=${product.code}"
						class="btn btn-sm btn-outline-success text-danger"> <i
							class="fa fa-trash" aria-hidden="true"></i>
					</a> <a
						href="<%=request.getContextPath() + UrlUtils.PRODUCT_UPDATE %>?code=${product.code}"
						class="btn btn-sm btn-outline-success danger text-sucess"> <i
							class="fa fa-wrench" aria-hidden="true"></i>
					</a></td>

				</tr>
			</c:forEach>

		</tbody>
	</table>

	<a class="btn btn-secondary text-white p-1 mb-1 ">Home-Page </a>
	<a href="<%=request.getContextPath() + UrlUtils.PRODUCT_ADD%>"
		class="btn btn-secondary text-white p-1 mb-1">Add new Product </a>
		

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>