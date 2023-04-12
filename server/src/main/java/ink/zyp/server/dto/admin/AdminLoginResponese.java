package ink.zyp.server.dto.admin;

import cn.dev33.satoken.stp.StpUtil;
import ink.zyp.server.model.admin.Admin;

/**
 * 管理员登录响应实体
 * @author daoying
 */
public class AdminLoginResponese {

    private AdminConfig config;

    private String token;

    public static AdminLoginResponese adminToRespone(Admin admin){
        return new AdminLoginResponese(
                Admin.adminToConfig(admin), StpUtil.getTokenValue()
        );
    }

    public AdminLoginResponese(AdminConfig config, String token) {
        this.config = config;
        this.token = token;
    }

    public AdminLoginResponese() {
    }

    public AdminConfig getConfig() {
        return config;
    }

    public void setConfig(AdminConfig config) {
        this.config = config;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
