package com.ssafy.urs.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.urs.model.dto.User;


public interface UserService {
	boolean addUser(User user);
	boolean deleteUser(String userId);
	User selectUserById(String userId);
	
}
