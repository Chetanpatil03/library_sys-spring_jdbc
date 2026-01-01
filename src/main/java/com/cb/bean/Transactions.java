package com.cb.bean;

import java.time.LocalDateTime;

public class Transactions {
	private int transaction_id;
	private int user_id;
	private int book_id;
	private String issueDate;
	private String returnDate;

	public Transactions(int transaction_id, int user_id, int book_id, String issueDate, String returnDate) {
		this.transaction_id = transaction_id;
		this.user_id = user_id;
		this.book_id = book_id;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}
	
	
}
