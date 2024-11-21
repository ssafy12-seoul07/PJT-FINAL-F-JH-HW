import { createApp } from "vue";
import { createPinia } from "pinia";

import App from "./App.vue";
import router from "./router";
import { useKakao } from "vue3-kakao-maps/@utils";

const app = createApp(App);

useKakao("05a0b2e1278a2f4ddbfa4ed1b8990163");

app.use(createPinia());
app.use(router);

app.mount("#app");
