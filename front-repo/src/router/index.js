import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import LoginLayout from '../layouts/LoginLayout.vue'
import AboutView from '@/views/AboutView.vue'
import RegisterView from '@/views/RegisterView.vue'
import SearchPage from '@/views/SearchPage.vue'
import UserPage from '@/views/UserPage.vue'
import NavBar from '@/components/NavBar.vue'

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
        component: UserPage
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
