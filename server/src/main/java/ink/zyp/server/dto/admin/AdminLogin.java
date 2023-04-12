package ink.zyp.server.dto.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 管理员登录请求实体
 * @author daoying
 */

@ApiModel("管理员登录请求实体")
public class AdminLogin {

    @ApiParam(value = "用户名",required = true)
    private String username;

    @ApiParam(value = "密码",required = true)
    private String password;

    @ApiParam(value = "验证码")
    private String code;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
