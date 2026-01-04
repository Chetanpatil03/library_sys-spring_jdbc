package com.cb.dao.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cb.bean.Book;
import com.cb.bean.Transaction;
import com.cb.bean.User;
import com.cb.dao.TransactionDAO;
import com.cb.mapper.TransactionRowMapper;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

	@Autowired
	JdbcTemplate template;

	@Override
	public Transaction getTransaction(int transaction_id) {
		String sql = "SELECT * FROM transactions WHERE transaction_id = ?";
		return template.queryForObject(sql, new TransactionRowMapper(),transaction_id);
	}

	@Override
	public List<Transaction> getAllTransactions() {
		String sql = "SELECT * FROM transactions";
		return template.query(sql, new TransactionRowMapper());
	}

	@Override
	public List<Transaction> getActiveTransactions() {
		String sql = "SELECT * FROM transactions where return_date IS NULL ";
		return template.query(sql, new TransactionRowMapper());
	}

	@Override
	public List<Transaction> getTransactionByUserID(int user_id) {
		String sql = "SELECT * FROM transactions WHERE user_id = ?";
		return template.query(sql, new TransactionRowMapper(),user_id);
	}

	@Override
	public List<Transaction> getTransactionByBookID(int book_id) {
		String sql = "SELECT * FROM transactions WHERE book_id = ?";
		return template.query(sql, new TransactionRowMapper(),book_id);
	}

	@Override
	public List<Transaction> getActiveTransactionsByUser(User user) {
		String sql = "SELECT * FROM transactions where return_date IS NULL and user_id = ?";
		return template.query(sql, new TransactionRowMapper(), user.getUser_id());
	}

	@Override
	public List<Transaction> getActiveTransactionsByBook(Book book) {
		String sql = "SELECT * FROM transactions where return_date IS NULL and book_id = ?";
		return template.query(sql, new TransactionRowMapper(), book.getId());
	}

	@Override
	public boolean isTransactionExist(int trx_id) {
		try {
			getTransaction(trx_id);
			return true;
		} catch (EmptyResultDataAccessException e) {
	        return false;
	    }
	}

	@Override
	public boolean isTransactionActive(Transaction transaction) {
		try {
	        String sql = "SELECT * FROM transactions WHERE return_date IS NULL AND transaction_id = ?";
	        template.queryForObject(sql, new TransactionRowMapper(),
	                transaction.getTransaction_id());
	        return true;
	    } catch (EmptyResultDataAccessException e) {
	        return false;
	    }
	}

	@Override
	public void issueBookTransaction(int user_id, int book_id) {
		String sql = "INSERT INTO transactions (user_id, book_id, issue_date) VALUES (?, ?, ?)";
		template.update(sql,user_id,book_id, Date.valueOf(LocalDate.now()));
	}

	@Override
	public void returnBookTransaction(int trx_id) {
		String sql = "UPDATE transactions SET return_date = ? WHERE transaction_id = ?";
		template.update(sql, Date.valueOf(LocalDate.now()), trx_id);
	}

}
