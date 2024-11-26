<template>
  <div class="main-content">
    <!-- MODAL -->
    <div class="modal-content">

      <h1 class="title-content"> Hello {{ authStore.userId }}</h1>

      <!-- style="font-size: 30px; font-weight: bold; text-align: center; display: inline-block;" -->
      <!-- <span class="bottom-content" style="font-size: 30px; text-align:end; display: inline-block;">회원탈퇴</span> -->
      <!-- <button class="bottom-content" @click="deleteUser()">회원탈퇴</button> -->
       
      <!--start MyList-->
      <div class="list"> 
        <h2>Bookmark List</h2>
        <div class="card-container">
          <div class="card"
          v-for="(bookmark) in bookmarkList"
          :key="bookmark.routeId"
          >
          
          <img 
          :src="`http://localhost:8080/images/${bookmark.routeId}.jpg`" 
          :alt="`Route Image for ${bookmark.routeId}`"
          class="card-img-top"
          />
          <div class="card-body">
            {{ routeStore.routeList.find(item => item.routeId==bookmark.routeId).contentName }}          
            <button @click="deleteBookmark(bookmark.routeId)">unmark</button>
          </div>
        </div>
      </div>
      </div>
      <!-- end MyList -->
      
      <!--achieved--> 
      <div class="list"> 
        <h2>Achieved List</h2>
        <div class="card-container">
          <div class="card"
          v-for="(review) in reviewList"
          :key="review.routeId"
          >
          
          <img 
          :src="`http://localhost:8080/images/${review.routeId}.jpg`" 
          :alt="`Route Image for ${review.routeId}`"
          class="card-img-top"
          />
          <div class="card-body">
            {{ routeStore.routeList.find(item => item.routeId==review.routeId).contentName }}            
          </div>
        </div>
      </div>
      <!-- end MyList -->

    </div>
    
   </div>
  </div>
</template>

<script setup>
import { useAuthStore } from '@/stores/auth';
import { useLocationStore } from '@/stores/location';
import { useRouteStore } from '@/stores/route';
import { ref, onMounted, computed } from 'vue';
import axios from 'axios';
import router from '@/router';

const authStore = useAuthStore();
const locationStore = useLocationStore();
const routeStore = useRouteStore();
const bookmarkList=ref([]);
const reviewList=ref([]);

onMounted( async ()=> {
  await authStore.fetchBookmarks(authStore.userId);
  await authStore.fetchReviews(authStore.userId);
  await routeStore.fetchRoutes();
  bookmarkList.value = authStore.bookmarkList;
  reviewList.value = authStore.reviewList;
  console.log(reviewList.value)
  
})

  const deleteBookmark = async (routeId) => {
    try {
      const userId = authStore.userId; // Pinia state에서 userId 가져오기
      await axios.delete(`http://localhost:8080/urs/bookmark/${userId}/${routeId}`);
      authStore.bookmarkList = authStore.bookmarkList.filter(bookmark => bookmark.routeId !== routeId);
      bookmarkList.value = bookmarkList.value.filter(bookmark => bookmark.routeId !== routeId);
    } catch (error) {
      console.log("북마크삭제실패", error.response?.status, error.message)
    }
  }

// function deleteUser(userId){
//   if (confirm("정말로 이 사용자를 삭제하시겠습니까?")) {
//   try{
//     const userId = authStore.userId;
//     axios.delete(`http://localhost:8080/urs/user/delete/${userId}`);
//     router.push("/home");
//   } catch (error) {
//     console.error("유저삭제실패", error);
//     alert("사용자 삭제 중 오류가 발생했습니다. 다시 시도해주세요.");
//   }
// }
// }
</script>

<style scoped>


.main-content {
  position: relative;
  /* width: 100vw;
  height: 100vh; */
  display: flex;
  justify-content: center;
  align-items: center;
}

.title-content {
  font-weight: 700;
}

.list {
  margin: 1em 0;
  display: flex;
  flex-direction: column;
  justify-content: start;

  width: 100% !important;
}

.list > .card-container{
  margin: 3em 0;
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  justify-content: start;
  padding:5;
  gap:0.8rem;
}

.list .card {
  width: 10rem !important;
}

.list h2 {
  font-weight: 600;
}

.card-body{
  justify-content:end;
  padding: 0.5rem;
  position:relative;
  text-align: center;
  bottom:0;
  font-weight: 600  ;  
}
.card-body button {
  position:absolute;
  /* display: flex; */
  bottom: 0;
  cursor: pointer; /* 클릭 가능한 아이콘처럼 표시 */
  /* justify-content: center; */
  text-align: center;
  border: none;
  border-radius: 8px;
  background: #ffd500;
  font-size: 0.7em;
  right:0.3rem
}


/* 모달 */
.modal-content {
  position: fixed;
  top: 52%;
  transform: translateY(-50%);
  background: rgba(33, 33, 33, 0.95);
  border: 1px solid rgba(128, 128, 128, 0.4);
  border-radius: 1rem;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.8);
  width: 100%;
  height: 33em;
  width: 60em;
  padding: 5em 3em;

  text-align:left;
  animation: fadeIn 0.3s ease-out;
  
  color: rgba(255, 255, 255, 0.85);
  overflow-y: auto;
  overflow-x: auto;

}


</style>
