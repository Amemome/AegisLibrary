<script setup>
defineProps({
  msg: String
})
</script>

<template>
  <div class="home">
    <input type="text" placeholder="도서 검색" v-model="searchQuery" />
  </div>
</template>

<style scoped>
.hello {
  background-color: red;
}
</style>


