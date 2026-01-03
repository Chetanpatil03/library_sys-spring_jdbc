package com.cb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cb.dao.BookDAO;
import com.cb.dao.TransactionDAO;
import com.cb.dao.UserDAO;

@Service
public class TransactionService {
	
	@Autowired
	private BookDAO bookdao;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired 
	public TransactionDAO trxdao;
	
	@Transactional
	public void issueBook() {
		
	}
	
	@Transactional
	public void returnBook() {
		
	}
	
	public void getTransactions() {
		
	}
	
	public void viewTransactionsByUser() {
		
	}
	
	public void viewTransactionsByBook() {
		
	}
	
	public boolean isAlreadyBorrowed(){
		return false;
	}
	
	public boolean isTransactionActive() {
		return true;
	}
}

/*
 * - Issue book to user
 * - Return book
 * Renew book
 * - Get all transactions
 * - Get transaction by ID
 * - Get active transactions
 * - Get transactions by user
 * - Get transactions by book
 * - Check if book is already issued to user
 * - Check if transaction is active
 */
