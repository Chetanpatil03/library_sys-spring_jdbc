package com.cb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cb.bean.Transaction;
import com.cb.dao.BookDAO;
import com.cb.dao.TransactionDAO;
import com.cb.dao.UserDAO;

@Service
public class TransactionService {
	

	@Autowired
	public BookDAO bookdao;
	
	@Autowired
	public UserDAO userdao;
	
	@Autowired 
	public TransactionDAO trxdao;
	
	@Transactional
	public void issueBook(int book_id, int user_id) {
		if (bookdao.getBook(book_id) != null && userdao.getUser(user_id) != null) {
			trxdao.issueBookTransaction(user_id, book_id);
			System.out.println("=> Book issued ");
			return;
		}
		
		System.out.println("Book or User does'nt exists");
	}
	
	@Transactional
	public void returnBook(int trx_id) {
//		if (trxdao.isTransactionExist(trx_id)) {
//			trxdao.returnBookTransaction(trx_id);
//			System.out.println("=> Book returned");
//			return;n
//		}
//		System.out.println("-> Failed to returned");
		
		returnBook(trx_id);
	}
	
	public void getTransactions() {
		List<Transaction> list = trxdao.getAllTransactions();
		if (list.isEmpty()) {
			System.out.println("=> No Transactions");
		}
		
		
	}
	
	public void viewTransactionsByUser(int user_id) {
		
	}
	
	public void viewTransactionsByBook() {
		
	}
	
	public boolean isAlreadyBorrowed(){
		return false;
	}
	
	public boolean isTransactionActive() {
		return true;
	}
	
	public static void printTransaction(Transaction transaction) {
		
	}
}

/*
 * - Issue book to user
 * - Return book
 * Renew book
 * - Get all transactions
 * - Get transaction by ID
 * - Get active transactions
 * - Get transactions by user
 * - Get transactions by book
 * - Check if book is already issued to user
 * - Check if transaction is active
 */
