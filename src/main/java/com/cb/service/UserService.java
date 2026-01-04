package com.cb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cb.bean.User;
import com.cb.dao.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userdao;

	public void addUser(User user) {
		if (user != null) {
			userdao.addUser(user);
			return;
		}
		System.out.println("=> Can't add null user ");
	}

	public void updateUser(User user) {
		if (user != null) {
			userdao.updateUser(user);
			return;
		}
		System.out.println("=> Can't update null user ");
	}

	public void removeUser(int user_id) {
		userdao.deleteUser(user_id);
		return;
	}

	public void viewAllUser() {
		List<User> users = userdao.getAllUsers();
		System.out.println("All Users --->");
		printUsers(users);
		return;
	}

	public void findUserByID(int user_id) {
		User user = userdao.getUser(user_id);
		if (user != null) {
			System.out.println("User information :: "+user_id);
			printUser(user);
		}
		System.out.println("=> User not Found!");
	}

	public void findUsersByName(String name) {
		List<User> users = userdao.getUsersByName(name);
		if (! users.isEmpty()) {
			System.out.println("Users information :: "+name);
			printUsers(users);
		}
		System.out.println("=> Users with this "+name+" not Found!");
	}

	public void isUserExist(int user_id) {
		boolean isExists = userdao.isUserExist(user_id);
		System.out.println((isExists)?"User exist":"User does not exists");
	}

	public void currentBorrowedBooks(int user_id) {
		List<String> books = userdao.getCurrentBorrowedBooks(user_id);
		User user = userdao.getUser(user_id);
		
		if (!books.isEmpty()) {
			System.out.println("Books borrowed by user :: "+user.getName()+" [ "+user_id+"]");
			System.out.println("+---------+--------------------+");
			System.out.println("| Sr.No.  | Book name          |");
			System.out.println("+---------+--------------------+");
			
			for (int i = 0; i < books.size(); i++) {
				System.out.printf("| %-7d | %-18s |\n",i+1, books.get(i));
			}
			System.out.println("+---------+--------------------+");
			
			return;
		}
		
		System.out.println("There are no books borrowed by user :: "+user.getName()+" [ "+user_id+"]");
	}

	public void activeUsers() {
		List<User> users = userdao.getActiveUsers();
		System.out.println("Active Users --->");
		printUsers(users);
		return;
	}

	public void deactiveUsers() {
		List<User> users = userdao.getDeactiveUsers();
		System.out.println("Deactive Users --->");
		printUsers(users);
		return;
	}

	public void printUser(User user) {
		if (user == null)
			return;

		System.out.println("+---------+--------------------+--------------------+---------------+----------+");
		System.out.println("| user_id | name               | email              | phone         | status   |");
		System.out.println("+---------+--------------------+--------------------+---------------+----------+");
		System.out.printf("| %-7d | %-18s | %-18s | %-13s | %-8s |\n", 
				user.getUser_id(), user.getName(), user.getEmail(), user.getPhone(),user.getStatus());
		System.out.println("+---------+--------------------+--------------------+---------------+----------+");
	}
	
	public void printUsers(List<User> users) {
		if (users.isEmpty()) return;
		
		for(User user: users) {
			System.out.println("+---------+--------------------+--------------------+---------------+----------+");
			System.out.println("| user_id | name               | email              | phone         | status   |");
			System.out.println("+---------+--------------------+--------------------+---------------+----------+");
			System.out.printf("| %-7d | %-18s | %-18s | %-13s | %-8s |\n", 
					user.getUser_id(), user.getName(), user.getEmail(), user.getPhone(),user.getStatus());
			System.out.println("+---------+--------------------+--------------------+---------------+----------+");
		}
	}
}

/*
 * - Register new user - Update user details - Remove user - View all users -
 * Find user by ID - Find user by name - Check if user exists Check if user is
 * allowed to borrow books - Get number of books currently borrowed by user -
 * Activate user - Deactivate user
 */