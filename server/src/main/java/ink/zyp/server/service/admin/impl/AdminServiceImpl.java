package ink.zyp.server.service.admin.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ink.zyp.server.mapper.admin.AdminMapper;
import ink.zyp.server.model.admin.Admin;
import ink.zyp.server.service.admin.AdminService;
import org.springframework.stereotype.Service;

/**
 * 管理员service实现类
 * @author daoying
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper,Admin> implements AdminService {
    @Override
    public boolean checkAdminName(String name) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        return this.count(wrapper) > 0;
    }

    @Override
    public Admin checkLogin(String name, String password) {
        //对密码进行加密
        password = SecureUtil.md5(password);
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        wrapper.eq("password",password);
        wrapper.last("LIMIT 1");
        return this.getOne(wrapper);
    }
}
