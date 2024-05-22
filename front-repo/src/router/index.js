import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import LoginLayout from '../layouts/LoginLayout.vue'
import AboutView from '@/views/AboutView.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomeView,
    children: [
      {
        path: '/',
        component: HomeView
      },
      {
        path: 'about',
        name: 'about',
        component: AboutView
      }
    ]
  },
  {
    path: '/login',
    component: LoginLayout,
    children: [
      {
        path: '',
        name: 'Login',
        component: LoginView
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
