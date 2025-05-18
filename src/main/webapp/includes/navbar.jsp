<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand fw-bold" href="Vue.jsp">7anout Dbach</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
			aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-end" id="navbarNav">
			<ul class="navbar-nav">

				<li class="nav-item mx-2">
					<form method="post" action="HomeServlet" class="m-0 p-0">
						<input type="hidden" name="action" value="home">
						<button type="submit" class="btn btn-link nav-link text-white fw-bold">Home</button>
					</form>
				</li>

				<% if (auth != null) { %>
				<li class="nav-item mx-2">
					<form method="post" action="LogoutServlet" class="m-0 p-0">
						<input type="hidden" name="action" value="logout">
						<button class="btn btn-outline-light fw-bold px-3" type="submit">Logout</button>
					</form>
				</li>
				<% } else { %>
				<li class="nav-item mx-2">
					<a class="btn btn-outline-light fw-bold px-3" href="login.jsp">Login</a>
				</li>
				<li class="nav-item mx-2">
					<a class="btn btn-outline-light fw-bold px-3" href="register.jsp">Register</a>
				</li>
				<% } %>

			</ul>
		</div>
	</div>
</nav>
