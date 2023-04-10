package ink.zyp.server.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import ink.zyp.server.model.admin.Admin;

/**
 * 管理员service
 * @author daoying
 */
public interface AdminService extends IService<Admin> {

    /**
     * 检查管理员账号是否存在
     * @param name 账号
     * @return boolean
     */
    boolean checkAdminName(String name);

    /**
     * 登录方法
     * @param name 账号
     * @param password 密码
     * @return Admin
     */
    Admin checkLogin(String name, String password);
}
