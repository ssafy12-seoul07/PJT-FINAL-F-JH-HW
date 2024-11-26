import { defineStore } from "pinia";
import { ref } from "vue";
import axios from "axios";

export const useAuthStore = defineStore("auth", {
  state: () => ({
    isLoggedIn: true,
    userId: 'hwlee333',
    bookmarkList: []
  }),
  actions: {
    login() {
      this.isLoggedIn = true;
    },
    logout() {
      this.isLoggedIn = false;
    },
    async fetchBookmarks(userId) {
      try {
        const response = await axios.get(
          `http://localhost:8080/urs/bookmark/${userId}`
        );
        this.bookmarkList = response.data;
      } catch (error) {
        console.error("로그인 후 북마크 가져오는 중 에러발생", error);
      }
    },
    async fetchReviews(userId){
      try{
        const response = await axios.get(
          `http://localhost:8080/urs/review/all/${userId}`
        );
        this.reviewList = response.data;
      } catch (error){
        console.error("리뷰목록 가져오는 중 오류발생",error);
      }
    },
    async deleteBookmark(routeId) {
      try {
        const userId = this.userId;
        await axios.delete(
          `http://localhost:8080/urs/bookmark/${userId}/${routeId}`
        );
        this.bookmarkList = this.bookmarkList.filter(
          // 지울 routeId가 아닌 것들만 북마크에 두겠다.
          bookmark => bookmark.routeId !== routeId
        );
        console.log(`Deleting bookmark for userId: ${userId}, routeId: ${routeId}`);

      } catch (error) {
        console.error("북마크 삭제중에 에러발생");
      }
    }
  }
});
