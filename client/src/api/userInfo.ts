import request from '@/utils/request'

export interface RegisterInfoModel extends LoginModel {
  confirmPassword: string,
  phone: string,
  email: string,
}

export interface LoginModel {
  username: string,
  password: string
}

export interface TokenModel {
  token: string
}

// 管理员信息
export interface UserInfoModel{
    id: string,
    nickName: string,
    headImg: string,
    backImg: string,
    motto: string ,
    email: string,
    phone: string
}

export default {
  login(loginData: LoginModel) {
    return request.post<any, TokenModel>(`/admin/login`, loginData)
  },
  register(RegisterData: RegisterInfoModel) {
    return request.post<any, any>(`/admin/register`,RegisterData)
  },
  getInfo(){
    return request.get<any,UserInfoModel>(`/admin/getAdminConfig`)
  }
}
