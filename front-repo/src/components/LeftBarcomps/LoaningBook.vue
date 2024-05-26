<template>
  <div id="loanbook">
    <div id="title"><h3>빌린 책 목록</h3></div>

    <ul>
      <ul v-for="book in borrowedBooks" :key="book.id">
        {{
          book.title
        }}
      </ul>
    </ul>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const borrowedBooks = ref([
  { id: 1, title: 'The grat' },
  { id: 2, title: 'The man' },
  { id: 3, title: 'iamtheman' },
  { id: 5, title: 'asdfasdfsd'}
])
</script>

<style scoped>
.loanbook {
  flex: 1;
  overflow-y: auto;
}

.loanbook ul {
  list-style: none;
  padding: 0;
}

.loanbook li {
  margin: 0.5rem 0;
  cursor: pointer;
}

.loanbook li:hover {
  text-decoration: underline;
}

ul {
  padding: 0;
}
</style>
