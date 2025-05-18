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
<title>Login</title>
<%@include file="/includes/head.jsp"%>
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Login</div>
			<div class="card-body">
				<%
				String message = (String) session.getAttribute("message");
				String messageType = (String) session.getAttribute("messageType");
				if (message != null) {
				%>
				<div
					class="alert alert-<%=messageType%> alert-dismissible fade show"
					role="alert">
					<%=message%>
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<%
				session.removeAttribute("message");
				session.removeAttribute("messageType");
				}
				%>

				<form action="LoginServlet" method="POST">
					<input type="hidden" name="action" value="login">
					<div class="form-group">
						<label>Login</label> <input type="text" name="login"
							class="form-control" required>
					</div>

					<div class="form-group">
						<label>Password</label> <input type="password" name="mdp"
							class="form-control" required>
					</div>

					<div class="text-center mt-2">
						<input type="submit" name="ok" value="Login"
							class="btn btn-primary">
					</div>
				</form>
				<div class="link">
					Don't have an account ? <a href="register.jsp">Register</a>
				</div>
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
