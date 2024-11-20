<template>
  <div class="main-page">
    <div class="header-container">
      <Header />
    </div>

    <Overlay />

    <div class="content-container">
      <MainContent />
    </div>

    <div class="footer-container">
      <Footer />
    </div>
  </div>
</template>

<script setup>
import Header from '@/components/Header.vue';
import MainContent from '@/views/MainContent.vue';
import Footer from '@/components/Footer.vue';
import Overlay from '@/components/Overlay.vue';
</script>

<style scoped>
.header-container {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 3;
  padding: 20px 30px;
}


.content-container {
  position: relative;
  z-index: 1;
}

.footer-container {
  position: relative;
  z-index: 2;
}
</style>