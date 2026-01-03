package com.cb.dao.impl;

import java.util.List;

import com.cb.bean.Book;
import com.cb.bean.Transaction;
import com.cb.bean.User;
import com.cb.dao.TransactionDAO;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public void addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTransaction(int transaction_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Transaction getTransaction(int transaction_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getAllActiveTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction getTransactionByUserID(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction getTransactionByBookID(int book_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getActiveTransactionsByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getActiveTransactionsByBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTransactionExist(Transaction transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTransactionActive(Transaction transaction) {
		// TODO Auto-generated method stub
		return false;
	}

}
