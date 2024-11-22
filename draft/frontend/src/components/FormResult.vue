<template>
  <div class="main-content">
    <div class="map-container">
     <KakaoMap :location-data="locationData"/>
    </div>

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
  
  <RouterView/>
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
// const locationList = ref([]);

console.log(store.selectedDistrict);
console.log(store.selectedStep1);
console.log(store.selectedStep2);

//백 요청해서 저장할거다


const fetchRouteAndLocation = async() => {
  try{
    const { selectedDistrict, selectedStep1, selectedStep2} = store;
  
    //getRouteByUser호출
    const routeResponse = await axios.get(
    `/urs/route/${selectedDistrict}/${selectedStep1}/${selectedStep2}`
  );
  routeId.value = routeResponse.data;

    //getLocationById호출
    const locationResponse = await axios.get(`/urs/location/${routeId.value}`);
    locationData.value = locationResponse.data;
  } catch (error){
    console.log("whyyy")
  }
};

onMounted(fetchRouteAndLocation);

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
  top: 50%;
  left: 3%;
  transform: translateY(-50%);
  background: rgba(33, 33, 33, 0.95);
  border: 1px solid rgba(128, 128, 128, 0.4);
  border-radius: 1rem;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.8);
  width: 100%;
  height: 550px;
  width: 1300px;
  padding: 20px;
  text-align: center;
  animation: fadeIn 0.3s ease-out;
  color: rgba(255, 255, 255, 0.85);
}
</style>