package com.exemple.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomProduit;
	private double prix;
	private String image;
	private String category;

	public Produit() {
	}

	public Produit(String nomProduit, double prix, String img, String category) {
		this.nomProduit = nomProduit;
		this.prix = prix;
		this.image = img;
		this.setCategory(category);
	}

	// Getters et setters
	public int getId() {
		return id;
	}

	// For backward compatibility with JSP
	public int getIdProduit() {
		return id;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setIdProduit(int id) {
		this.id = id;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nomProduit=" + nomProduit + ", prix=" + prix + "]";
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
