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

public class App {

	public static Book getInpBook(Scanner sc) {
		Book book = new Book();
		System.out.println("Enter book details :: ");
		System.out.print("Enter Title :: ");
		book.setTitle(sc.nextLine());
		System.out.print("Enter Author :: ");
		book.setAuthor(sc.nextLine());
		System.out.print("Enter Year Published :: ");
		book.setYear(sc.nextInt());
		sc.nextLine();
		System.out.print("Enter Quantity :: ");
		book.setQty(sc.nextInt());
		sc.nextLine();
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

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigFile.class);
		Scanner sc = new Scanner(System.in);

		BookService bookService = context.getBean(BookService.class);
		UserService userService = context.getBean(UserService.class);
		TransactionService trxService = context.getBean(TransactionService.class);

		int mainChoice = -1;

		while (mainChoice != 0) {
			System.out.println("\n===== MAIN MENU =====");
			System.out.println("1. Books");
			System.out.println("2. Users");
			System.out.println("3. Transactions");
			System.out.println("0. Exit");
			System.out.print("Enter your choice :: ");
			mainChoice = sc.nextInt();
			sc.nextLine();

			switch (mainChoice) {
			case 1:
				int bookChoice = -1;
				while (bookChoice != 0) {
					System.out.println("\n--- BOOK MENU ---");
					System.out.println("1. Add Book");
					System.out.println("2. Update Book");
					System.out.println("3. Remove Book");
					System.out.println("4. View All Books");
					System.out.println("5. View Available Books");
					System.out.println("6. View Book By ID");
					System.out.println("7. View Books By Title");
					System.out.println("8. View Books By Author");
					System.out.println("0. Back to Main Menu");
					System.out.print("Enter choice :: ");
					bookChoice = sc.nextInt();
					sc.nextLine();

					switch (bookChoice) {
					case 1:
						bookService.addBook(getInpBook(sc));
						break;
					case 2:
						System.out.print("Enter Book ID to update :: ");
						int bId = sc.nextInt();
						sc.nextLine();
						Book bookToUpdate = getInpBook(sc);
						bookToUpdate.setId(bId);
						bookService.updateBook(bookToUpdate);
						break;
					case 3:
						System.out.print("Enter Book ID to remove :: ");
						bookService.removeBook(sc.nextInt());
						sc.nextLine();
						break;
					case 4:
						bookService.viewAllBooks();
						break;
					case 5:
						bookService.viewAvailableBooks();
						break;
					case 6:
						System.out.print("Enter Book ID :: ");
						bookService.viewBookById(sc.nextInt());
						sc.nextLine();
						break;
					case 7:
						System.out.print("Enter Title :: ");
						bookService.viewBooksByTitle(sc.nextLine());
						break;
					case 8:
						System.out.print("Enter Author :: ");
						bookService.viewBookByAuthor(sc.nextLine());
						break;
					case 0:
						break;
					default:
						System.out.println("Invalid choice!");
					}
				}
				break;

			case 2:
				int userChoice = -1;
				while (userChoice != 0) {
					System.out.println("\n--- USER MENU ---");
					System.out.println("1. Add User");
					System.out.println("2. Update User");
					System.out.println("3. Remove User");
					System.out.println("4. View All Users");
					System.out.println("5. View User By ID");
					System.out.println("6. View Users By Name");
					System.out.println("7. Current Borrowed Books"); // <-- new option
					System.out.println("0. Back to Main Menu");
					System.out.print("Enter choice :: ");
					userChoice = sc.nextInt();
					sc.nextLine();

					switch (userChoice) {
					case 1:
						userService.addUser(getInpUser(sc));
						break;
					case 2:
						System.out.print("Enter User ID to update :: ");
						int uId = sc.nextInt();
						sc.nextLine();
						User userToUpdate = getInpUser(sc);
						userToUpdate.setUser_id(uId);
						userService.updateUser(userToUpdate);
						break;
					case 3:
						System.out.print("Enter User ID to remove :: ");
						userService.removeUser(sc.nextInt());
						sc.nextLine();
						break;
					case 4:
						userService.viewAllUser();
						break;
					case 5:
						System.out.print("Enter User ID :: ");
						userService.findUserByID(sc.nextInt());
						sc.nextLine();
						break;
					case 6:
						System.out.print("Enter User Name :: ");
						userService.findUsersByName(sc.nextLine());
						break;
					case 7:
						System.out.print("Enter User ID :: ");
						userService.currentBorrowedBooks(sc.nextInt());
						sc.nextLine();
						break;
					case 0:
						break;
					default:
						System.out.println("Invalid choice!");
					}
				}
				break;

			case 3:
				int trxChoice = -1;
				while (trxChoice != 0) {
					System.out.println("\n--- TRANSACTION MENU ---");
					System.out.println("1. Issue Book");
					System.out.println("2. Return Book");
					System.out.println("3. View All Transactions");
					System.out.println("4. View Transactions By User");
					System.out.println("5. View Transactions By Book");
					System.out.println("0. Back to Main Menu");
					System.out.print("Enter choice :: ");
					trxChoice = sc.nextInt();
					sc.nextLine();

					switch (trxChoice) {
					case 1:
						System.out.print("Enter User ID :: ");
						int iu = sc.nextInt();
						System.out.print("Enter Book ID :: ");
						int ib = sc.nextInt();
						sc.nextLine();
						trxService.issueBook(ib, iu);
						break;
					case 2:
						System.out.print("Enter Transaction ID :: ");
						trxService.returnBook(sc.nextInt());
						sc.nextLine();
						break;
					case 3:
						trxService.getTransactions();
						break;
					case 4:
						System.out.print("Enter User ID :: ");
						trxService.viewTransactionsByUser(sc.nextInt());
						sc.nextLine();
						break;
					case 5:
						System.out.print("Enter Book ID :: ");
						trxService.viewTransactionsByBook(sc.nextInt());
						sc.nextLine();
						break;
					case 0:
						break;
					default:
						System.out.println("Invalid choice!");
					}
				}
				break;

			case 0:
				System.out.println("Exiting... Goodbye!");
				break;

			default:
				System.out.println("Invalid choice! Try again.");
			}
		}

		sc.close();
	}
}
