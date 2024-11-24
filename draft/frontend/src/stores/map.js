// import { ref, computed } from "vue";
// import { defineStore } from "pinia";
// import axios from "axios";
// import { useFormStore } from '../stores/form';


// const REST_API_URL = "http://localhost:8080/urs/";

// export const useMapStore = defineStore("map", () => {
//   const routeId = ref(null);
//   const locationList = ref([]); // 루트 목록을 스토어에서 관리하겠다.
//   const formStore = useFormStore();
  
//   //이제 routeID로 location데이터를 ㅏㄱ져오자
//   // const getLocationList = async function(routeId) {
//   //   try {
//   //     const response = await axios.get(`${REST_API_URL}location/${routeId}`);
//   //     // locationList.value = response.data;
//   //     console.log("location List updated:", response);
//   //   } catch (error) {
//   //     console.error("errorrrrr", error.message);
//   //   }
//   // };
//   const fetchLocation = async() => {
//     try{
//       console.log("이까지오나")
//       //getLocationById호출
//       const locationResponse = await axios.get(`${REST_API_URL}location/${store.routeId}`);
//       console.log("Location Response:", locationResponse.data);
//       locationData.value = locationResponse.data;
//       console.log(locationData.value)
//       const url = locationData.value.imgURL
//       console.log("확인")

//     } catch{
//       console.log("location failed");
//   }
//   };
//   return {locationList, LocationList, fetchLocation}
// }
 


// );
