package com.exemple.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.exemple.model.User;

public class UserDaoImpl implements IUserDao {

    @Override
    public User save(User user) {
        // Crée la SessionFactory à partir du fichier hibernate.cfg.xml
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        // Ouvre une session Hibernate
        Session session = factory.getCurrentSession();
        try {
            // Commence une transaction
            session.beginTransaction();
            // Sauvegarde l'objet User en base
            session.save(user);
            // Commit de la transaction
            session.getTransaction().commit();
            System.out.println("✅ User enregistré !");
        } finally {
            factory.close();
        }
        return user;
    }

    @Override
    public User findByLogin(String login) {
        // Crée la SessionFactory à partir du fichier hibernate.cfg.xml
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        // Ouvre une session Hibernate
        Session session = factory.getCurrentSession();
        User user = null;
        try {
            // Commence une transaction
            session.beginTransaction();
            // Requête HQL pour récupérer l'utilisateur par son login
            Query<User> query = session.createQuery("from User where login = :login", User.class);
            query.setParameter("login", login);
            List<User> results = query.getResultList();
            if (!results.isEmpty()) {
                user = results.get(0); // Get the first user in case of multiple matches
            }
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        // Crée la SessionFactory à partir du fichier hibernate.cfg.xml
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        // Ouvre une session Hibernate
        Session session = factory.getCurrentSession();
        List<User> users = null;
        try {
            // Commence une transaction
            session.beginTransaction();
            // Requête HQL pour récupérer tous les utilisateurs
            users = session.createQuery("from User", User.class).getResultList();
            // Commit de la transaction
            session.getTransaction().commit();
            System.out.println("✅ Nombre d'utilisateurs récupérés : " + users.size());
        } finally {
            factory.close();
        }
        return users;
    }
}
