<template>
          
<div class="container">
<div class="row">
  <div class="card" style="width: 18rem;"
    v-for="(route, index) in routeList"
    :key="route.routeId"
    >
  <img src="..." class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">{{ route.district }}</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <div class="d-flex gap-2"> 
      <a href="#" class="btn btn-sm btn-primary" @click="goFormResult(route.routeId)">Go walk!</a>
      <a href="#" class="btn btn-sm btn-primary"  
      :class="route.isBookmarked ? 'btn-danger' : 'btn-primary'"
      @click="toggleBookmark(route)">{{ route.isBookmarked ? "Bookmarked" : "Bookmark" }}</a>
                </div>

  </div>
</div>
</div>
</div>

</template>

<script setup>
    import { useRouter } from 'vue-router';
    import { useFormStore } from '@/stores/form';
    import { useRouteStore } from '@/stores/route';
    import { onMounted, ref, defineEmits } from 'vue';
    import axios from 'axios';
    // Bootstrap의 모든 JavaScript 유틸리티 가져오기
    import * as bootstrap from "bootstrap";
    import "bootstrap/dist/css/bootstrap.min.css";
    import { storeToRefs } from 'pinia';


    const router = useRouter();
    const routeList = ref([]);
    const formStore = useFormStore();

    function goFormResult(routeId){
      formStore.setRouteId(routeId);

      axios
    .get(`http://localhost:8080/urs/location/${routeId}`)
    .then((response) => {
      console.log("Location Info:", response.data);
      formStore.locationInfo = response.data;

       // 폼 결과 페이지로 이동
      router.push("/form/result");
    })
    .catch((error) => {
      console.error("Failed to fetch location data:", error.message);
    });
    }
    
    function toggleBookmark(route) {
  // 북마크 상태를 반전시킴
  route.isBookmarked = !route.isBookmarked;

  // 추가적으로 북마크에 추가하는 메소드 실행 가능
  if (route.isBookmarked) {
    console.log(`Route ${route.routeId} bookmarked`);
    // 예: API 호출하여 북마크 추가
    axios.post(`http://localhost:8080/urs/bookmark/add/`);
  } else {
    console.log("hii");
  }
}
    onMounted(() => {
    const url = "http://localhost:8080/urs/route/all";

    axios({
    url,
    method: 'GET',
  }).then((response) => {
    console.log(response.data);
    routeList.value = response.data;
  });
})

</script>

<style  scoped>
.container {
  margin-top: 130px; /* 컨테이너의 위쪽 여백 설정 */
  overflow-y: auto;
}

.row {
  justify-content: center; /* Flexbox로 중앙 정렬 */
}


</style>