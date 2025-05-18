package com.exemple.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.exemple.dao.ProduitDaoImpl;
import com.exemple.dao.UserDaoImpl;
import com.exemple.model.Produit;
import com.exemple.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
        String password = request.getParameter("mdp");

        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.findByLogin(login);
        ProduitDaoImpl dao = new ProduitDaoImpl();

        if (user != null && user.getPassword().equals(password)) {
        	request.getSession().setAttribute("auth", user);
            request.setAttribute("resultat", login);
            List<Produit> produits = dao.produitsParMC("");
            List<User> users = userDao.getAllUsers();
            request.setAttribute("users", users);
            request.setAttribute("produits", produits);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Invalid");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
	}

}
