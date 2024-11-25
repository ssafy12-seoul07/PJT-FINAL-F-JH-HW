// location불러와서 여기다가 저장을 하고 싶다
// axios 서버 요청 rest메ㅑ http://localhost:8080/urs/location/all

import axios from "axios";
import { defineStore } from "pinia";
import { ref } from "vue";

export const useLocationStore = defineStore("location", () => {
  const locationList = ref([]);
  const getLocationList = function() {
    axios
      .get(`http://localhost:8080/urs/location/all`)
      .then(resp => {
        locationList.value = resp.data;
      })
      .catch(error => {
        console.log("error다" + error);
      });
  };

  return { locationList, getLocationList };
});
