<template>
  <div class="login-container">
    <h2>로그인</h2>
    <form @submit.prevent="handleLogin">
      <div class="input-group">
        <input placeholder="학번" type="number" id="studentId" v-model="studentId" @input="validateStudentID" required />
      </div>
      <div class="input-group">
        <input placeholder = "비밀번호" type="password" id="password" v-model="password" required />
      </div>
      <button type="submit" :disabled="!isStudentIdValid || !password">로그인</button>
      <RouterLink to="/user/register" class="register">회원가입</RouterLink>
    </form>
  </div>
</template>



<script setup>
import { ref } from 'vue'            //ref 는 반응형 변수,. 업뎃되면 
import { useRouter } from 'vue-router'
import { useUserStore } from '@/stores/UserStore';

const studentID = ref('')
const password = ref('')
const isStudentIdValid = ref(false)       
const router = useRouter()
const userStore = useUserStore()

const validateStudentID = () => { 
  isStudentIdValid.value = /^\d+$/.test(studentID.value)    //정규식으로 숫자만으로 구성되었는지 확인한다.
}

const handleLogin = async () => {
  try {
    await userStore.login({ studentID: studentID.value, password: password.value })
    if (userStore.isLogin) {
      router.push('/user/profile')
    } else {
      alert('Invalid credentials!')
    }
  } catch (error) {
    alert('Login failed!')
    console.error(error)
  }
}
</script>

<style scoped>


input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}


.login-container {
  background-color: white;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
  width: 300px;
}

h2 {
  margin-bottom: 1.5rem;
  text-align: center;
}

.input-group {
  margin-bottom: 1rem;
}

input[type='number'],
input[type='password'] {
  width: 100%;
  padding: 0.5rem;
  margin-top: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  width: 100%;
  padding: 0.75rem;
  background-color: #4caf50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #45a049;
}
</style>
