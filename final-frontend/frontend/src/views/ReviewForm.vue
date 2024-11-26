<template>
  <div class="main-content">
    <div class="modal-content">
      <div class="review-container">
        <h2>리뷰 작성</h2>
        <div class="rating">
          <label for="rating">평점:</label>
          <select v-model="rating" id="rating">
            <option v-for="n in 5" :key="n" :value="n">{{ n }}점</option>
          </select>
        </div>
        <button @click="submitReview">리뷰 제출</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const rating = ref(1);

const submitReview = () => {
  if (rating.value) {
    alert(`평점 ${rating.value}점을 제출했습니다.`);
    // 여기에 백엔드 API로 평점 데이터를 전송하는 로직을 추가하세요.
  } else {
    alert('평점을 선택해주세요.');
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

.review-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

h2 {
  text-align: center;
}

.rating {
  margin: 15px 0;
  display: flex;
  align-items: center;
}

label {
  margin-right: 10px;
}

button {
  display: block;
  width: 100%;
  padding: 10px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>