import { createRouter, createWebHistory } from 'vue-router'
import HomeContent from '@/views/HomeContent.vue';
import Login from '@/components/Login.vue';
import Signup from '@/components/Signup.vue';
import MainContent from '@/views/MainContent.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: HomeContent,
      component: HomeContent,
    },
    {
      path: '/login',
      name: Login,
      component: Login,
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
    // {
    //   path: "/route",
    //   name: "route",
    //   component: TmdbView,
    //   children: [
    //     {
    //       path: "popular",
    //       name: "tmdbPopular",
    //       component: TmdbPopular
    //     },
    //     {
    //       path: "toprated",
    //       name: "tmdbTopRated",
    //       component: TmdbTopRated
    //     }
    //   ]
    // }
  ],
})

export default router
