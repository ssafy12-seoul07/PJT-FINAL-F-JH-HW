<template>
    <div>
      <h2>HomeView</h2>
      <button @click="sendRouteId" value="'name'=routeId" >routeId전달</button>
      <hr>
    </div>
  </template>
  
  <script setup>
    const sendRouteId = function(){
      // 2를 kakaovue2 에 전달
    }
  </script>
  
  <style scoped>
  
  </style>
  