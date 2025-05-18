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
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
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
		int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        double prix = Double.parseDouble(request.getParameter("prix"));
        String image = request.getParameter("image");
        String category = request.getParameter("category");

        Produit p = new Produit(nom, prix, image, category);
        p.setIdProduit(id);

        ProduitDaoImpl dao = new ProduitDaoImpl();
        dao.updateProduit(p);

        request.setAttribute("message", "Product has been updated successfully");
        List<Produit> produits = dao.produitsParMC("");
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> users = userDao.getAllUsers();
        request.setAttribute("users", users);
        request.setAttribute("produits", produits);
        request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
