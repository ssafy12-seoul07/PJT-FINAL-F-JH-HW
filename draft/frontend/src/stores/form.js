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
    routeId: null
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
    async searchRouteId() {
      try {
        const response = await axios.get(
          `${REST_API_URL}route/${this.selectedDistrict}/${this
            .selectedStep1}/${this.selectedStep2}`
        );
        console.log("RouteID", response.data);
        this.routeId = response.data;
      } catch (error) {
        console.error("울고싶네", error.message);
      }
    }
  }
});
