<template>
    <div class="login-container">
        <el-card>
            <div class="title">
                Dpt
            </div>
            <el-form
                ref="ruleFormRef"
                :model="ruleForm"
                status-icon
                :rules="rules"
                class="demo-ruleForm"
            >
                <el-form-item>
                    <el-input
                        v-model="username"
                        placeholder="用户名"
                        :prefix-icon="User"
                    />
                </el-form-item>
                <el-form-item>
                    <el-input
                        v-model="password"
                        placeholder="密码"
                        :prefix-icon="Lock"
                        show-password
                    />
                </el-form-item>
                <el-form-item>
                    <el-button @click="submitForm(ruleFormRef)"
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
import { reactive,ref } from 'vue'
import {Lock,User} from '@element-plus/icons-vue'
import type { FormInstance, FormRules } from 'element-plus'
import { useRoute, useRouter } from 'vue-router'

// 路由跳转
const router = useRouter()

// 表单校验
const ruleFormRef = ref<FormInstance>()
const ruleForm = ref({
    username:'',
    password:''
})
// 校验规则
const rules = ref<FormRules>({
    // 用户名
    username: [
        {
        required: true,
        message: 'username must be a string',
        trigger: 'blur',
        },
    ],
    // 密码
    password: [
        { required: true, message: 'password must be a number', trigger: 'blur' },
        { min: 6, max: 12, message: 'Length should be 6 to 12', trigger: 'blur' },
    ],

})

const submitForm = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
        if (valid) {
        console.log('submit!')
        } else {
        console.log('error submit!', fields)
        }
    })
    // 登录成功后 跳转首页
    router.push({ path: '/home'})

}

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}
// 用户名默认为空
const username = ref('')
// 密码默认为空
const password = ref('')
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