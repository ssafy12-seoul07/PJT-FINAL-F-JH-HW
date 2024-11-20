package com.ssafy.urs.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.urs.model.dao.UserDao;
import com.ssafy.urs.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	UserDao ud;

	@Override
	public boolean addUser(User user) {
		int result = ud.insertUser(user);
		return result > 0;
	}

	@Override
	public boolean deleteUser(String userId) {
		int result = ud.deleteUser(userId);
		return result > 0;
	}

	@Override
	public User selectUserById(String userId) {
		User user = ud.selectUserById(userId);
		return null;
	}
	
	
	
	
	
}
