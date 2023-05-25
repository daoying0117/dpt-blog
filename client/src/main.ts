import { createApp } from 'vue'
import App from './App.vue'
import './styles/index.scss'
import router from './router' // 路由
import pinia from './stores/index'

createApp(App).use(router)
.use(pinia)
.mount('#app')
