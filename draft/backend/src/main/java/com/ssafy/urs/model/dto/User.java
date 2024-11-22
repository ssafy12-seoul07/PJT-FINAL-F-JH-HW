package com.ssafy.urs.model.dto;

public class User {
		private String userId;
		private String password;
		private String name;
		private String phone;
		
		// 기본 생성자
		public User() {};
		
		//생성자
		public User(String userId, String password, String name, String phone) {
			super();
			this.userId = userId;
			this.password = password;
			this.name = name;
			this.phone = phone;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		@Override
		public String toString() {
			return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", phone=" + phone + "]";
		}
		
		
		
	
}
