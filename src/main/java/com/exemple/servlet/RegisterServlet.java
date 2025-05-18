package com.exemple.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.exemple.dao.UserDaoImpl;
import com.exemple.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String password = request.getParameter("mdp");
		String confirmPassword = request.getParameter("confirm_mdp");

		if (password.equals(confirmPassword)) {
			User newUser = new User(login, password);
			UserDaoImpl userDao = new UserDaoImpl();
			userDao.save(newUser);

			request.setAttribute("message", "Account created !");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "Les mots de passe ne correspondent pas.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}
