import { defineStore } from 'pinia';
import Axios from '@/api';




export const useUserStore = defineStore('user', {         //유저 고유 정보를 담기는 좀 그런가?  
  state: () => ({                                          //아무튼 그러니까 책 정보만 담는걸로. token 
    token: null,                                         //define store 아 근데 어차피 JWT 디코딩 하면 다 얻을 수 잇는 정보임 그냥 넣자
    borrowed: [],
    recentseen: [],
    isLogin: false,
  }),
  //!! 연산자는 JavaScript에서 특정 값의 boolean 값을 반환하기 위해 사용됩니다. 이는 특정 값이 "truthy"한지 "falsy"한지 확인하는 데 유용합니다.
  actions: {
    async login(loginplz) {
      try {
        console.log(loginplz)
                //확인용           


        //Axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;  //session storage 에 저장하면 새로고침 해도 저장되어있다. 
        
      } catch (error) {
        console.error('Login Failed!', error);     
        console.log(error.response)     //test용
          
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
    },
    addRecentSeen(item) {
      this.recentseen.push(item);

      if (this.recentseen.length > 8) {
        this.recentseen.shift();
      }
    }
  },
  persist: true,      //pinia 스토리지에 저장하게하기.. 새로고침 되어도 값이 변하지 않도록 <-- 실제로 된다~ 
});                   //새로고침 해도 그대로 있고 껏다가 켜도 그대로 있고 다른 브라우저에서는 안댐댐


export default useUserStore;