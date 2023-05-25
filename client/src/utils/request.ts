import axios, { type AxiosResponse, type AxiosRequestHeaders, InternalAxiosRequestConfig } from 'axios';
import { ElMessage, ElMessageBox } from 'element-plus';
import { useUserInfoStore } from '../stores/userInfo';


/* 定义response对象的data接口 */
interface ResponseData<T> {
  ok: boolean;
  code: number;
  data: T;
  message: string;
}

// 配置新建一个 axios 实例
const service = axios.create({
  baseURL: import.meta.env.VITE_API_URL,
  timeout: 50000,
});

// 添加请求拦截器
service.interceptors.request.use(
  (config) => {
    const userInfoStore = useUserInfoStore()
    let token = userInfoStore.token;
    if (token) {
      (config.headers as AxiosRequestHeaders).token = token;
    }
    return config;
  }
);

// 添加响应拦截器
service.interceptors.response.use(
  async (response: AxiosResponse<ResponseData<any>>) => {
    // 对响应数据做点什么
    const res = response.data;
    if (res.code !== 20000 && res.code !== 200) { 
      ElMessage({
        message: (typeof res.data=='string' && res.data) || res.message || 'Error',
        type: 'error',
        duration: 5 * 1000
      })
      return Promise.reject(service.interceptors.response);
    } else {
      return res.data; 
    }
  },
  (error) => {
    // 对响应错误做点什么
    if (error.message.indexOf('timeout') != -1) {
      ElMessage.error('网络超时');
    } else if (error.message == 'Network Error') {
      ElMessage.error('网络连接错误');
    } else {
      if (error.response.data) ElMessage.error(error.response.statusText);
      else ElMessage.error('接口路径找不到');
    }
    return Promise.reject(error);
  }
);

export default service;
