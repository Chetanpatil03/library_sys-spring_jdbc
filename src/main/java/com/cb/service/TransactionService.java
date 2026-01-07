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
@Transactional
public class TransactionService {

	@Autowired
	public BookDAO bookdao;

	@Autowired
	public UserDAO userdao;

	@Autowired
	public TransactionDAO trxdao;

	@Transactional
	public void issueBook(int book_id, int user_id) {
		if (bookdao.getBook(book_id) == null) {
			System.out.println("Book does not exist");
			return;
		}
		if (userdao.getUser(user_id) == null) {
			System.out.println("User does not exist");
			return;
		}

		if (bookdao.currentQuantity(book_id) == 0) {
			System.out.println("Book is not available,Book already issued to another users");
			return;
		}

		if (trxdao.isAlreadyBorrowed(book_id, user_id)) {
			System.out.println("Please return existing book first");
			return;
		}

		trxdao.issueBookTransaction(user_id, book_id);
		bookdao.updateQuantity(bookdao.currentQuantity(book_id) - 1, book_id);
		System.out.println("=> Book issued successfully");
	}

	@Transactional
	public void returnBook(int trx_id) {
		if (!trxdao.isTransactionExist(trx_id)) {
	        System.out.println("Transaction does not exist");
	        return;
	    }

	    int bookId = trxdao.getBookIdByTransaction(trx_id);
	    trxdao.returnBookTransaction(trx_id);
	    bookdao.updateQuantity(bookdao.currentQuantity(bookId) + 1, bookId);

	    System.out.println("=> Book returned successfully");
	}

	public void getTransactions() {
		List<Transaction> list = trxdao.getAllTransactions();
		if (list.isEmpty()) {
			System.out.println("=> No Transactions");
			return;
		}
		System.out.println("All transactions => ");
		printTransaction(list);
	}

	public void viewTransactionsByUser(int user_id) {
		List<Transaction> list = trxdao.getTransactionByUserID(user_id);
		if (list.isEmpty()) {
			System.out.println("=> No Transactions For [" + user_id + "]");
			return;
		}
		System.out.println("All transactions => [" + user_id + "]");
		printTransaction(list);
	}

	public void viewTransactionsByBook(int book_id) {
		List<Transaction> list = trxdao.getTransactionByBookID(book_id);
		if (list.isEmpty()) {
			System.out.println("=> No Transactions For [" + book_id + "]");
			return;
		}
		System.out.println("All transactions Book => [" + book_id + "]");
		printTransaction(list);
	}

	public boolean isAlreadyBorrowed(int book_id, int user_id) {
		boolean borrowed = trxdao.isAlreadyBorrowed(book_id, user_id);
		if (borrowed) {
			System.out.println("Please return existing book first");
			return true;
		}
		return false;
	}

	public boolean isTransactionActive(int trx_id) {
		return trxdao.isTransactionActive(trx_id);
	}

	public void printTransaction(Transaction transaction) {
		System.out.println("+----------------+----------+----------+-------------+-------------+");
		System.out.println("| transaction_id | user_id  | book_id  | issue_date  | return_date |");
		System.out.println("+----------------+----------+----------+-------------+-------------+");
		System.out.printf("| %-14d | %-8s | %-8d | %-11s | %-11s |\n", transaction.getTransaction_id(),
				transaction.getUser_id(), transaction.getBook_id(), transaction.getIssueDate(),
				transaction.getReturnDate());

		System.out.println("+----------------+----------+----------+-------------+-------------+");
	}

	public void printTransaction(List<Transaction> list) {
		System.out.println("+----------------+----------+----------+-------------+-------------+");
		System.out.println("| transaction_id | user_id  | book_id  | issue_date  | return_date |");
		System.out.println("+----------------+----------+----------+-------------+-------------+");

		for (Transaction trx : list) {
			System.out.printf("| %-14d | %-8s | %-8d | %-11s | %-11s |\n", trx.getTransaction_id(), trx.getUser_id(),
					trx.getBook_id(), trx.getIssueDate(), trx.getReturnDate());
		}

		System.out.println("+----------------+----------+----------+-------------+-------------+");

	}
}

/*
 * - Issue book to user - Return book Renew book - Get all transactions - Get
 * transaction by ID - Get active transactions - Get transactions by user - Get
 * transactions by book - Check if book is already issued to user - Check if
 * transaction is active
 */
