<template>
  <div class="main-content">
    <div class="modal-content">
      <div>
        <h2>Selected Route</h2>
        <p>카카오api를 이용한 대략적인 경로 보여주기(핀 이용)</p>
        <p>찜 버튼</p>
        <p>경로 재탐색</p>
        <p></p>
        <!-- <p>{{ routeInfo }}</p> -->
      </div>
    </div>
  </div>
</template>

<script setup>
import { useFormStore } from '../stores/form';
import axios from 'axios';
import { onMounted } from 'vue';

const store = useFormStore();

console.log(store.selectedDistrict);
console.log(store.selectedStep1);
console.log(store.selectedStep2);

onMounted(async () => {
  if (!store.routeInfo) {
    const response = await axios.get(
      `/api/questions/route/${store.selectedStep1}/${store.selectedStep2}`
    );
    store.setRouteInfo(response.data);
  }
});
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

/* 모달 */
.modal-content {
  background: rgba(33, 33, 33, 0.95);
  border: 1px solid rgba(128, 128, 128, 0.4);
  border-radius: 1rem;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.8);
  width: 90%;
  max-width: 800px;
  max-height: 470px;
  padding: 20px;
  text-align: center;
  animation: fadeIn 0.3s ease-out;
  color: rgba(255, 255, 255, 0.85);
}
</style>