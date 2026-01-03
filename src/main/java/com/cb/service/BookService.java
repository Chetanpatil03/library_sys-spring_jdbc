package com.cb.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cb.dao.BookDAO;
import com.cb.dao.TransactionDAO;
import com.cb.dao.UserDAO;

public class BookService {
	
	@Autowired
	private BookDAO bookdao;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired 
	public TransactionDAO trxdao;
	
	public void addBook() {
		
	}
	
	public void updateBook() {
		
	}
	
	public void removeBook() {
		
	}
	
	public void viewAllBooks() {
		
	}
	
	public void viewAvailableBooks() {
		
	}
	
	public void viewBookById() {
		
	}
	
	public void viewBooksByTitle() {
		
	}
	
	public void viewBookByAuthor() {

	}
//	 ==> Methods 
	/*
	 * Add a new book to library
	 * Update book details
	 * Remove a book from library
	 * View all books
	 * View available books (quantity > 0)
	 * Find book by ID
	 * Find books by title
	 * Find books by author
	 * Increase book quantity
	 * Decrease book quantity
	 * Check book availability
	 * Check if book exists
	 */
}
