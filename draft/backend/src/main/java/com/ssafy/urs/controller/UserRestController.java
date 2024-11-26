package com.ssafy.urs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.urs.model.dto.User;
import com.ssafy.urs.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/urs/user")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true") // 프론트엔드 도메인

public class UserRestController {
	
	@Autowired
	UserService us;
	
	//회원가입
	@PostMapping("/register")
	public ResponseEntity<String> addUser(@RequestBody User user){
		boolean result = us.addUser(user);
		if(result) {
			return new ResponseEntity<String>("user added successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failed to add user", HttpStatus.NOT_IMPLEMENTED);
		}
		
	}	
	
	//로그인 - 유저가 폼창에 아이디랑 비밀버호를 치면 
		// 그걸 request body로 가져와서, 근데 하나씨 가져오나 아니면 객체로 가져오나...
			// 하나씩 뜯어서 가져오기... 
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User loginUser){
		User member = us.selectUserById(loginUser.getUserId());
		if(member == null) {
			return new ResponseEntity<String>("no registered user", HttpStatus.NO_CONTENT);
		}
		else if(member!= null && loginUser.getPassword().equals(member.getPassword())) {//그럼 회원이라는 뜻이니까
			return new ResponseEntity<String>("login completed", HttpStatus.OK);
			} 

		return new ResponseEntity<String>("incorrect incorrect", HttpStatus.NOT_IMPLEMENTED);
	}
	
	
	//로그아웃
	@PostMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session){
		session.invalidate();
		return new ResponseEntity<String>("logout successfully", HttpStatus.OK);
	}
	
	//회원탈퇴
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId){
		if(us.deleteUser(userId)) {
			return new ResponseEntity<>("user deleted successfully", HttpStatus.OK);	
		} else {
			return new ResponseEntity<>("user deleted failed", HttpStatus.NOT_IMPLEMENTED);				
		}
	}
}
