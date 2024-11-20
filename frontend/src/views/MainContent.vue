<template>
  <div class="main-content">
    <div class="content">
      <h2 id="route-top-10">Route Top 10</h2>
      <Carousel :items-to-show="5" :wrap-around="true" :autoplay="true" :autoplay-timeout="3000" :transition="3000"
        :pause-autoplay-on-hover="true" :breakpoints="{
          1024: { itemsToShow: 3 },
          768: { itemsToShow: 2 },
          480: { itemsToShow: 1 },
        }">
        <Slide v-for="(item, index) in items" :key="index">
          <div class="slide-content">
            <img :src="item.imageUrl" alt="Slide Image" />
            <h3>{{ item.title }}</h3>
            <div class="rate">
              <span>Rate : </span>
              <span v-for="n in item.rate" :key="n">💚</span>
            </div>
          </div>
        </Slide>
      </Carousel>

      <div id="select-route-button">
        <button @click="navigateToOption">SELECT ROUTE</button>
      </div>
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
    rate: 5,
  },
  {
    title: "구미호뎐",
    imageUrl: "https://i.namu.wiki/i/tYqXtXGalN06AVTbxKoWIp6j0E61HmTaLKn5KsTxFAg9Jgq-EDGwCZONJyk_QJBEuxFb9xCxzlB7TM0tfLU9cbnKeyUL1vcp1v8h9Q_FvWfN3SwqwtqsKQUfIvqZIwo-raNjNPZ4HXwbk6nMgkIujQGXSdYXxfthHgBIyaQ1L9k.webp",
    rate: 4,
  },
  { title: "Slide 3", imageUrl: "https://via.placeholder.com/360x270", rate: 3, },
  { title: "Slide 4", imageUrl: "https://via.placeholder.com/360x270", rate: 2, },
  { title: "Slide 5", imageUrl: "https://via.placeholder.com/360x270", rate: 1, },
  { title: "Slide 6", imageUrl: "https://via.placeholder.com/360x270", rate: 3, },
  { title: "Slide 7", imageUrl: "https://via.placeholder.com/360x270", rate: 4, },
  { title: "Slide 8", imageUrl: "https://via.placeholder.com/360x270", rate: 5, },
  { title: "Slide 9", imageUrl: "https://via.placeholder.com/360x270", rate: 2, },
  { title: "Slide 10", imageUrl: "https://via.placeholder.com/360x270", rate: 1, },
];

import { useRouter } from "vue-router";

const router = useRouter();

const navigateToOption = () => {
  router.push("/option");
};
</script>

<style scoped>
.rate {
  margin-top: 10px;
  margin-left: 3px;
  font-size: 1.1rem;
  display: flex;
  justify-content: center;
  gap: 2px;
}

#select-route-button button {
  margin-top: 2rem;
  display: inline-block;
  padding: 12px 24px;
  font-size: 16px;
  font-weight: bold;
  color: white;
  background-color: #ffb703;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease, transform 0.2s ease;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

#select-route-button button:hover {
  background-color: #6a994e;
  transform: translateY(-3px);
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.3);
}

#select-route-button button:active {
  transform: translateY(1px);
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
}

#route-top-10 {
  text-align: left;
  margin-left: 20px;
  margin-bottom: 20px;
}

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
  height: 70%;
  max-height: 500px;
  text-align: center;
  z-index: 2;
  color: white;
}

.slide-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 300px;
  height: 360px;
  background-color: rgb(22, 22, 22);
  border: 1px solid #ccc;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease, box-shadow 0.3s ease, width 0.3s ease, height 0.3s ease;
}

.slide-content:hover {
  width: 330px;
  height: 340px;
  transform: scale(1) translateY(-10px);
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.3);
}


.slide-content img {
  width: 100%;
  height: 210px;
  object-fit: scale-down;
}

.slide-content h3 {
  margin-top: 10px;
  font-size: 1.2rem;
  color: white;
}
</style>
