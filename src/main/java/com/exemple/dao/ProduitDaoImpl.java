package com.exemple.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.exemple.model.Produit;

public class ProduitDaoImpl implements IProduitDAO{

	@Override
	public Produit save(Produit p) {
		// Crée la SessionFactory à partir du fichier hibernate.cfg.xml
		 SessionFactory factory = new Configuration()
		 .configure("hibernate.cfg.xml")
		 .addAnnotatedClass(Produit.class)
		 .buildSessionFactory();
		 // Ouvre une session Hibernate
		 Session session = factory.getCurrentSession();
		 try {
		 // Commence une transaction
		session.beginTransaction();
		// Sauvegarde l’objet en base
		 session.save(p);
		// Commit de la transaction
		 session.getTransaction().commit();
		 System.out.println("Produit enregistré !");
		 } finally {
		 factory.close();
		 }
		 return p;
	}

	@Override
	public List<Produit> produitsParMC(String mc) {
		// Crée la SessionFactory à partir du fichier hibernate.cfg.xml
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Produit.class)
			.buildSessionFactory();
		// Ouvre une session Hibernate
		Session session = factory.getCurrentSession();
		List<Produit> produits = null;
		try {
			// Commence une transaction
			session.beginTransaction();
			// Requête HQL pour récupérer tous les produits ou filtrer par mot clé
			if (mc != null && !mc.isEmpty()) {
				produits = session.createQuery("from Produit where nomProduit like :x", Produit.class)
					.setParameter("x", "%" + mc + "%")
					.getResultList();
			} else {
				produits = session.createQuery("from Produit", Produit.class).getResultList();
			}
			// Commit de la transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		return produits;
	}

	@Override
	public Produit getProduit(Long id) {
		// Crée la SessionFactory à partir du fichier hibernate.cfg.xml
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Produit.class)
			.buildSessionFactory();
		// Ouvre une session Hibernate
		Session session = factory.getCurrentSession();
		Produit produit = null;
		try {
			// Commence une transaction
			session.beginTransaction();
			// Récupère le produit par son ID
			produit = session.get(Produit.class, id.intValue());
			// Commit de la transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		return produit;
	}

	@Override
	public Produit updateProduit(Produit p) {
		// Crée la SessionFactory à partir du fichier hibernate.cfg.xml
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Produit.class)
			.buildSessionFactory();
		// Ouvre une session Hibernate
		Session session = factory.getCurrentSession();
		try {
			// Commence une transaction
			session.beginTransaction();
			// Met à jour le produit
			session.update(p);
			// Commit de la transaction
			session.getTransaction().commit();
			System.out.println("Produit mis à jour !");
		} finally {
			factory.close();
		}
		return p;
	}

	@Override
	public void deleteProduit(Long id) {
		// Crée la SessionFactory à partir du fichier hibernate.cfg.xml
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Produit.class)
			.buildSessionFactory();
		// Ouvre une session Hibernate
		Session session = factory.getCurrentSession();
		try {
			// Commence une transaction
			session.beginTransaction();
			// Récupère le produit à supprimer
			Produit produit = session.get(Produit.class, id.intValue());
			if (produit != null) {
				// Supprime le produit
				session.delete(produit);
				System.out.println("Produit supprimé !");
			}
			// Commit de la transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}


}
