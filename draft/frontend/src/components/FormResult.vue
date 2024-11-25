<template>
  <div class="main-content">
    
    <div class="modal-content">
      <div class="map-container">
       <KakaoMap 
       v-if="store.locationInfo && Object.keys(store.locationInfo).length > 0"
      :location-data="store.locationInfo"/>
      </div>
    </div>
    <div class="modal-content2">
      <div>
        <span>selected Route</span> <br>
        <img 
        :src="`http://localhost:8080/posters/${store.routeId}.jpg`" 
        :als="`Route Image for ${store.routeId} `"
        :style="{ width: '200px', height: '280px',  }"/><br>
        <!-- <p>{{ routeInfo }}</p> -->
        <button class = 'button-content' @click="openURL()">
          산책 시작
        </button>
      </div>  
  </div>
</div>
  <!-- <RouterView/> -->
</template>

<script setup>
import KakaoMap from '@/components/KakaoMap.vue';
console.log('formresult page reloaded')
import { useFormStore } from '../stores/form';
import axios from 'axios';
import { onMounted, ref } from 'vue';

const store = useFormStore();
// const routeId = ref(null);
const locationData = ref([]);
const routeId = ref(null);
const routeURL = ref('');
// const locationList = ref([]);

// console.log(store.selectedDistrict);
// console.log(store.selectedStep1);
// console.log(store.selectedStep2);

function openURL() {
  // 카카오맵뷰에서 realCoordinate 에서 좌표 얻어오면됨
    window.open(); // 전달된 URL로 새 탭 열기
}

onMounted(async () => {
  
  try {
    await store.searchRouteId(); // Route ID와 Location 데이터 로드
    console.log("Route ID from store:", store.routeId);

    // // Location 데이터를 KakaoMap에 전달
    // locationData.value = store.locationInfo;
    // console.log("Location Data for KakaoMap:", locationData.value);
  } catch (error) {
    console.error("Error during map data initialization:", error.message);
  }
}
);

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
  position: fixed;
  top: 52%;
  left: 3%;
  transform: translateY(-50%);
  background: rgba(33, 33, 33, 0.95);
  border: 1px solid rgba(128, 128, 128, 0.4);
  border-radius: 1rem;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.8);
  width: 100%;
  height: 530px;
  width: 1100px;
  padding: 20px;
  text-align:left;
  animation: fadeIn 0.3s ease-out;
  color: rgba(255, 255, 255, 0.85);
}
.modal-content2 {
  position: fixed;
  top: 52%;
  right: 3%;
  justify-content: center;
  display : flex;
  transform: translateY(-50%);
  background: rgba(33, 33, 33, 0.95);
  border: 1px solid rgba(128, 128, 128, 0.4);
  border-radius: 1rem;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.8);
  width: 100%;
  height: 530px;
  width: 300px;
  /* padding: 20px; */
  text-align:center;
  text-align: bottom;
  animation: fadeIn 0.3s ease-out;
  color: rgba(255, 255, 255, 0.85);
  padding: 1rem;
}


.button-content {
  position:relative;
  min-width: 200px;
  height: 80px;
  font-size: 20px;
  font-weight: bold;
  border: 2px solid #e2dfd8;
  border-radius: 12px;
  background-color: #ffd000;
  color: #000000;
  cursor: pointer;
  transition: all 0.3s ease;
  justify-content: center;
  align-items: center;
}

.button-content:hover {
  background-color: #ffb703;
  color: #fff;
  transform: scale(1.05);
}

</style>