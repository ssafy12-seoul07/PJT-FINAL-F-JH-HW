<template>
  <div class="main-content">
    <!-- MODAL -->
    <div class="modal-content">

      <h1 class="title-content"> Hello {{ authStore.routeId }}</h1>

      <!-- style="font-size: 30px; font-weight: bold; text-align: center; display: inline-block;" -->
      <!-- <span class="bottom-content" style="font-size: 30px; text-align:end; display: inline-block;">회원탈퇴</span> -->
      <button class="bottom-content" @click="deleteUser()">회원탈퇴</button>
       
      <!--start MyList-->
      <div class="list"> 
        <h2>Bookmark Card</h2>
        <div class="card-container">
          <div class="card"
          v-for="(bookmark, index) in bookmarkList"
          :key="bookmark.routeId"
          >
          <img 
          :src="`http://localhost:8080/images/${bookmark.routeId}.jpg`" 
          :alt="`Route Image for ${bookmark.routeId}`"
          class="card-img-top"
          />
          <div class="card-body">
            <p class="card-text">Some quick example t</p>
            <button @click="deleteBookmark(bookmark.routeId)">북마크삭제</button>
          </div>
        </div>
      </div>
      <!-- end MyList -->
      
      <!--achieved--> 
      <div class="list"> 
        <h2>Achieved List</h2>
        <div class="card-container">
          <div class="card">
            <img src="" alt="test"/>
            <div class="card-body">
              <p class="card-text">Some quick ex tent.</p>
              <button >리뷰보기</button>
            </div>
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
import { ref, onMounted, computed } from 'vue';
import axios from 'axios';
import router from '@/router';


const authStore = useAuthStore();
const userId = computed(() => authStore.userId);
const bookmarkList=ref([]);


onMounted( async ()=> {
 await authStore.fetchBookmarks(authStore.userId);
 bookmarkList.value = authStore.bookmarkList;
})

  const deleteBookmark = async (routeId) => {
   
    try {
      await axios.delete(`http://localhost:8080/urs/bookmark/${userId}/${routeId}`);
      authStore.bookmarkList = authStore.bookmarkList.filter(bookmark => bookmark.routeId !== routeId);
      bookmarkList.value = bookmarkList.value.filter(bookmark => bookmark.routeId !== routeId);
    } catch (error) {
      console.log("북마크삭제실패")
    }
  }

function deleteUser(userId){
  if (confirm("정말로 이 사용자를 삭제하시겠습니까?")) {
  try{
    userId = authStore.userId;
    axios.delete(`http://localhost:8080/urs/user/delete/${userId}`);
    router.push("/home");
  } catch (error) {
    console.error("유저삭제실패", error);
    alert("사용자 삭제 중 오류가 발생했습니다. 다시 시도해주세요.");
  }
}
}
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
  margin: 2em 0;
  display: flex;
  flex-direction: column;
  justify-content: start;

  width: 100% !important;
}

.list > .card-container{
  margin: 2em 0;
  display: flex;
  flex-direction: row;
  justify-content: start;
  padding:3;
}

.list .card {
  width: 18rem !important;
  margin: 1em;
}

.list h2 {
  font-weight: 600;
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
  height: 40em;
  width: 50em;
  padding: 5em 3em;

  text-align:left;
  animation: fadeIn 0.3s ease-out;

  color: rgba(255, 255, 255, 0.85);
  overflow-y: auto;
  overflow-x: auto;

}

.bottom-content {
  position: fixed; /* 모달 내부 절대 위치 */
  top: 16px; /* 모달의 하단에서 16px 위 */
  right: 50px; /* 모달의 오른쪽에서 16px 왼쪽 */
  font-size: 0.7em;
  text-align: end; /* 텍스트를 오른쪽 정렬 */
  color: rgb(0, 0, 0); /* 텍스트 색상 */
  cursor: pointer; /* 클릭 가능한 아이콘처럼 표시 */
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: bold;
  background: #d51414;
  color: #fff;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background 0.3s ease
}





</style>
