<template>
  <div class="login-layout">
    <router-view />
    <!-- 로그인 컴포넌트를 렌더링 -->
  </div>
</template>

<style scoped>
.login-layout {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: white; /* 배경을 흰색으로 설정 */
}
</style>
