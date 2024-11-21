import { createRouter, createWebHistory } from 'vue-router'
import Kakaoview from '@/views/Kakaoview.vue'
import HomeView from '@/views/HomeView.vue'
import Kakaoview2 from '@/views/Kakaoview2.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home', 
      component:HomeView,
    },  
    {
      path: '/kakao',
      name: 'kakao',
      component: Kakaoview2,
    },
  
  ],
})

export default router
