<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
    <%String login=(String)request.getAttribute("resultat"); %>
    <%@ page import="java.util.List" %>
<%@ page import="com.exemple.model.Produit" %>
<%@ page import="com.exemple.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JEE</title>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Produits</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 20px;
        }

        h1, h2, h3 {
            color: #333;
        }

        form {
            margin-bottom: 20px;
            background-color: #fff;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            width: fit-content;
        }

        input[type="text"],
        input[type="number"] {
            padding: 8px;
            margin: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 200px;
        }

        input[type="submit"] {
            background-color: #1976d2;
            color: white;
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin: 5px;
        }

        input[type="submit"]:hover {
            background-color: #125ea6;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #1976d2;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .actions form {
            display: inline-block;
        }

        .message {
            color: green;
            font-weight: bold;
        }
    </style>
</head>

</head>
<body>

	<h3>Hello <%=login%> from jsp<h3>
	<form action="controlleur" method="post">
    <input type="hidden" name="action" value="addProduit" />
    Nom: <input type="text" name="nom" required /><br />
    Prix: <input type="text" name="prix" required /><br />
    <input type="submit" value="Ajouter Produit" />
</form>
<%
    String msg = (String) request.getAttribute("message");
    if (msg != null) {
%>
    <p style="color:green;"><%= msg %></p>
<%
    }
    List<com.exemple.model.Produit> produits = (List<com.exemple.model.Produit>) request.getAttribute("produits");
    if (produits != null && !produits.isEmpty()) {
%>
    <h2>Liste des Produits</h2>
    <table border="1" cellpadding="8" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prix</th>
            <th>Actions</th>

        </tr>
        <% for (com.exemple.model.Produit prod : produits) { %>
        <tr>
    <td><%= prod.getIdProduit() %></td>
    <td><%= prod.getNomProduit() %></td>
    <td><%= prod.getPrix() %> </td>
    <td>

        <form action="controlleur" method="post" style="display:inline;">
            <input type="hidden" name="action" value="updateForm" />
            <input type="hidden" name="id" value="<%= prod.getIdProduit() %>" />
            <input type="submit" value="Modifier" />
        </form>


        <form action="controlleur" method="post" style="display:inline;">
            <input type="hidden" name="action" value="delete" />
            <input type="hidden" name="id" value="<%= prod.getIdProduit() %>" />
            <input type="submit" value="Supprimer" onclick="return confirm('Confirmer la suppression ?');"/>
        </form>
    </td>
</tr>

        <% } %>
    </table>
<% } else { %>
    <p>Aucun produit trouvé.</p>
<% } %>

<%
    Produit toEdit = (Produit) request.getAttribute("produitToEdit");
    if (toEdit != null) {
%>
    <h3>Modifier Produit</h3>
    <form action="controlleur" method="post">
        <input type="hidden" name="action" value="update" />
        <input type="hidden" name="id" value="<%= toEdit.getIdProduit() %>" />
        Nom: <input type="text" name="nom" value="<%= toEdit.getNomProduit() %>" required />
        Prix: <input type="text" name="prix" value="<%= toEdit.getPrix() %>" required />
        <input type="submit" value="Mettre à jour" />
    </form>
<%
    }
%>
<%
    List<User> users = (List<User>) request.getAttribute("users");
    if (users != null && !users.isEmpty()) {
%>
    <h2>Liste des Utilisateurs</h2>
    <div style="margin-top: 20px;">
        <table>
            <tr>
                <th>Login</th>
                <th>Role</th>
            </tr>
<%
        for (User u : users) {
%>
            <tr>
                <td><%= u.getLogin() %></td>
                <td><%= u.getRole() %></td>
            </tr>
<%
        }
%>
        </table>
    </div>
<%
    }
    else{
%>
<h1>No users found</h1>
<%
    }
%>




</body>
</html>