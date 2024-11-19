package com.ssafy.urs.model.dao;


import com.ssafy.urs.model.dto.User;


public interface UserDao {
	int insertUser(User user);
	int deleteUser(int userId);
	User selectUserById(int userId);
	// int updateUser(User user)
}

	
