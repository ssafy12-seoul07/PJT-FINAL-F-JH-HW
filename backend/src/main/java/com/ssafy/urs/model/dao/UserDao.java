package com.ssafy.urs.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.urs.model.dto.User;

@Mapper
public interface UserDao {
	int insertUser(User user);
	int deleteUser(String userId);
	User selectUserById(String userId);
	// int updateUser(User user)
}

	
