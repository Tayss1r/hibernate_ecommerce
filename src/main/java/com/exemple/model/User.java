package com.exemple.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String login;
	private String password;
	private String role;

	public User() {
		super();
	}

	public User(String login, String password) {
		this.password = password;
		this.login = login;
		this.role = "user";
	}

	public User(String login, String password, String role) {
		this.password = password;
		this.login = login;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// For backward compatibility
	public String getMotdepasse() {
		return password;
	}

	public void setMotdepasse(String motdepasse) {
		this.password = motdepasse;
	}

	public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", role=" + role + "]";
	}
}
