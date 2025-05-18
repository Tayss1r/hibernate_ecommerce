package com.exemple.test;

import com.exemple.dao.ProduitDaoImpl;
import com.exemple.model.Produit;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class TestProduit {
 public static void main(String[] args) {
	 ProduitDaoImpl pdao= new ProduitDaoImpl();
		Produit prod= pdao.save(new Produit("iphone 9 plus",2900,"test","shoes	"));
		System.out.println(prod);
 }
}
