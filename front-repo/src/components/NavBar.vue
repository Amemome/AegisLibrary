<template>
  <header class="navbar">
    <div class="navbar-left">
      <RouterLink to="/" class="title">Aegis Book</RouterLink>
    </div>
    <nav class="navbar-center">
      <a href="https://dk-aegis.org/" class="navbar-center-elemnt">이지스 홈페이지</a>
      <RouterLink to="/about" class="navbar-center-elemnt">내 서재</RouterLink>
      <RouterLink to="/contact" class="navbar-center-elemnt">도서 신청</RouterLink>
    </nav>

    <div class="navbar-right">
      <RouterLink to="/user/login" class="navbar-right">
        <button class="login-button">로그인</button>
      </RouterLink>
      <!-- 새로운 버튼 추가 -->
      <button @click="sendRequest" class="login-button">요청 보내기</button>
    </div>
  </header>
  <Transition name="searchbartransition" mode="out-in">
    <RouterView></RouterView>
  </Transition>
</template>

<script setup>
import { RouterLink } from 'vue-router'
import axios from 'axios'

// 요청을 보내는 메소드 정의
const sendRequest = () => {
  axios.get('http://localhost:8080/api/message')
    .then(response => {
      console.log('Response from server:', response.data)
    })
    .catch(error => {
      console.error('There was an error!', error)
    })
}
</script>

<style scoped>
.navbar {
  width: 100vw;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: hsl(0, 27%, 84%, 0.5);
  color: #1f1e33;
  backdrop-filter: blur(5px);
  padding: 2vh;
  padding-left: 0vw;
}

.title {
  text-decoration: none;
  margin-left: 3vw;
  font-family: 'Charis SIL', serif;
  color: #1f1e33;
  font-size: 36px;
}

.navbar-center {
  text-decoration: none;
  margin-right: 10px;
  align-items: right;
  flex: 1;
  display: flex;
  justify-content: right;
  gap: 1rem;
}

.navbar-center-elemnt {
  text-decoration: none;
  color: white;
}

.navbar-center RouterLink.router-link-exact-active {
  font-weight: bold;
  text-decoration: none;
}

.navbar-right .login-button {
  margin-right: 4vw;
  background-color: transparent;
  color: white;
  border: none;
  padding: 0.5rem 1rem;
  cursor: pointer;
  font-size: 1rem;
}

.navbar-right .login-button:hover {
  background-color: rgb(69, 160, 73, 0.3);
  border-radius: 20px;
  backdrop-filter: (6px);
}
</style>
