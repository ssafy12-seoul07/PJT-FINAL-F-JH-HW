<template>
  <div class="main-content">
    
    <div class="modal-content">
       <span class="title-content" style="font-size: 30px; font-weight: bold; text-align: center; display: inline-block;"> Hello {{ id }}</span>
       <!-- <span class="bottom-content" style="font-size: 30px; text-align:end; display: inline-block;">회원탈퇴</span> -->
       <button class = 'bottom-content' @click="openURL()">회원탈퇴</button>
       <h2 style="font-size: 30px; font-weight: bold;"> Bookmark List </h2>
    <!--MyList-->
    <div> 
      <div class="card" style="width: 18rem;"
        v-for="(bookmark, index) in bookmarkList"
        :key="bookmark.routeId"
        
        >
        <img 
        :src="`http://localhost:8080/images/${bookmark.routeId}.png`" 
        :alt="`Route Image for ${bookmark.routeId}`"
        class="card-img-top"
        />
        <div class="card-body">
         <p class="card-text">Some quick example t</p>
         <button @click="deleteBookmark(bookmark.routeId)">북마크삭제</button>
        </div>
      </div>
    </div>
    <!--achieved-->
    <h2 style="font-size: 30px; font-weight: bold;"> Achieved List </h2>
    <div> 
      <div class="card" style="width: 18rem;"
        v-for="(bookmark, index) in bookmarkList"
        :key="bookmark.routeId"
        
        >
        <img 
        :src="`http://localhost:8080/images/${bookmark.routeId}.png`" 
        :alt="`Route Image for ${bookmark.routeId}`"
        class="card-img-top"
        />
        <div class="card-body">
         <p class="card-text">Some quick ex tent.</p>
         <button @click="deleteBookmark(bookmark.routeId)">리뷰보기</button>
        </div>
      </div>
    </div>
    
  </div>
  </div>
</template>

<script setup>
import { useAuthStore } from '@/stores/auth';
import { ref, onMounted } from 'vue';
import axios from 'axios';


const authStore = useAuthStore();
const userId = authStore.userId;
const bookmarkList=ref([]);

onMounted(  ()=> {
     const url="http://localhost:8080/urs/"

      axios({
        url: `${url}bookmark/${userId}`,
        method: 'GET',
      }).then((response) => {
        console.log(response.data);
        bookmarkList.value = response.data;
      });

      
  })

  const deleteBookmark = async (routeId) => {
    try {
      await axios.delete(`http://localhost:8080/urs/bookmark/${userId}/${routeId}`);
      bookmarkList.value = bookmarkList.value.filter(bookmark => bookmark.routeId !== routeId);
    } catch (error) {
      console.log("북마크삭제실패")
    }
  }

</script>

<style scoped>
.main-content {
  position: relative;
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
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
  height: 700px;
  width: 1500px;
  padding: 20px;
  text-align:left;
  animation: fadeIn 0.3s ease-out;
  color: rgba(255, 255, 255, 0.85);
}

.bottom-content {
  position: absolute; /* 모달 내부 절대 위치 */
  bottom: 16px; /* 모달의 하단에서 16px 위 */
  right: 50px; /* 모달의 오른쪽에서 16px 왼쪽 */
  font-size: 30px;
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
