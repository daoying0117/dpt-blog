import { createApp } from 'vue'
import App from './App.vue'
import './styles/index.scss'
import router from './router' // 路由

createApp(App).use(router)
.mount('#app')
