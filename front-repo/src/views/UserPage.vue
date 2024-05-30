<template>
    <h1>안녕 유저네임</h1>
    <div v-if = "profile">   
        <h1>User Profile</h1>
        <p>Username: {{ profile?.username }} </p>     <!--옵셔널 체이닝-->  
        
    </div>
    <div class = "booklog" v-if = "books.length">   <!--books 의 객체 리스트가 0이면 실행안되겠죠-->
        <ul v-for="book in borrowedBooks" :key="book.id">
        {{
          book.title
        }}
      </ul>

    </div>

    
</template>

<script setup>

import { ref, onMounted } from 'vue';
import { useUserStore } from '@/stores/UserStore';

const userStore = useUserStore();
const profile = ref(null);         //null 이면 false
const books = ([]);

onMounted(async () => {
    profile.value = await userStore.fetchUserProfile();
    await fetchBorrowBooks
})

async function fetchBorrowBooks() {

}

</script>