package com.ssafy.urs.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.urs.model.dao.BookmarkDao;
import com.ssafy.urs.model.dao.UserDao;
import com.ssafy.urs.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	UserDao ud;
	BookmarkDao bd;

	@Override
	public boolean addUser(User user) {
		int result = ud.insertUser(user);
		return result > 0;
	}
	
	@Override
	public boolean deleteUser(String userId) {
	        // 트랜잭션 시작
	        int result = ud.deleteUser(userId); // user 테이블에서 삭제
	        return result > 0;// 삭제 성공 여부 확인

	}

	@Override
	public User selectUserById(String userId) {
		User user = ud.selectUserById(userId);
		return null;
	}
	
	
	
	
	
}
