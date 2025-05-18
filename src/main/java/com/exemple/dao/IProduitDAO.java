package com.exemple.dao;

import java.util.List;

import com.exemple.model.Produit;


public interface IProduitDAO {
	public Produit save(Produit p);
	public List<Produit> produitsParMC(String mc);
	public Produit getProduit(Long id);
	public Produit updateProduit(Produit p);
	public void deleteProduit(Long id);
}
