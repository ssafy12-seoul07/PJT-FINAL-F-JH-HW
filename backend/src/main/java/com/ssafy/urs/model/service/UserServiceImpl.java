package com.ssafy.urs.model.service;

import com.ssafy.urs.model.dao.UserDao;
import com.ssafy.urs.model.dto.User;

public class UserServiceImpl implements UserService {
	
	private final UserDao ud;
	
	public UserServiceImpl(UserDao ud) {
		this.ud=ud;
	}

	@Override
	public boolean addUser(User user) {
		int result = ud.insertUser(user);
		return result > 0;
	}

	@Override
	public boolean deleteUser(int userId) {
		int result = ud.deleteUser(userId);
		return result > 0;
	}

	@Override
	public User selectUserById(int userId) {
		User user = ud.selectUserById(userId);
		return null;
	}
	
	
	
	
	
}
