<template>
  <div class="main-content">
    <div class="modal-content">
      <button class="close-btn" @click="$router.push('/')">×</button>

      <div class="form signup">
        <div class="form-header">Sign Up</div>
        <div class="form-elements">
          <div class="form-element">
            <label for="userID">ID</label>
            <input type="text" id="userID" v-model="userID" placeholder="👤 Create your ID" aria-label="User ID"
              required />
            <button class="check-btn" @click="checkDuplicateID">Check</button>
          </div>
          <div class="form-element">
            <label for="userPassword">Password</label>
            <input type="password" id="userPassword" v-model="password" placeholder="🔑 Create a password"
              aria-label="Password" required />
          </div>

          <!-- Confirm Password -->
          <div class="form-element">
            <label for="confirmPassword">Confirm Password</label>
            <input type="password" id="confirmPassword" v-model="confirmPassword" placeholder="🔑 Confirm your password"
              aria-label="Confirm Password" required />
          </div>

          <!-- 이름 입력 -->
          <div class="form-element">
            <label for="userName">Name</label>
            <input type="text" id="userName" v-model="name" placeholder="👤 Enter your name" aria-label="User Name"
              required />
          </div>

          <!-- 전화번호 입력 -->
          <div class="form-element">
            <label for="phoneNumber">Phone Number (010-456-7890)</label>
            <input type="tel" id="phoneNumber" v-model="phone" placeholder="📞 Enter your phone number"
              aria-label="Phone Number" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required />
          </div>

          <!-- Submit 버튼 -->
          <button id="submit-btn" @click="handleSubmit">SIGN UP</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";

// 상태 관리
const userID = ref("");
const password = ref("");
const confirmPassword = ref("");
const name = ref("");
const phone = ref("");

// ID 중복 확인
const checkDuplicateID = () => {
  // 예시: 서버와 통신하여 ID 중복 여부 확인
  if (userID.value === "existingID") {
    alert("This ID is already taken.");
  } else {
    alert("This ID is available.");
  }
};

// 폼 제출
const handleSubmit = () => {
  // 비밀번호 유효성 검사
  if (password.value.length < 8) {
    alert("Password must be at least 8 characters long.");
    return;
  }
  if (password.value !== confirmPassword.value) {
    alert("Passwords do not match.");
    return;
  }

  // 성공적으로 회원가입 처리
  alert(`Welcome, ${name.value}! Your account has been created.`);
  // 추가: 서버로 회원가입 요청 보내기
};
</script>


<style scoped>
.check-btn {
  position: absolute;
  margin-left: 380px;
  padding: 8px 12px;
  font-size: 14px;
  background-color: #ffb703;
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.check-btn:hover {
  background-color: #6a994e;
}

.main-content {
  position: relative;
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal-content {
  background: rgb(22, 22, 22);
  border: 0.0625rem solid rgba(128, 128, 128, 0.4);
  border-radius: 0.5rem;
  box-shadow: rgba(0, 0, 0, 0.8) 0px 0.25rem 0.5rem 0px;
  color: rgba(255, 255, 255, 0.7);
  width: 90%;
  max-width: 500px;
  padding: 20px;
  position: relative;
  text-align: center;
}

.close-btn {
  position: absolute;
  top: 15px;
  right: 15px;
  background: transparent;
  border: none;
  font-size: 25px;
  color: rgba(255, 255, 255, 0.8);
  cursor: pointer;
}

.form {
  text-align: center;
}

.form .form-header {
  font-size: 45px;
  font-weight: bold;
  margin-bottom: 50px;
}

.form-elements {
  margin-top: 10px;
}

.form-element {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin: 15px 0;
}

label {
  font-size: 16px;
  color: rgba(255, 255, 255, 0.8);
  margin-right: 10px;
  flex: 1;
  text-align: left;
}

input {
  flex: 2;
  padding: 10px;
  font-size: 16px;
  border-radius: 8px;
  border: 1px solid #444;
  background: #f9f9f9;
  box-sizing: border-box;
}

#submit-btn {
  width: 100%;
  padding: 12px;
  font-size: 16px;
  font-weight: bold;
  background: #ffb703;
  color: #fff;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background 0.3s ease;
  margin-top: 10px;
}

#submit-btn:hover {
  background: #6a994e;
}
</style>
