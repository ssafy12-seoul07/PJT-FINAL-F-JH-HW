package com.ssafy.urs.model.service;

import com.ssafy.urs.model.dto.User;

public interface UserService {
	boolean addUser(User user);
	boolean deleteUser(int userId);
	User selectUserById(int userId);
	
}
