import type {RouteRecordRaw} from 'vue-router'

export const staticRoutes: Array<RouteRecordRaw> = [
    // 登录页路由
    {
        path:'/login',
        name:'Login',
        component: ()=> import ('@/views/login/index.vue'),
        meta:{
            hidden:true
        }
    },
    // 注册页路由
    {
        path:'/register',
        name:'Register',
        component: ()=> import ('@/views/register/index.vue'),
        meta:{
            hidden:true
        }
    },
    {
        path: '/404',
        name: '404',
        component: () => import('@/views/error/404.vue'),
        meta: {
          hidden: true
        }
      },
      {
        path: '/',
        component: () => import('@/views/home/index.vue'),
        meta: { 
            title: '首页' 
        }
      },
]

export const anyRoute: RouteRecordRaw = { 
    path: '/:pathMatch(.*)', 
    name: 'Any',
    redirect: '/404', 
    meta: {
      hidden: true 
    }
  }