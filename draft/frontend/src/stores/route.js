import { defineStore } from "pinia";
import { ref, onMounted } from 'vue';
import axios from "axios";

const REST_API_URL = "http://localhost:8080/urs/";

export const useRouteStore = defineStore("routeStore", ()=> {
    const routeList = ref([]);
    
    const fetchRoutes = async () => { // 데이터를 가져오는 함수
        try {
          const response = await axios.get(`${REST_API_URL}route/all`);
          routeList.value = response.data.results; // 상태 업데이트
          console.log("API Response:", response.data);
        } catch (error) {
          console.error("Error fetching route list:", error.message);
        }
        
        
    }
    return { 
        routeList, // 상태 반환
        fetchRoutes // 함수 반환
      };
})
