import axios from 'axios';

const Axios = axios.create({
    baseURL: import.meta.env.VITE_API_BASE_URL,
  headers: {
    'Content-Type': 'application/json'
  }
});

const token = sessionStorage.getItem('jwtToken');
if (token) {
  Axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
}

export default Axios;