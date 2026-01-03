package com.cb.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cb.bean.Book;
import com.cb.dao.BookDAO;

@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void addBook(Book book) {
		String query = "insert into books(title, year, quantity,author) values (?,?,?,?)";
		try {
			int count = template.update(query, 
					book.getTitle(), 
					book.getYear(),
					book.getYear(),
					book.getAuthor());
				System.out.println((count) > 0 ? "Inserted => Book" : "Failed =>");
			
		} catch (UncategorizedSQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Failed =>");
		}
		
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(int book_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book getBook(int book_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBookByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAvailableBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateQuantity(int qty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void currentQuantity(int book_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isBooKExist(int book_id) {
		// TODO Auto-generated method stub
		return false;
	}

}
