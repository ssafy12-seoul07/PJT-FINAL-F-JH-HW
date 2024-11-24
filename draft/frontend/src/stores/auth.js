import { defineStore } from 'pinia';
import { ref } from 'vue';
const userId= ref(null);

export const useAuthStore = defineStore('auth', {
  state: () => ({
    isLoggedIn: true,
    userId:'hwlee333',
  }),
  actions: {
    login() {
      this.isLoggedIn = true;
    },
    logout() {
      this.isLoggedIn = false;
    },
  },
});
