package com.cb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cb.bean.Book;

public class BookRowMapper implements RowMapper<Book>
{

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		
		book.setId(rs.getInt("book_id"));
		book.setTitle(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		book.setYear(rs.getInt("year"));
		book.setQty(rs.getInt("quantity"));
		
		return book;
	}
	
}
