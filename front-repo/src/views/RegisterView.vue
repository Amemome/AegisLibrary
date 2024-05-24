<template>
    <div class="login-container">
      <h2>회원가입</h2>
      <form @submit.prevent = "register">
        <div class="input-group">
          <input placeholder = "학번" type="text" id="studentID" v-model="studentID" class="input" maxlength="8"  required />
        </div>
        <div class="input-group">
          <input placeholder = "실명" type="input"  id="name" v-model="name" class="input" required />
        </div>
        <div class="input-group">
          <input placeholder = "비밀번호" type="input"  id="password" v-model="password" class="input" required />
        </div>
        <div class="input-group">
          <input placeholder = "비밀번호 확인" type="input"  id="passwordcheck" v-model="passwordcheck" class="input" required />
        </div>
        <button type="submit">회원가입</button>
        <p v-if = "errorMessage" class = "error-message">{{ errorMessage }} </p> 
      </form>
    </div>
</template>
  
<script>

import axios from 'axios';

export default {
    data() { 
        return {
            studentID: '',
            name : '',
            password:'',
            passwordcheck: '',
            errormessage:'',
        };
    },
    methods: {
        async register() {
            if ( this.passwordcheck !== this.password) {
                this.errorMessage = '비밀번호가 일치하지 않아요!'
                return;
            } 
            try {
                const response = await axios.post('http://localhost:8080/api/users/register' , {
                    studentID: this.studentID,
                    name: this.name,
                    password: this.password,
                }); 
                console.log('succedss!',response.data);
            } catch (error) {
                if (error.response && error.response.data) {
                    this.errorMessage = error.response.data;
                } else {
                    this.errorMessage = 'An error occurred during registration';
                }
            }
            
        }
    }
}
  
</script>
  
<style scoped>
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
  

  .input {
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
  