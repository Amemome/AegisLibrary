<template>
    <h1>안녕 유저네임</h1>
    <div v-if = "profile">
        <h1>User Profile</h1>
        <p>Username: {{ profile.username }}</p>


    
    
    </div>
    <div class = "booklog"></div>

    
</template>

<script setup>

import { ref, onMounted } from 'vue';
import { useUserStore } from '@/stores/UserStore';

const userStore = useUserStore();
const profile = ref(null);

onMounted(async () => {
    profile.value = await userStore.fetchUserProfile();
})

</script>