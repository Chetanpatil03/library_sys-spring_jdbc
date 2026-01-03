package com.cb.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cb.dao.BookDAO;
import com.cb.dao.TransactionDAO;
import com.cb.dao.UserDAO;

public class UserService {
	
	@Autowired
	private BookDAO bookdao;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired 
	public TransactionDAO trxdao;
	
	public void newUser() {
		
	}
	public void updateUser() {
		
	}
	
	public void removeUser() {
		
	}
	public void viewAllUser() {
		
	}
	public void findUserByID() {
		
	}
	public void findUserByName() {
		
	}
	public void isUserExist() {
		
	}
	
	public void currentBorrowedBooks() {
		
	}
	
	public void activeUsers() {
		
	}
	public void deactiveUsers() {
		
	}
}

/*
 * - Register new user
 * - Update user details
 * - Remove user
 * - View all users
 * - Find user by ID
 * - Find user by name
 * - Check if user exists
 * Check if user is allowed to borrow books
 * - Get number of books currently borrowed by user
 * - Activate user
 * - Deactivate user
 */