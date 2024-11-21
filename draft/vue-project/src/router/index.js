import { createRouter, createWebHistory } from 'vue-router'
import Kakaoview from '@/views/Kakaoview.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/kakao', // 기본 경로를 /kakao로 리디렉션
    },  
    {
      path: '/kakao',
      name: 'kakao',
      component: Kakaoview,
    },
  
  ],
})

export default router
