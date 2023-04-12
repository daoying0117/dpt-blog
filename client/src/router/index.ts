import { createRouter, createWebHistory } from 'vue-router';
import { staticRoutes, anyRoute } from '@/router/routes';

const router = createRouter({
	history: createWebHistory(),
	routes: staticRoutes,
    // 切换组件 让页面滚动到顶部
    scrollBehavior() {
        return { top: 0, left: 0}
    },
})

// 导出路由
export default router;