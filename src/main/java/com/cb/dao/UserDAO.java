package com.cb.dao;

import java.util.List;

import com.cb.bean.User;

public interface UserDAO {
	
//	--> Basic CRUD ops
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int user_id);
	public User getUser(int user_id);

	public boolean isUserExist(int user_id);

	public List<User> getAllUsers();
	public List<User> getUsersbyName(String name);
	
	public List<User> getActiveUsers();
	public List<User> getDeactiveUsers();
	
	

	/*
	 * - Save new user
	 * - Update user details
	 * - Delete user by ID
	 * - Find user by ID
	 * - Find all users
	 * - Find users by name
	 * - Check if user exists by ID
	 * - Activate user
	 * - Deactivate user
	 */
}
