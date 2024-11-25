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
      :disabled="route.isBookmarked" 
      @click="toggleBookmark(route)">
      {{ route.isBookmarked ? "Bookmarked" : "Bookmark" }}
      </a>
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
    import { useAuthStore } from '@/stores/auth';
    import { onMounted, ref, defineEmits } from 'vue';
    import axios from 'axios';
    // Bootstrap의 모든 JavaScript 유틸리티 가져오기
    import * as bootstrap from "bootstrap";
    import "bootstrap/dist/css/bootstrap.min.css";
    import { storeToRefs } from 'pinia';
    

    const AuthStore = useAuthStore();
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
      if(route.isBookmarked){
        return;
      }
      const bookmarkList = AuthStore.bookmarkList;
      const isBookmarked = bookmarkList.some(bookmark => bookmark.routeId===route.routeId);
    // // 추가적으로 북마크에 추가하는 메소드 실행 가능
    if (!isBookmarked) {
      // 예: API 호출하여 북마크 추가
      axios
      .post(`http://localhost:8080/urs/bookmark/add/${AuthStore.userId}/${route.routeId}`, {}
        
      )
      .then((response) => {
        bookmarkList.push({userId:AuthStore.userId, routeId: route.routeId}); // 새로운 북마크리스트를 보내야겠지
        route.isBookmarked = true;
        console.log(bookmarkList)
      })
      .catch((error) => console.error("북마크추가실패"));
    } else {
      console.log("hii");
    }
    // 그 북마크에 있으면 bookmarked로 하고
    // 없으면 북마크 추가하는 add book mark 버튼
  }

      
    onMounted(() => {
      const userId = AuthStore.userId; // AuthStore에서 userId 가져오기

// 전체 Route 리스트 가져오기
axios
  .get("http://localhost:8080/urs/route/all")
  .then((response) => {
    console.log("Routes fetched:", response.data);
    routeList.value = response.data; // 서버에서 가져온 Route 데이터를 routeList에 저장

    // AuthStore의 bookmarkList와 비교하여 각 Route의 isBookmarked 상태 설정
    const bookmarkList = AuthStore.bookmarkList;
    routeList.value.forEach((route) => {
      route.isBookmarked = bookmarkList.some(
        (bookmark) => bookmark.routeId === route.routeId
      );
    });
  })
  .catch((error) => console.error("Failed to fetch routes:", error));
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