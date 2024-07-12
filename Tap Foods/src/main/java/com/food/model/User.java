package com.food.model;

public class User {

	private int userId;
	private String username;
	private String password;
	private String email;
	private String address;
	private String role;
	
	public User() {
		
	}

	public User(String username, String password, String email, String address, String role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return userId +" "+ username +" "+ password +" "+ email +" "+ address +" "+ role;
	}
	
	
	
}
