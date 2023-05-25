<template>
    <div class="register-container">
        <el-card>
            <el-form>
                <el-form-item >
                    <el-text class="mx-1">用户名</el-text>
                    <el-input 
                        v-model="registerForm.username"
                        placeholder="请输入用户名"
                    ></el-input>
                </el-form-item>
                <el-form-item>
                    <el-text class="mx-1">密码</el-text>
                    <el-input 
                    v-model="registerForm.password"
                    placeholder="请输入密码"
                    ></el-input>
                </el-form-item>
                <el-form-item>
                    <el-text class="mx-1">确认密码</el-text>
                    <el-input 
                    v-model="registerForm.confirmPassword"
                    placeholder="请再次输入密码"
                    ></el-input>
                </el-form-item>
                <el-form-item>
                    <el-text class="mx-1">手机号</el-text>
                    <el-input 
                    v-model="registerForm.phone"
                    placeholder="请输入手机号"
                    ></el-input>
                </el-form-item>
                <el-form-item>
                    <el-text class="mx-1">邮箱</el-text>
                    <el-input 
                    v-model="registerForm.email"
                    placeholder="请输入邮箱"
                    ></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button @click="handleRegister">注册</el-button>
                </el-form-item>
            </el-form>
            <div class="login">
                已有账号？
                <span>
                    <router-link to="/login">去登录</router-link>
                </span>
                
            </div>
        </el-card>
    </div>
</template>

<script setup lang="ts">
import {ref} from 'vue'
import { useRoute, useRouter } from 'vue-router'
import registerApi from '../../api/userInfo'
import { useUserInfoStore } from '@/stores/userInfo';

const userInfoStore = useUserInfoStore()
// 路由跳转
const router = useRouter()

// 注册表单
const registerForm = ref({
    // 用户名默认为空
    username: '',
    // 密码默认为空
    password: '',
    // 二次确认密码框默认为空
    confirmPassword: '',
    // 手机号默认为空
    phone: '',
    // 邮箱默认为空
    email: ''
})
// 注册过程的loading 默认不显示
const loading = ref(false)
// 点击注册的回调
const handleRegister = async () => {
    // 显示loading
    loading.value = true
    // 获取注册信息
    
    // 调用接口
    try {
        let res = await registerApi.register(registerForm.value)
        console.log(res)
         // 注册成功后 跳转登录页
        router.push({ path: '/login'})
    } finally {
        // 关闭loading
        loading.value = false
    }
}


</script>

<style lang="scss">
.register-container{
    height: 100%;
    display: flex;
    .el-card{
        margin: auto;
        height: 420px;
        width: 300px;
        .el-form{
            height: 100%;
            width: 100%;
            margin-top: -30px;
            .el-form-item{
                height: 35px;
                margin-top: 25px;
                .el-text{
                    font-size: 10px;
                }
                .el-input{
                    height: 25px;
                }
                .el-input__inner {
                    &::placeholder {
                    font-size: 10px;
                    }
                }    
                .el-button{
                    margin: 30px 0;
                    width: 100%;
                    height: 30px;
                    color: #fff;
                    background-color: #000;
                }
            }
        }
        .login{
            text-align: center;
            font-size: 10px;
            color: #aaa;
            margin-top: 40px;
            span:hover{
               color: #000;
            }
        }

    }
}
</style>