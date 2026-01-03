package com.cb.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cb.bean.User;
import com.cb.dao.UserDAO;
import com.cb.mapper.UserRowMapper;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	JdbcTemplate template;
	
	@Override
	public void addUser(User user) {
		String query = "insert into users(name, email, phone, status) values (?,?,?,?)";
		try {
			int count = template.update(query, 
					user.getName(),
					user.getEmail(),
					user.getPhone(),
					user.getStatus());
			
			if (count > 0) {
				System.out.println("Inserted => User");
			}else {
				System.out.println("Failed to => Insert");
			}
		}catch (Exception e) {
			System.out.println("Failed to => Insert");			
		}
		
	}

	@Override
	public void updateUser(User user) {
		String query = "update users set name = ?, email = ?, phone = ? , status = ? where user_id = ?";
		try {
			int count = template.update(query, 
					user.getName(),
					user.getEmail(),
					user.getPhone(),
					user.getStatus(),
					user.getUser_id());
			
			if (count > 0) {
				System.out.println("Updated => User");
			}else {
				System.out.println("Failed to => Update");
			}
		}catch (Exception e) {
			System.out.println("Failed to => Update");			
		}
	}

	@Override
	public void deleteUser(int user_id) {
		String query = "delete from users where user_id = ?";
		int count = template.update(query,user_id);
		if (count > 0) {
			System.out.println("Deleted => User");
		}else {
			System.out.println("Failed to => Delete");
		}
	}

	@Override
	public User getUser(int user_id) {
		String query = "select * from users where user_id = ?";
		return template.queryForObject(query, new UserRowMapper(),user_id);
	}

	@Override
	public boolean isUserExist(int user_id) {
		return getUser(user_id) == null;
	}

	@Override
	public List<User> getAllUsers() {
		String query = "select * from users";
		return template.query(query, new UserRowMapper());
	}

	@Override
	public List<User> getUsersbyName(String name) {
		String query = "select * from users where name = ?";
		return template.query(query, new UserRowMapper(),name);
	}

	@Override
	public List<User> getActiveUsers() {
		String query = "select * from users where status = 'active'";
		return template.query(query, new UserRowMapper());
	}

	@Override
	public List<User> getDeactiveUsers() {
		String query = "select * from users where status = null or status = 'deactive'";
		return template.query(query, new UserRowMapper());
	}

}
