<script setup>
import NavBar from '../components/NavBar.vue'
import LeftSideBar from '../components/LeftSideBar.vue'
import MyHome from '../components/MyHome.vue'
</script>

<template>
  <div id="app">
    <NavBar />
    <div class="content">
      <LeftSideBar />
      <MyHome />
  </div>
  </div>
</template>

<style scoped>
.content {
  display: flex;
  flex-direction: row;
}


</style>
