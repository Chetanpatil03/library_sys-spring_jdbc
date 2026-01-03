package com.cb.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cb.bean.Book;
import com.cb.dao.BookDAO;
import com.cb.mapper.BookRowMapper;

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
					book.getQty(),
					book.getAuthor());
				System.out.println((count) > 0 ? "Inserted => Book" : "Failed =>");
			
		} catch (UncategorizedSQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Failed =>");
		}
		
	}

	@Override
	public void updateBook(Book book) {
		String query = "update books set title = ?, year = ?, quantity = ?, author = ? where book_id = ?";
		try {
			int count = template.update(query, 
					book.getTitle(), 
					book.getYear(),
					book.getQty(),
					book.getAuthor(),
					book.getId()
					);
				System.out.println((count) > 0 ? "Updated => Book" : "Failed =>");
			
		} catch (UncategorizedSQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Failed =>");
		}
	}

	@Override
	public void deleteBook(int book_id){
		String query = "delete from books where book_id = ?";
		int count = template.update(query,book_id);
		System.out.println("Deletion => ");
		if (count > 0) {
			System.out.println("Success");
		}else {
			System.out.println("Failed");
		}
		
	}

	@Override
	public Book getBook(int book_id) {
		String query = "select * from books where book_id = ?";
		return template.queryForObject(query, new BookRowMapper(), book_id);
	}

	@Override
	public List<Book> getAllBooks() {
		String query = "select * from books";
		return template.query(query, new BookRowMapper());
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		String query = "select * from books where title = ?";
		return template.query(query, new BookRowMapper(), title);
	}

	@Override
	public List<Book> getBookByAuthor(String author) {
		String query = "select * from books where author = ?";
		return template.query(query, new BookRowMapper(), author);
	}

	@Override
	public List<Book> getAvailableBooks() {
		String query = "select * from books where quantity > 0";
		return template.query(query, new BookRowMapper());
	}

	@Override
	public void updateQuantity(int qty, int book_id) {
		String query = "update books set quantity = ? where book_id = ?";
		int count = template.update(query,qty,book_id);
		if (count > 0) {
			System.out.println("==> updated");
		}else {
			System.out.println("==> Failed");
		}
	}

	@Override
	public int currentQuantity(int book_id) {
		String sql = "SELECT quantity FROM book WHERE book_id = ?";
	    return template.queryForObject(sql, Integer.class, book_id);
	}

	@Override
	public boolean isBookExist(int book_id) {
		Book book = getBook(book_id);
		return book == null; 
	}

}
