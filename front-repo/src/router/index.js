import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import LoginLayout from '../layouts/LoginLayout.vue'
import AboutView from '@/views/AboutView.vue'
import RegisterView from '@/views/RegisterView.vue'
import SearchPage from '@/views/SearchPage.vue'
import UserPage from '@/views/UserPage.vue'
import AdminView from '../views/AdminView.vue'
import NavBar from '@/components/NavBar.vue'

import { useUserStore } from '@/stores/UserStore'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: NavBar,
    children: [
      {
        path: '/',
        component: HomeView
      },
      {
        path: 'about',
        name: 'about',
        component: AboutView
      },
      {
        path: 'search',
        name: 'search',
        component: SearchPage
      }
    ]
  },
  {
    path: '/user',
    component: LoginLayout,
    children: [
      {
        path: 'login',
        name: 'login',
        component: LoginView
      },
      {
        path: 'register',
        name: 'register',
        component: RegisterView
      },
      {
        path: '/',
        name: 'profile',
        component: UserPage,
        meta: {
          requireLogin: true,
        }
      },
      {
        path: '/admin',
        name: 'admin',
        component: AdminView,
        meta: {
          requireLogin: true,
          requireAdmin: true,
        }
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

router.beforeEach((to,from,next) => {      //beforeach는 VueRouter 에서 사용하는 전역가드중 하나. 모든 라우트 이동 전에 실행된다.
  const userStore = useUserStore();
  if (to.meta.requireLogin && !userStore.isLogin) {
  next('/login');
} else {
  next();
}
});


export default router
