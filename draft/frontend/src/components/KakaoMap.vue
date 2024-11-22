
<template>
  여러개를 .
  <KakaoMap 
  :lat="centerLat" 
  :lng="centerLng" 
  :level="6" @create="onMapCreate">
    <!-- 마커 3개 반복 생성-->
    <!-- 오버레이 3개 반복 생성 -->
  
    <KakaoMapCustomOverlay
    v-for="(coordinate, index) in locationList"
    :key="'overlay-'+ index"
    :lat="coordinate.lat"
    :lng="coordinate.lng"
      :content="coordinate.content"
      :yAnchor="2"
    >
    <button class ='overlay-content'
      v-for="(location, index) in locationList"
          :key="'locationName'+index"
          >
          {{ location.locationName }}
     </button>
    </KakaoMapCustomOverlay>

    <KakaoMapMarkerPolyline 
    :markerList="locationList"
    strokeWeight="15"
    strokeColor="#FFAE00"
    :strokeOpacity="0.7"
    :endArrow="true" 
    image="https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"
          
  
    />
    <KakaoMapMarker
      v-for="(coordinate, index) in locationList"
      :key="'marker-'+index"
      :lat="coordinate.lat"
      :lng="coordinate.lng"
      :image="{
        imageSrc:'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png',
        imageWidth:30,
        imageHeight:40,
        imageOption:{},
        zIndex: 5,
      }"
    />

  </KakaoMap>
  
</template>

<script>
import { useFormStore } from "@/stores/form";
import { useMapStore } from "@/stores/map";
import { onMounted, ref } from "vue";

import { 
  KakaoMap, 
  KakaoMapCustomOverlay, 
  KakaoMapMarker, 
  KakaoMapMarkerPolyline 
} from 'vue3-kakao-maps';
import { RouterLink } from "vue-router";


export default {
    components: {
      KakaoMapMarker,
      KakaoMap,
      KakaoMapCustomOverlay,
      KakaoMapMarkerPolyline,
      },

  setup(){
      const mapStore = useMapStore();

      // 초기값 설정
      const locationList = ref([]);
      const centerLat = ref(null);
      const centerLng = ref(null);
      const routeId = ref(null);
      const formStore = useFormStore();
      
      const fetchData = async()=>{
        try{
    console.log(formStore.routeId)
          await mapStore.getLocationList(formStore.routeId);
          locationList.value = mapStore.locationList;
          console.log("Fetched location data:", locationList.value);
      
      //center값 설정
      if(locationList.value.length>0){
        console.log(locationList.value)
        centerLat.value=locationList.value[1].lat;
        centerLng.value=locationList.value[1].lng;
      } else {
        console.log("route not reloaded");
      } 
    }catch (error){
        console.error("에러", error.message);
      }
    };
      // API 호출 후 데이터 처리 
      onMounted(async () => {
        await formStore.searchRouteId();
        await fetchData();
      });

    return {
      locationList, centerLat, centerLng, fetchData
    };
  },//setup 

};//export

</script>

<style scoped>
/* 오버레이 스타일 */
::v-deep(.overlay-content)
 {
  position: absolute;
  transform: translate(-50%, -200%); /* 마커 위 중앙 정렬 */
  border-radius: 6px;
  border: 1px solid #ccc;
  border-bottom: 2px solid #ddd;
  background: white;
  padding: 10px 15px;
  font-size: 14px;
  font-weight: bold;
  box-shadow: 0px 1px 2px #888;
  /* z-index: 100; 마커보다 위에 표시 */
}


</style>
