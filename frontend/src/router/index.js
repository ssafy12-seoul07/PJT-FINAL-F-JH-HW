import { createRouter, createWebHistory } from 'vue-router'
import MainContent from '@/views/MainContent.vue';
import Login from '@/components/Login.vue';
import Signup from '@/components/Signup.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: MainContent,
      children: [
        {
          path: 'login',
          component: Login,
        },
        {
          path: 'signup',
          component: Signup,
        },
      ],
    },
  ],
})

export default router
