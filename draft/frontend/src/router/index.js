import { createRouter, createWebHistory } from 'vue-router'
import HomeContent from '@/views/HomeContent.vue';
import Login from '@/components/Login.vue';
import Signup from '@/components/Signup.vue';
import MainContent from '@/views/MainContent.vue';
import RouteForm from '@/views/RouteForm.vue';
import UserProfile from '@/views/MypageContent.vue';
import FormResult from '@/components/FormResult.vue';
import RoutePage from '@/components/RoutePage.vue';
import { KakaoMap } from 'vue3-kakao-maps';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'MainContent',
      component: MainContent,
    },
    {
      path: '/login',
      name: "Login",
      component: Login,
    },
    {
      path:'/routes',
      name: "Route",
      component :RoutePage,
    },
    {
      path: '/signup',
      name: Signup,
      component: Signup,
    },
    {
      path: '/home',
      name: MainContent,
      component: MainContent,
    },
    {
      path: '/form',
      name: RouteForm,
      component: RouteForm,
    },
    {
      path: '/mypage',
      name: UserProfile,
      component: UserProfile,
    },
    {
      path: '/form/result',
      name: FormResult,
      component: FormResult,
      children:[
        {path: 'kakao',
          name: 'kakao',
          component: KakaoMap,
        },
        
      ],
    
    },
  ],
});

export default router
