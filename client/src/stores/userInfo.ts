import { defineStore } from 'pinia';
import { getToken, removeToken, setToken } from '../utils/token-utils';
import {arrowMiddleware, ElMessage} from 'element-plus'
import userInfoApi, { type UserInfoModel } from '@/api/userInfo';

interface UserInfoState {
  token: string;
  userInfo: UserInfoModel,
}

// 用于初始化管理员信息
const initUserInfo = () => ({
    id: '',
    nickName: '',
    headImg: '',
    backImg: '',
    motto: '' ,
    email: '',
    phone: ''
})

// 用户信息
export const useUserInfoStore = defineStore('userInfo', {

	state: (): UserInfoState => ({
    token: getToken() as string,
    userInfo: initUserInfo(),
  }),

	actions: {
    async login (username: string, password: string) {
      try {
        let result = await userInfoApi.login({username, password});
        setToken(result.token)
        this.token = result.token;
      } catch (error) {
        ElMessage.error('登陆失败,请重试')
        return Promise.reject(error) 
      }
    },

    async getInfo () {
      try {
        let result = await userInfoApi.getInfo();
        this.userInfo = result; 
      } catch (error) {
        ElMessage.error('获取个人信息失败,请重试')
        return Promise.reject(error)
      }
    },
	},
});
