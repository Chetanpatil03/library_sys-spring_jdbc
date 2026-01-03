package com.cb.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cb.bean.Book;
import com.cb.dao.BookDAO;
import com.cb.dao.TransactionDAO;
import com.cb.dao.UserDAO;

@Service
public class BookService {

	@Autowired
	private BookDAO bookdao;

	
	public void addBook(Book book) {
		if (!(book.getQty() < 0)) {
			bookdao.addBook(book);
			return;
		}
		throw new RuntimeException("Book quantity can not negative");
	}

	public void updateBook(Book book) {
		if (!(book.getQty() < 0)) {
			bookdao.updateBook(book);
			return;
		}
		throw new RuntimeException("Book quantity can not negative");
	}

	public void removeBook() {

	}

	public void viewAllBooks() {
		List<Book> list = bookdao.getAllBooks();
		if (!list.isEmpty()) {
			System.out.println("All Books :: ");
			printBooks(list);
			return;
		}
		System.out.println("No books are present");
	}

	public void viewAvailableBooks() {
		List<Book> list = bookdao.getAvailableBooks();
		if (!list.isEmpty()) {
			System.out.println("All avilable books :: ");
			printBooks(list);
			return;
		}
		System.out.println("No Books are available");
	}

	public void viewBookById(int book_id) {
		Book book = bookdao.getBook(book_id);
		if (book != null) {
			System.out.println("Book information :: "+book_id);
			printBook(book);
			return;
		}
		System.out.println("Book is not present");
	}
	
	public Book getBook(int book_id) {
		Book book = bookdao.getBook(book_id);
		return book != null ? book : null;
	}

	public void viewBooksByTitle(String title) {
		List<Book> list = bookdao.getBookByTitle(title);
		if (!list.isEmpty()) {
			System.out.println("Books with the title :: "+title);
			printBooks(list);
			return;
		}
		System.out.println("Books are not present");
	}

	public void viewBookByAuthor(String author) {
		List<Book> list = bookdao.getBookByAuthor(author);
		if (!list.isEmpty()) {
			System.out.println("Books from the other :: "+author);
			printBooks(list);
			return;
		}
		System.out.println("Books from "+author+" are not present");
	}

	public static void printBooks(List<Book> list) {
		System.out.println("+---------+----------------------+--------+----------+-------------------+");
		System.out.println("| book_id | title                | year   | quantity | author            |");
		System.out.println("+---------+----------------------+--------+----------+-------------------+");

		for (Book book : list) {
			System.out.printf("| %-7d | %-20s | %-6d | %-8d | %-15s   |\n", book.getId(), book.getTitle(),
					book.getYear(), book.getQty(), book.getAuthor());
		}

		System.out.println("+---------+----------------------+--------+----------+-------------------+");
	}

	public static void printBook(Book book) {
			System.out.println("+---------+----------------------+--------+----------+-------------------+");
			System.out.println("| book_id | title                | year   | quantity | author            |");
			System.out.println("+---------+----------------------+--------+----------+-------------------+");
			
			System.out.printf("| %-7d | %-20s | %-6d | %-8d | %-15s   |\n",book.getId(),book.getTitle(), book.getYear(),book.getQty(),book.getAuthor());			
			
			System.out.println("+---------+----------------------+--------+----------+-------------------+");
		
	}
	
//	 ==> Methods 
	/*
	 * Add a new book to library Update book details Remove a book from library View
	 * all books View available books (quantity > 0) Find book by ID Find books by
	 * title Find books by author Increase book quantity Decrease book quantity
	 * Check book availability Check if book exists
	 */
}
