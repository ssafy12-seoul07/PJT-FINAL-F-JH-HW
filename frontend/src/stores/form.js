import { defineStore } from 'pinia';

export const useFormStore = defineStore('form', {
  state: () => ({
    districtOptions: [
      '강남구', '강동구', '강북구', '강서구', '관악구', '광진구', '구로구', '금천구', '노원구', '도봉구', '동대문구', '동작구', '마포구', '서대문구',
      '서초구', '성동구', '성북구', '송파구', '양천구', '영등포구', '용산구', '은평구', '종로구', '중구', '중랑구',
    ],
    step1Options: ['DEMURE', 'CALMLY', 'LIVELY', 'ALONE'], // 1단계 옵션
    step2Options: [15, 25, 45],
    selectedDistrict: null,
    selectedStep1: null,
    selectedStep2: null,
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
  },
});
