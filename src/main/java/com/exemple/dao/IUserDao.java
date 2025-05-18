package com.exemple.dao;

import java.util.List;

import com.exemple.model.User;

public interface IUserDao {
	public User save(User user);
    public User findByLogin(String login);
    public List<User> getAllUsers();
}
