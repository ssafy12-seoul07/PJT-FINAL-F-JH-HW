
  <template>
    <KakaoMap class = 'kakaomap'
    :lat="centerLat" 
    :lng="centerLng" 
    :width=1000
    :height:=520
    :level="6" 
    >
    
    <!-- 이제 배열을 만들어서 localist에서 좌표 6개 가져와서 저장 -->
    <KakaoMapCustomOverlay
    
      v-for="(spot, index) in coordinateList"
      :key="'overlay-'+ index"
      :lat="spot.lat"
      :lng="spot.lng"
        :content="spot.name"
        :yAnchor="2"
      >
      <button class ='overlay-content'>
            {{ spot.name }}
      </button>
      </KakaoMapCustomOverlay>

      <KakaoMapMarkerPolyline 
      :markerList="realCoordinateList"
      strokeWeight="15"
      strokeColor="#FFAE00"
      :strokeOpacity="0.7"
      :endArrow="true" 
            
    
      />
      <KakaoMapMarker
      v-for="(coordinate, index) in coordinateList"
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
      <!-- 카테고리 UI -->
      <div class="category-container">

        <button class="btn btn-outline-warning" @click="changeStart">시작지점바꾸기</button>
      </div>
    </KakaoMap>
    
    
  </template>

<script>
import { useFormStore } from "@/stores/form";
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
      
        // 초기값 설정
      const locationInfo = ref({});
      const centerLat = ref(null);
      const centerLng = ref(null);
      const routeId = ref(null);
      const formStore = useFormStore();
      const coordinateList = ref([]);
      const locationList = ref([]);
      const realCoordinateList = ref([]);

      const fetchData = async()=>{
        try{
          // console.log(formStore.routeId)
          locationInfo.value = formStore.locationInfo
          console.log("Fetched location data:", locationInfo.value);
          
          //center값 설정
      if(locationInfo.value){
        centerLat.value=locationInfo.value.centerLatitude;
        centerLng.value=locationInfo.value.centerLongitude;

        coordinateList.value = [
          {
            name :locationInfo.value.aname,
            lat:locationInfo.value.alatitude,
            lng :locationInfo.value.alongitude,
          },
          {
            
            name :locationInfo.value.cname,
            lat :locationInfo.value.centerLatitude,
            lng :locationInfo.value.centerLongitude,
          },
          {
            
            name :locationInfo.value.bname,
            lat :locationInfo.value.blatitude,
            lng :locationInfo.value.blongitude,
          }
        ]
        realCoordinateList.value=coordinateList.value
      } else {
        console.log("route not reloaded");
        console.log("error"+coordinateList.value)
      } 
    }catch (error){
      console.error("error", error.message);
    }
  };
  // //API 호출 후 데이터 처리 
  onMounted(async () => {
    try{
      // fetchData 호출로 locationInfo 처리
      await fetchData(); // fetchData에서 coordinateList와 centerLat/centerLng 설정
    } catch (error) {
      console.error("Error during initialization:", error.message);
    }
    // await formStore.searchRouteId();
  });
  
  function changeStart () {
    realCoordinateList.value = [...realCoordinateList.value].reverse();
    console.log(JSON.stringify(realCoordinateList.value))
  }

  return {
    locationList, centerLat, centerLng, fetchData, locationInfo, coordinateList, realCoordinateList, changeStart
  };

},//setup 

};//export

</script>

<style scoped>
/* 오버레이 스타일 */
.kakaomap{
  position:absolute;
  top:5%;
  left: 6%;
  transform: translateZ(-50%); /* 수직 중심 정렬 */
  z-index: 10; /* 모달보다 높은 레이어 지정 */
}
::v-deep(.overlay-content)
 {
  position: absolute;
  transform: translate(-50%, -250%); /* 마커 위 중앙 정렬 */
  border-radius: 6px;
  border: 1px solid #ccc;
  border-bottom: 2px solid #ddd;
  background: white;
  padding: 5px 10px;
  font-size: 12px;
  font-weight: bold;
  box-shadow: 0px 1px 2px #888;
}

/* 카테고리 UI */
.category-container {
  position: absolute; 
  top: 10px; /* 지도 상단에서 10px */
  left: 10px; /* 지도 왼쪽에서 10px */
  background: rgba(255, 255, 255, 0.9); /* 반투명 배경 */
  border: 1px solid #ccc;
  border-radius: 8px;
  padding: 쟈랴0px;
  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.3);
  z-index: 1000; 
}



.category-btn:hover {
  background-color: #ddd;
}

</style>
