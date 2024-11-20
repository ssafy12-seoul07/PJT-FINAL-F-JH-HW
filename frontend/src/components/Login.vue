<template>
  <div class="main-content">
    <div class="modal-content">
      <button class="close-btn" @click="$router.push('/')">×</button>

      <div class="form signup">
        <div class="form-header">Login</div>
        <div class="form-elements">
          <input type="text" placeholder="👤 Type your ID" aria-label="User ID" />
          <input type="password" placeholder="🔑 Type your Password" aria-label="Password" />
          <div class="form-element forgot-password">
            <p>Forgot password?</p>
          </div>
          <button id="submit-btn">LOGIN</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const username = ref('');
const password = ref('');
const errorMessage = ref('');
const router = useRouter();

const handleLogin = () => {
  // 예제: 간단한 유효성 검증
  if (username.value === 'user' && password.value === 'password') {
    // 로그인 성공 시 메인 페이지로 이동
    router.push('/mainPage');
  } else {
    // 로그인 실패 시 에러 메시지 표시
    errorMessage.value = 'Invalid username or password.';
  }
};
</script>

<style scoped>
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

.form .form-elements {
  margin-top: 10px;
}

.form .form-elements input {
  width: 100%;
  padding: 10px;
  font-size: 16px;
  margin: 10px 0;
  border-radius: 8px;
  border: 1px solid #444;
  background: #f9f9f9;
  box-sizing: border-box;
}

.form .form-elements button {
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
}

.form .form-elements button:hover {
  background: #6a994e;
}

.forgot-password {
  text-align: center;
  margin: 10px 0;
  font-size: 14px;
  color: #aaa;
  cursor: pointer;
}

.forgot-password:hover {
  text-decoration: underline;
}
</style>
