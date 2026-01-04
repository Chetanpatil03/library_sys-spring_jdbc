package com.cb.main;

import java.util.Scanner;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cb.bean.Book;
import com.cb.bean.User;
import com.cb.resources.ConfigFile;
import com.cb.service.BookService;
import com.cb.service.TransactionService;
import com.cb.service.UserService;

public class App 
{
	public static Book getInpBook(Scanner sc) {
		Book book = new Book();
		System.out.println("Enter book details :: ");
		System.out.print("Enter Title :: ");
		book.setTitle(sc.nextLine());
		System.out.print("Enter Author :: ");
		book.setAuthor(sc.nextLine());
		System.out.print("Enter Year Published :: ");
		book.setYear(sc.nextInt());sc.nextLine();
		System.out.print("Enter Year Quantity :: ");
		book.setQty(sc.nextInt());
			
		return book;		
	}
	
	public static User getInpUser(Scanner sc) {
		User user = new User();
		
		System.out.print("Enter Name :: ");
		user.setName(sc.nextLine());
		System.out.print("Enter Email :: ");
		user.setEmail(sc.nextLine());
		System.out.print("Enter Phone :: ");
		user.setPhone(sc.nextLine());
		
		user.setStatus("ACTIVE");
		return user;
	}
	
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(ConfigFile.class);
    	
        Scanner sc = new Scanner(System.in);
        BookService bookService = context.getBean(BookService.class);
        UserService userService = context.getBean(UserService.class);
        TransactionService trxService = context.getBean(TransactionService.class);
        
        System.out.println("Welcome ---> ");
//        System.out.println("Add new Book ---> ");
//        bookService.addBook(getInpBook(sc));
        
//        bookService.viewBookById(1);
//        Book book = getInpBook(sc);
//        book.setId(1);
//        bookService.updateBook(book);
//        bookService.viewBookById(1);
        
//        bookService.viewAllBooks();
//        bookService.viewAvailableBooks();
//        bookService.v
        
//        userService.addUser(getInpUser(sc));
        
        trxService.issueBook(1, 1);
        
        
        
       
        
    }
}
