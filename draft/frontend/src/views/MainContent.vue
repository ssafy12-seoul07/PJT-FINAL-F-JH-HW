<template>
  <div class="main-content">
        <div class="content">
            <h1>Welcome to <br>Urban Recommendation Stroll</h1>
            <div id="select-route-button">
              <button @click="navigateToOption">SELECT ROUTE</button>
        </div>
                       
        </div>
    </div>

</template>

<script setup>

import { useRouter } from "vue-router";

const router = useRouter();

const navigateToOption = () => {
  router.push("/form");
};
</script>

<style scoped>
.main-content {
    position: relative;
    width: 100vw;
    height: 100vh;
}

.content {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    text-align: center;
    z-index: 2;
    color: white;
}

h1 {
    font-size: 3rem;
    margin-bottom: 20px;
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


.main-content {
  position: relative;
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

</style>
