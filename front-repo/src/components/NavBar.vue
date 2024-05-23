<template>
  <header class="navbar">
    <div class="navbar-left">
      <h2>Aegis Book</h2>
    </div>
    <nav class="navbar-center">
      <RouterLink to="/" class="navbar-center-elemnt">Home</RouterLink>
      <RouterLink to="/about" class="navbar-center-elemnt">About</RouterLink>
      <RouterLink to="/contact" class="navbar-center-elemnt">Contact</RouterLink>
    </nav>

    <div class="navbar-right">
      <RouterLink to="/user/login" class="navbar-right">
        <button class="login-button">Login</button>
      </RouterLink>
    </div>
  </header>
</template>

<script setup>
import { RouterLink } from 'vue-router'
</script>

<style scoped>
.navbar {
  font-family:
    Inter var,
    ui-sans-serif,
    system-ui,
    sans-serif,
    Apple Color Emoji,
    Segoe UI Emoji,
    Segoe UI Symbol,
    Noto Color Emoji;
}
</style>

<style scoped>
.navbar {
  width: 100vw;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: hsl(0, 27%, 84%, 0.5);
  color: #1f1e33;
  backdrop-filter: blur(5px);
}

.navbar-left h2 {
  margin-left: 4vw;
  font-family: 'Charis SIL', serif;
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
  background-color: rgb(69, 160, 73,0.3);
  border-radius: 20px;
  backdrop-filter: (6px);
  
}
</style>
