package com.cb.dao;


import java.util.List;

import com.cb.bean.Book;
import com.cb.bean.Transaction;
import com.cb.bean.User;

public interface TransactionDAO {
//	--> CRUD ops on Transaction
	public void addTransaction(Transaction transaction);
	public void updateTransaction(Transaction transaction);
	public void deleteTransaction(int transaction_id);
	public Transaction getTransaction(int transaction_id);
	
	public List<Transaction> getAllTransactions();
	public List<Transaction> getAllActiveTransactions();

	public Transaction getTransactionByUserID(int user_id);
	public Transaction getTransactionByBookID(int book_id);
	
//	-- active transactions by book and user ==> 
	public List<Transaction> getActiveTransactionsByUser(User user);
	public List<Transaction> getActiveTransactionsByBook(Book book);
	
//	is exist and is active==>
	public boolean isTransactionExist(Transaction transaction);
	public boolean isTransactionActive(Transaction transaction);
	
	/*
	 * - Save new transaction (issue book)
	 * - Update transaction (return / renew)
	 * - Find transaction by ID
	 * - Find all transactions
	 * - Find active transactions
	 * - Find transactions by user ID
	 * - Find transactions by book ID
	 * - Find active transaction by user and book
	 * - Close transaction
	 * - Check if transaction exists
	 * - Check if transaction is active
	 */
}
