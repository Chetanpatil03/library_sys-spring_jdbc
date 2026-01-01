package com.cb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cb.bean.User;

public class UserRowMapper implements RowMapper<User>
{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		
		user.setUser_id(rs.getInt("user_id"));
		user.setName(rs.getString("name"));
		user.setName(rs.getString("email"));
		user.setPhone(rs.getInt("phone"));
		user.setStatus(rs.getString("status"));
		
		return null;
	}
	
}
