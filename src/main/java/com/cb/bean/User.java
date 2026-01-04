package com.cb.bean;

public class User {
	private int user_id;
	private String name;
	private String email;
	private String phone;
	private String status;
	
	public User() {}

	public User(String name, String email, String phone, String status) {	
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.status = status;
	}



	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
