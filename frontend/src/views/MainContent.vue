<template>
  <div class="main-content">
    <div class="content">
      <Carousel :items-to-show="5" :wrap-around="true" :autoplay="true" :autoplay-timeout="3000" :transition="3000"
        :navigation-enabled="true">
        <Slide v-for="(item, index) in items" :key="index">
          <div class="slide-content">
            <img :src="item.imageUrl" alt="Slide Image" />
            <h3>{{ item.title }}</h3>
          </div>
        </Slide>
      </Carousel>
    </div>
  </div>
</template>

<script setup>
import "vue3-carousel/dist/carousel.css";
import { Carousel, Slide } from "vue3-carousel";

const items = [
  {
    title: "스물다섯 스물하나",
    imageUrl: "https://i.namu.wiki/i/tYqXtXGalN06AVTbxKoWIoc9qlE8Er5XSslCxiF_fP1PwLjcuf1ouCOy3rVDCtL2AyGL__BvxHyAFuhrEMTbWRezqVpdTWWIuSZBdhP7slwgYiRkaTlsObEIBXqRKpX62zQu85AstRmxEVJYPHsag1ifEEDoLAawEYqbzgq_Nnw.webp",
  },
  { title: "구미호뎐", imageUrl: "https://i.namu.wiki/i/tYqXtXGalN06AVTbxKoWIp6j0E61HmTaLKn5KsTxFAg9Jgq-EDGwCZONJyk_QJBEuxFb9xCxzlB7TM0tfLU9cbnKeyUL1vcp1v8h9Q_FvWfN3SwqwtqsKQUfIvqZIwo-raNjNPZ4HXwbk6nMgkIujQGXSdYXxfthHgBIyaQ1L9k.webp" },
  { title: "Slide 3", imageUrl: "https://via.placeholder.com/360x270" },
  { title: "Slide 4", imageUrl: "https://via.placeholder.com/360x270" },
  { title: "Slide 5", imageUrl: "https://via.placeholder.com/360x270" },
  { title: "Slide 6", imageUrl: "https://via.placeholder.com/360x270" },
  { title: "Slide 7", imageUrl: "https://via.placeholder.com/360x270" },
];
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

.content {
  width: 80%;
  max-width: 1200px;
  /* 최대 너비 제한 */
  height: 50%;
  /* 페이지 높이의 50%만 차지 */
  max-height: 400px;
  /* 최대 높이 제한 */
  text-align: center;
  z-index: 2;
  color: white;
}

.carousel__track {
  display: flex;
  gap: 20px;
  /* 슬라이드 간 간격 */
}

.slide-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 360px;
  height: 270px;
  background-color: #fff;
  border: 1px solid #ccc;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease;
}

.slide-content:hover {
  transform: scale(1.1);
  /* 마우스 호버 시 확대 */
}

.slide-content img {
  width: 100%;
  height: 180px;
  /* 모든 이미지를 동일한 높이로 설정 */
  object-fit: cover;
}

.slide-content h3 {
  margin-top: 10px;
  font-size: 1.2rem;
  color: #333;
}

/* 네비게이션 버튼 스타일 */
.carousel__prev,
.carousel__next {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  background-color: rgba(0, 0, 0, 0.5);
  /* 반투명 배경 */
  color: white;
  border: none;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  /* 원형 버튼 */
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  z-index: 10;
}

.carousel__prev {
  left: -20px;
}

.carousel__next {
  right: -20px;
}

.carousel__prev:hover,
.carousel__next:hover {
  background-color: rgba(0, 0, 0, 0.8);
}
</style>
