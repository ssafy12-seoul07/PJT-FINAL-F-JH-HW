
<template>
  여러개를 .
  <KakaoMap :lat="centerLat" :lng="centerLng" :level="6" @create="onCreate">
    <!-- 마커 3개 반복 생성-->
    <KakaoMapMarker
      v-for="(overlay, index) in overlays"
      :key="'marker-'+index"
      :lat="overlay.lat"
      :lng="overlay.lng"
    />
    <!-- 오버레이 3개 반복 생성 -->
    <KakaoMapCustomOverlay
      v-for="(overlay, index) in overlays"
      :key="index"
      :lat="overlay.lat"
      :lng="overlay.lng"
      :content="overlay.content"
      :yAnchor="2"
    />
  </KakaoMap>
</template>

<script>
import { KakaoMap, KakaoMapCustomOverlay, KakaoMapMarker } from 'vue3-kakao-maps';

export default {
  components: {
    KakaoMapMarker,
    KakaoMap,
    KakaoMapCustomOverlay,
  },

  data() {
    return {
      centerLat: 37.534961, // 지도 중심 좌표 이거는 이제 2번째경로(센터경로)좌표랑 같게 해야지
      centerLng: 126.98707,
      overlays: [
        {
          lat: 37.540163,
          lng: 127.001621,
          content: '<div style="padding:10px; background:white; border:1px solid #ccc;">첫 번째 오버레이</div>',
        },
        {
          lat: 37.534961,
          lng: 126.98707,
          content: '<div style="padding:10px; background:white; border:1px solid #ccc;">두 번째 오버레이</div>',
        },
        {
          lat: 37.527844,
          lng: 126.97039,
          content: '<div style="padding:10px; background:white; border:1px solid #ccc;">세 번째 오버레이</div>',
        },
      ],
    };
  },

};
</script>
