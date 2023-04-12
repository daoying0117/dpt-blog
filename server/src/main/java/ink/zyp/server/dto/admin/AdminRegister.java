package ink.zyp.server.dto.admin;

import ink.zyp.server.utils.DptReUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;

/**
 * 管理员注册请求实体
 * @author daoying
 */

@ApiModel("管理员注册请求实体")
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
        return StringUtils.isNotBlank(password)
                && StringUtils.isNotBlank(confirmPassword)
                && password.equals(confirmPassword)
                && DptReUtil.isSafePassword(password)
                && DptReUtil.isEmail(email)
                && DptReUtil.isPhone(phone);
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
