<template>
  <div class="main-content">
    <div class="modal-content">
      <h2>Upload Your Photos</h2>
      <div class="upload-list">
        <!-- 각 로드뷰와 업로드 URL을 개별적으로 전달 -->
        <SingleFileUpload v-for="(location, index) in locations" :key="index" :latitude="location.lat"
          :longitude="location.lng" :mapId="'street-view-' + index" :uploadUrl="uploadUrls[index]" />
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import SingleFileUpload from "@/components/SingleFileUpload.vue";

// 위도, 경도 데이터 배열
const locations = ref([
  { lat: 37.577462, lng: 126.991932 }, // 37.577462, 126.991932
  { lat: 37.569737, lng: 126.995222 }, // 37.569737, 126.995222
  // { lat: 37.569348, lng: 126.999860 }, // 37.569348, 126.999860
]);

// 개별 업로드 URL 리스트
const uploadUrls = ref([
  "/api/upload/file1",
  "/api/upload/file2",
  "/api/upload/file3",
]);
</script>

<style scoped>
.main-content {
  position: relative;
  width: 100vw;
  height: 104vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal-content {
  background: rgb(22, 22, 22);
  border: 0.0625rem solid rgba(128, 128, 128, 0.4);
  border-radius: 0.5rem;
  box-shadow: rgba(0, 0, 0, 0.8) 0px 0.25rem 0.5rem 0px;
  color: rgba(255, 255, 255, 0.7);
  width: 100%;
  max-width: 1400px;
  min-height: 500px;
  padding: 20px;
  position: relative;
  text-align: center;
}

.modal-content h2 {
  margin-bottom: 20px;
}

.upload-list {
  display: flex;
  flex-direction: row;
  justify-content: center;
  gap: 30px;
}
</style>
