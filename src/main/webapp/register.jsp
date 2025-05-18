<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.exemple.model.*"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	response.sendRedirect("index.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<%@include file="/includes/head.jsp"%>
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Register</div>
			<div class="card-body">
				<form action="RegisterServlet" method="POST">
					<input type="hidden" name="action" value="register">

					<div class="form-group">
						<label>Login</label> <input type="text" name="login"
							class="form-control" required>
					</div>

					<div class="form-group">
						<label>Password</label> <input type="password" name="mdp"
							class="form-control" required>
					</div>

					<div class="form-group">
						<label>Confirm Password</label> <input type="password"
							name="confirm_mdp" class="form-control" required>
					</div>
					<div class="text-center mt-2">
						<input type="submit" name="ok" value="Register"
							class="btn btn-primary">
					</div>



					<div class="link">
						Already have an account ? <a href="login.jsp">Login</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@include file="/includes/footer.jsp"%>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
</body>
</html>
