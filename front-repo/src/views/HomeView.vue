<script setup>
import NavBar from '../components/NavBar.vue'
import LeftSideBar from '../components/LeftSideBar.vue'
import MyHome from '../components/MyHome.vue'
</script>

<template>
  <div id="app">
    <NavBar />
    <div id="contents">
      <LeftSideBar />
      <MyHome />
    </div>
  </div>
</template>
