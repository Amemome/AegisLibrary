import { defineStore } from 'pinia';
import axios from 'axios';
import { jwtDecode } from "jwt-decode";




export const useUserStore = defineStore('user', {
  state: () => ({
    token: null,
    user: null,
    admin: null,
  }),
  getters: {
    isLogin: (state) => !!state.token,  //!! 연산자는 JavaScript에서 특정 값의 boolean 값을 반환하기 위해 사용됩니다. 이는 특정 값이 "truthy"한지 "falsy"한지 확인하는 데 유용합니다.
    isAdmin: (state) => state.admin === 'ADMIN_ROLE',
  },
  actions: {
    async login(auth) {
      try {
        const response = await axios.post('/authplease', auth); //post 서버에 요청 보내기 (엔드포인트,내용)
        const token = response.data.token;
        this.token = token;
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
        
        const decoded = jwtDecode(token);
        this.user = decoded.sub; // username
        this.admin = decoded.role; // role
      } catch (error) {
        console.error('Login Failed!', error);
      }
    },
    logout() {
      this.token = null;
      this.user = null;
      this.admin = null;
      delete axios.defaults.headers.common['Authorization'];
    },
    async fetchUserProfile() {
        try {
            const response = await axios.get('/user/profile');
            return response.data;
        } catch (error) {
            console.error('Failed to fetch user profile',error)
        }

    }
  }
});
