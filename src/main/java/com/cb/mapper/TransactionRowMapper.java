package com.cb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cb.bean.Transaction;

public class TransactionRowMapper implements RowMapper<Transaction>
{

	@Override
	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		Transaction transactions = new Transaction();
		
		transactions.setTransaction_id(rs.getInt("transaction_id"));
		transactions.setUser_id(rs.getInt("user_id"));
		transactions.setBook_id(rs.getInt("book_id"));
		transactions.setIssueDate(rs.getDate("issue_date").toString());
		transactions.setReturnDate(rs.getDate("return_date").toString());
		
		return transactions;
	}
	
}
