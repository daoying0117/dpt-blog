<template>
    <div class="login-container">
        <el-card>
            <div class="title">
                Dpt
            </div>
            <el-form
                ref="ruleFormRef"
                :model="loginForm"
                status-icon
                class="demo-ruleForm"
            >
                <el-form-item>
                    <el-input
                        v-model="loginForm.username"
                        placeholder="用户名"
                        type="text"
                        :prefix-icon="User"
                    />
                </el-form-item>
                <el-form-item>
                    <el-input
                        v-model="loginForm.password"
                        placeholder="密码"
                        :type="passwordType"
                        :prefix-icon="Lock"
                        show-password
                    />
                </el-form-item>
                <el-form-item>
                    <el-button :loading="loading" @click.prevent="handleLogin"
                        >登录</el-button
                    >
                </el-form-item>
            </el-form>
            <div class="register">
                还没有账号？
                <span>
                    <router-link to="/register">立即注册</router-link>
                </span>
                
            </div>
            <!-- <div class="other">
                <hr>
                <div class="text">第三方登录</div>
                <div class="loginWay">
                    <div>
                        <i class="icon icon-github"></i>
                    </div>
                    <div>2</div>
                    <div>3</div>
                </div>
            </div> -->
        </el-card>
    </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import {Lock,User} from '@element-plus/icons-vue'
import { useRoute, useRouter } from 'vue-router'
import { useUserInfoStore } from '@/stores/userInfo';

const userInfoStore = useUserInfoStore()
// 路由跳转
const router = useRouter()

// 登录表单的数据
const loginForm = ref({
  username: '',
  password: ''
})
// 登录过程的loading 默认不显示
const loading = ref(false)
// 点击登录的回调
const handleLogin = async () => {
    // 显示loading
    loading.value = true
    // 获取用户名 密码
    const {username, password} = loginForm.value
    // 调用接口
    try {
        await userInfoStore.login(username, password)
         // 登录成功后 跳转首页
        router.push({ path: '/home'})
    } finally {
        // 关闭loading
        loading.value = false
    }
}

// 用户名默认为空
const username = ref('')
// 密码默认为空
const password = ref('')
const passwordType = ref('password')
</script>

<style lang="scss">
.login-container{
    height: 100%;
    // background-image: url(../../assets/login.jpg);
    background-size: cover;
    display: flex;
    .el-card{
        width: 300px;
        height: 250px;
        margin: auto;
        .title{
            text-align: center;
            color: rgb(3, 10, 26);
            margin-bottom: 20px;
            font-family: Georgia, serif;
            font-style: italic;
            font-size: 20px;
            font-weight: bold;
        }
        .el-form-item{
            width: 100%;
            .el-input{
                height: 30px;
                width: 100%;
                font-size: 10px;
            }
            .el-button{
                width: 100%;
                font-size: 10px;
                color: #fff;
                background: #0d0e0dee;
            }
        }
        .register{
            text-align: center;
            font-size: 10px;
            color: #aaa;
            span:hover{
                color: #000;
            }
            .router-link{
                margin-top: -3px;
            }
        }
        // .other{
        //     hr{
        //         margin-top: 10px;
        //     }
        //     .text{
        //         text-align: center;
        //         font-size: 10px;
        //         margin-top: 10px;
        //     }
        //     .loginWay{
        //         float: left;
        //        div{
        //         float: left;
        //        }
        //     }
        // }
        
        
    }
}
</style>