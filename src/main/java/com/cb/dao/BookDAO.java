package com.cb.dao;

import java.util.List;

import com.cb.bean.Book;

public interface BookDAO {
	// ==> CRUD ops
	public void addBook(Book book);

	public void updateBook(Book book);

	public void deleteBook(int book_id);

	public Book getBook(int book_id);

	public List<Book> getAllBooks();

// Find books by title
// Find books by author
// Find available books (qty > 0)
	public List<Book> getBookByTitle(String title);	
	public List<Book> getBookByAuthor(String author);
	public List<Book> getAvailableBooks();
	
	public void updateQuantity(int qty);
	public int currentQuantity(int book_id);
	
	public boolean isBookExist(int book_id);
	
	
	/*
	 * - Save a new book record
	 * - Update book record
	 * - Delete book by ID
	 * - Find book by ID
	 * - Find all books
	 * - Find available books (quantity > 0)
	 * - Find books by title
	 * - Find books by author
	 * - Update book quantity
	 * - Check if book exists by ID
	 * - Get current quantity of a book
	 */
}
