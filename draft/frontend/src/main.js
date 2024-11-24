import "./assets/css/style.css";

import { createApp } from "vue";
import { createPinia } from "pinia";
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.min.js"
import "bootstrap-icons/font/bootstrap-icons.css"
// Bootstrap의 모든 JavaScript 유틸리티 가져오기
import * as bootstrap from "bootstrap";
import App from "./App.vue";
import router from "./router";

import { useKakao } from "vue3-kakao-maps/@utils";

const app = createApp(App);

useKakao("05a0b2e1278a2f4ddbfa4ed1b8990163");

app.use(createPinia());
app.use(router);

app.mount("#app");
