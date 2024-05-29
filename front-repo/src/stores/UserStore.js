import { defineStore } from 'pinia';
import Axios from '@/api';



export const useUserStore = defineStore('user', {         //유저 고유 정보를 담기는 좀 그런가?  
  state: () => ({                                          //아무튼 그러니까 책 정보만 담는걸로. token 
    token: null,                                         //define store 아 근데 어차피 JWT 디코딩 하면 다 얻을 수 잇는 정보임 그냥 넣자
    borrowed: Object,
  }),
  getters: {
    isLogin: (state) => !!state.token,  //!! 연산자는 JavaScript에서 특정 값의 boolean 값을 반환하기 위해 사용됩니다. 이는 특정 값이 "truthy"한지 "falsy"한지 확인하는 데 유용합니다.
  },
  actions: {
    async login(loginplz) {
      try {
        const response = await Axios.post('/api/loginplease', loginplz); //post 서버에 요청 보내기 (엔드포인트,내용)
        const token = response.data.token;
        console.log(token)
        this.token = token;
        Axios.defaults.headers.common['Authorization'] = `Bearer ${token}`; 
        
      } catch (error) {
        console.error('Login Failed!', error);
      }
    },
    logout() {
      this.token = null;
      delete Axios.defaults.headers.common['Authorization'];
    },
    async fetchUserProfile() {
        try {
            const response = await Axios.get('/user/profile');
            return response.data;
        } catch (error) {
            console.error('Failed to fetch user profile',error)
        }

    }
  }
});
