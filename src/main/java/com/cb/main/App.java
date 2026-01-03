package com.cb.main;

import java.util.Scanner;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cb.bean.Book;
import com.cb.resources.ConfigFile;
import com.cb.service.BookService;

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
	
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(ConfigFile.class);
    	
        Scanner sc = new Scanner(System.in);
        BookService service = context.getBean(BookService.class);
        
        System.out.println("Welcome ---> ");
//        System.out.println("Add new Book ---> ");
//        service.addBook(getInpBook(sc));
        
//        service.viewBookById(1);
//        Book book = getInpBook(sc);
//        book.setId(1);
//        service.updateBook(book);
//        service.viewBookById(1);
        
//        service.viewAllBooks();
        service.viewAvailableBooks();
//        service.v
       
        
    }
}
