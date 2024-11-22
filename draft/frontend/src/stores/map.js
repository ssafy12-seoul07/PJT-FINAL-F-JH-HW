import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

const REST_API_URL = "http://localhost:8080/urs/";

export const useMapStore = defineStore("map", () => {
  const routeId = ref(null);
  const locationList = ref([]); // 루트 목록을 스토어에서 관리하겠다.

  //이제 routeID로 location데이터를 ㅏㄱ져오자
  const getLocationList = async function(routeId) {
    try {
      const response = await axios.get(`${REST_API_URL}location/${routeId}`);

      locationList.value = response.data;
      console.log("location List updated:", locationList.value);
    } catch (error) {
      console.error("errorrrrr", error.message);
    }
  };

  const sendRouteId = async function(routeId) {
    const response = await axios.post(`${REST_API_URL}route`, { routeId });
  };
  return { locationList, getLocationList };
});
