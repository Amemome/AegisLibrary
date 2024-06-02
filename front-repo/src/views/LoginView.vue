<template>
  <div class="login-container">
    <h2>로그인</h2>
    <form @submit.prevent="handleLogin">
      <div class="input-group">
        <input placeholder = "학번" type="number" id="studentID" v-model="studentID" class="input" maxlength="8"  required />
      </div>
      <div class="input-group">
        <input placeholder = "비밀번호" type="password"  id="password" minlength="8" maxlength="20" v-model="password" class="input" required />
      </div>
      <button type="submit">로그인</button>
      <RouterLink to="/user/register" class="register">회원가입</RouterLink>
    </form>
  </div>
</template>



<script>
          //ref 는 반응형 변수,. 업뎃되면 어쩌고..

//import {useUserStore} from '@/stores/UserStore';
import Axios from '@/api'
  

//const userStore = useUserStore()          //유저상태보기




export default {
      data() {               //이 컴포넌트(vue파일) 에서 정의되는 컴포넌트의 상태를 정의한다
          return {
              studentID: '',           //이 객체에는 컴포넌트에서 사용될 모든 변수들임.
              password:'',
        };
    },
    methods: {                // 각 컴포넌트에서 사용할 수 있는 메서드들을 정의한다.
        async handleLogin() {  
            try {
                const loginData = {              //미리 정의를 해놔야지 이게 들어감 아니면 null 나와요 
                  studentID: this.studentID,    
                  password: this.password,
                }
                const response = await Axios.post('/api/loginplease' ,null, {params: loginData}); 

                if (response.status == 200) {
                  alert('로그인 성공!')
                  this.$router.push('/')
                  }
            } catch (error) {
              if (error.response) {
                if (error.response.status === 409) {
                  alert('로그인 실패~~');
                  this.$router.push('/user/login');
                } else {
                  this.errormessage = error.response.data;
                }
                } else {
                  this.errormessage = '로그인 중 오류가 발생했습니다';
                }
                  this.$router.push('/user/login');
            }
            
        }
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
