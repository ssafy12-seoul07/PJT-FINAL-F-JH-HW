import { defineStore } from "pinia";
import axios from "axios";

const REST_API_URL = "http://localhost:8080/urs/";

export const useFormStore = defineStore("form", {
  state: () => ({
    
    districtOptions: [
      "강남구",
      "강동구",
      "강북구",
      "강서구",
      "관악구",
      "광진구",
      "구로구",
      "금천구",
      "노원구",
      "도봉구",
      "동대문구",
      "동작구",
      "마포구",
      "서대문구",
      "서초구",
      "성동구",
      "성북구",
      "송파구",
      "양천구",
      "영등포구",
      "용산구",
      "은평구",
      "종로구",
      "중구",
      "중랑구"
    ],
    step1Options: ["DEMURE", "CALMLY", "LIVELY", "ALONE"], // 1단계 옵션
    step2Options: [15, 25, 45],
    selectedDistrict: null,
    selectedStep1: null,
    selectedStep2: null,
    routeId: null,
    locationInfo: [] // location 데이터를 저장할 속성 추가

  }),
  getters: {
    // filteredStep2Options: (state) => {
    //   return state.step2Options[state.selectedStep1] || [];
    // },
  },
  actions: {
    setDistrict(option) {
      this.selectedDistrict = option;
    },
    setStep1(option) {
      this.selectedStep1 = option;
    },
    setStep2(option) {
      this.selectedStep2 = option;
    },
    setRouteId(routeId){
      this.routeId=routeId;
    },

    async searchRouteId() {
      try {
        const response = await axios.get(
          `${REST_API_URL}route/${this.selectedDistrict}/${this.selectedStep1}/${this.selectedStep2}`
        );
        //getLocationById호출
        console.log("RouteID", response.data);
        console.log("이까지오나")
        const routeId = response.data
        this.setRouteId(routeId);
        const locationResponse = await axios.get(`${REST_API_URL}location/${routeId}`);
        const locationInfo = locationResponse.data
        this.locationInfo = locationResponse.data; // locationInfo를 state에 저장
        console.log(locationInfo) 
      } catch (error) { 
        console.error("울고싶네", error.message);
      }
    },

    // async searchLocation(){
    //   try{
    //     console.log("이까지오나")
    //     //getLocationById호출
    //     const locationResponse = await axios.get(`${REST_API_URL}location/${this.routeId}`);
    //     console.log("Location Response:", locationResponse.data);
    //     this.locationData = locationResponse.data;
    //     console.log(locationData.value)
    //     // const url = locationData.value.imgURL
    //     console.log("확인")
  
    //   } catch{
    //     console.log("location failed");
    // }
    // }
  }
});
