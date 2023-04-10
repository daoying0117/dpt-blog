package ink.zyp.server.request.admin;

import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;

/**
 * 管理员注册请求实体
 * @author daoying
 */
public class AdminRegister {

    @ApiParam(value = "用户名",required = true)
    private String name;

    @ApiParam(value = "密码",required = true)
    private String password;

    @ApiParam(value = "二次确认密码",required = true)
    private String confirmPassword;

    @ApiParam(value = "邮件")
    private String email;

    @ApiParam(value = "手机号",required = true)
    private String phone;

    public boolean checkParams(){
        //TODO 检查邮箱格式

        //TODO 检查手机号格式

        if (StringUtils.isNotBlank(password)
                && StringUtils.isNotBlank(confirmPassword)
                && password.equals(confirmPassword)){
            return true;
        }

        //TODO 检查账户是否存在

        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
