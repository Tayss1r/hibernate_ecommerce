package com.exemple.test;

import com.exemple.dao.UserDaoImpl;
import com.exemple.model.User;

import java.util.List;

public class TestUser {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        
        // Test save
        User user = userDao.save(new User("ahme", "dsq", "admin"));
        System.out.println("User saved: " + user);
        
        // Test findByLogin
        User foundUser = userDao.findByLogin("john");
        if (foundUser != null) {
            System.out.println("Found user: " + foundUser);
        } else {
            System.out.println("User not found");
        }
        
        // Test getAllUsers
        List<User> users = userDao.getAllUsers();
        System.out.println("All users:");
        for (User u : users) {
            System.out.println(u);
        }
    }
}
