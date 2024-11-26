
<template>
  여러개를 .
  <KakaoMap :lat="centerLat" :lng="centerLng" :level="6" @create="onMapCreate">
    <!-- 마커 3개 반복 생성-->
    <!-- 오버레이 3개 반복 생성 -->
    <KakaoMapCustomOverlay
    v-for="(overlay, index) in overlays"
    :key="'overlay-'+ index"
    :lat="overlay.lat"
    :lng="overlay.lng"
      :content="overlay.content"
      :yAnchor="2"
    />
    <!-- <KakaoMapMarkerPolyline
    :path="polylinePath"
    :strokeStyle="{
      strokeColor: '#FF0000',
        strokeWeight: 5,
        strokeOpacity: 0.8,
        strokeStyle: 'solid'
    }"
    /> -->
    <KakaoMapMarkerPolyline 
    :markerList="overlays"
    strokeWeight="15"
    strokeColor="#FFAE00"
    strokeOpacity:0.7
    :endArrow="true" 
    image="https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"
          
  
    />
    <KakaoMapMarker
      v-for="(overlay, index) in overlays"
      :key="'marker-'+index"
      :lat="overlay.lat"
      :lng="overlay.lng"
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
import {computed} from "vue";
import { 
  KakaoMap, 
  KakaoMapCustomOverlay, 
  KakaoMapMarker, 
  KakaoMapMarkerPolyline 
} from 'vue3-kakao-maps';


export default {
  components: {
    KakaoMapMarker,
    KakaoMap,
    KakaoMapCustomOverlay,
    KakaoMapMarkerPolyline,
  },

  data() {
    return {
      centerLat: 37.534961, // 지도 중심 좌표 이거는 이제 2번째경로(센터경로)좌표랑 같게 해야지
      centerLng: 126.98707,
      overlays: [
        {
          lat: 37.540163,
          lng: 127.001621,
          content:"<button class='overlay-content'>첫번째 콘텐츠</button>"
        },
        {
          lat: 37.534961,
          lng: 126.98707,
          content: "<button class='overlay-content'>두번째 콘텐츠</button>",
        },
        {
          lat: 37.527844,
          lng: 126.97039,
          content: "<button class='overlay-content'>세번째 콘텐츠</button>",
        },
      ],
    };
  },


  
};
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

/* ::v-deep(.overlay-btn) {
  display: block;
  text-decoration: none;
  color: #000;
  text-align: center;
  border-radius: 6px;
  font-size: 14px;
  font-weight: bold;
  overflow: hidden;
  background: #d95050;
  background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png)
    no-repeat right 14px center;
} */

</style>
