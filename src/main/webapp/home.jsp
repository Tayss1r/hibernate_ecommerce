<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("person", auth);
}
boolean isAdmin = false;
if (auth != null && "admin".equals(auth.getRole())) {
	isAdmin = true;
}
List<Produit> produits = (List<Produit>) request.getAttribute("produits");
%>
<%@ page import="java.util.List"%>
<%@ page import="com.exemple.model.Produit"%>
<%@ page import="com.exemple.model.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>E-commerce</title>
<%@ include file="/includes/head.jsp"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="/includes/navbar.jsp"%>

	<div class="container mt-4">

		<%
		if (isAdmin) {
		%>

		<button type="button" class="btn btn-success mb-4"
			data-bs-toggle="modal" data-bs-target="#addProductModal">
			Add Product</button>


		<div class="modal fade" id="addProductModal" tabindex="-1"
			aria-labelledby="addProductModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="addProductModalLabel">Add a
							Product</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form action="AddProductServlet" method="post">
							<input type="hidden" name="action" value="addProduit" />
							<div class="mb-3">
								<label for="nom" class="form-label">Name</label> <input
									type="text" name="nom" class="form-control" required />
							</div>
							<div class="mb-3">
								<label for="prix" class="form-label">Price</label> <input
									type="text" name="prix" class="form-control" required />
							</div>
							<div class="mb-3">
								<label for="prix" class="form-label">Image</label> <input
									type="text" name="image" class="form-control" required />
							</div>
							<div class="mb-3">
								<label for="category" class="form-label">Category</label> <input
									type="text" name="category" class="form-control" required />
							</div>
							<button type="submit" class="btn btn-primary">Add
								Product</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<%
		}
		%>



		<%
		if (produits != null && !produits.isEmpty()) {
		%>

		<div class="container">
			<div class="card-header my-3">List of Products</div>
			<div class="row">
				<%
				for (Produit prod : produits) {
				%>
				<div class="col-md-3 my-3">
					<div class="card w-100">
						<img class="card-img-top" src="product-image/<%=prod.getImage()%>"
							alt="Image">
						<div class="card-body">
							<h5 class="card-title"><%=prod.getNomProduit()%></h5>
							<h6 class="price">
								Price:
								<%=prod.getPrix()%>
								dt
							</h6>
							<h6 class="price">
								Category:
								<%=prod.getCategory()%>
								
							</h6>
							<div class="mt-3 d-flex justify-content-between">
								<%
								if (isAdmin) {
								%>
								<div class="admin-controls">

									<button class="btn btn-warning btn-sm" data-bs-toggle="modal"
										data-bs-target="#editModal<%=prod.getIdProduit()%>">Update</button>


									<div class="modal fade" id="editModal<%=prod.getIdProduit()%>"
										tabindex="-1" aria-labelledby="editModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title">Update Product</h5>
													<button type="button" class="btn-close"
														data-bs-dismiss="modal"></button>
												</div>
												<div class="modal-body">
													<form action="UpdateProductServlet" method="post">
														<input type="hidden" name="action" value="update">
														<input type="hidden" name="id"
															value="<%=prod.getIdProduit()%>">
														<div class="mb-3">
															<label class="form-label">Name</label> <input type="text"
																name="nom" class="form-control"
																value="<%=prod.getNomProduit()%>" required>
														</div>
														<div class="mb-3">
															<label class="form-label">Price</label> <input
																type="number" name="prix" class="form-control"
																value="<%=prod.getPrix()%>" required>
														</div>
														<div class="mb-3">
															<label class="form-label">Image</label> <input
																type="text" name="image" class="form-control"
																value="<%=prod.getImage()%>" required>
														</div>
														<div class="mb-3">
															<label class="form-label">Category</label> <input
																type="text" name="category" class="form-control"
																value="<%=prod.getCategory()%>" required>
														</div>
														<button type="submit" class="btn btn-primary">Update</button>
													</form>
												</div>
											</div>
										</div>
									</div>

									<!-- Delete Form -->
									<form action="DeleteProductServlet" method="post"
										style="display: inline;">
										<input type="hidden" name="action" value="delete"> <input
											type="hidden" name="id" value="<%=prod.getIdProduit()%>">
										<button type="submit" class="btn btn-danger btn-sm"
											onclick="return confirm('Are you sure you want to delete this product ?');">Delete</button>
									</form>
								</div>

								<%
								}
								%>
							</div>
						</div>
					</div>
				</div>
				<%
				}
				%>
			</div>
		</div>

		<%
		} else {
		%>
		<p class="text-center mt-4">Nothing to show</p>
		<%
		}
		%>
		<%
		String msg = (String) request.getAttribute("message");
		if (msg != null) {
		%>
		<div class="alert alert-success"><%=msg%></div>
		<%
		}
		%>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>