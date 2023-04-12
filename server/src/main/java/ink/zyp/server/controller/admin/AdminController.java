package ink.zyp.server.controller.admin;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import ink.zyp.server.common.JsonResult;
import ink.zyp.server.dto.admin.AdminLogin;
import ink.zyp.server.dto.admin.AdminLoginResponese;
import ink.zyp.server.model.admin.Admin;
import ink.zyp.server.dto.admin.AdminConfig;
import ink.zyp.server.dto.admin.AdminRegister;
import ink.zyp.server.service.admin.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 管理员控制器
 * @author daoying
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "管理员接口")
public class AdminController {

    private final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Resource
    private AdminService adminService;

    /**
     * 读取是否开启验证码
     */
    @Value("${system.verification:false}")
    private boolean verificationCode;

    @ApiOperation("管理员注册")
    @PostMapping("/register")
    public JsonResult register(@RequestBody AdminRegister admin){

        //校验参数
        if (Objects.nonNull(admin)){
            if(!admin.checkParams()){
                return JsonResult.fail("参数错误");
            }
        }

        //检查账户是否存在
        if (adminService.checkAdminName(admin.getName())){
            return JsonResult.fail("账户已存在");
        }

        //注册
        if (adminService.save(Admin.registerToAdmin(admin))){
            log.info("管理员{}注册成功",admin.getName());
            return JsonResult.ok().msg("注册成功");
        }

        return JsonResult.fail("注册失败");
    }

    @ApiOperation("管理员登录")
    @PostMapping("/login")
    public JsonResult login(@RequestBody AdminLogin login){
        if (verificationCode){
            //TODO 验证码校验
        }

        //登录校验
        Admin admin = adminService.checkLogin(login.getUsername(), login.getPassword());
        if (Objects.isNull(admin)){
            log.warn("登录错误账户为: {}",login.getUsername());
            return JsonResult.fail("账号或密码错误");
        }

        //登录
        StpUtil.login(admin.getId());
        log.info("管理员{}登录成功",admin.getName());

        return JsonResult.ok(AdminLoginResponese.adminToRespone(admin)).msg("登录成功");
    }

    @ApiOperation("更新管理员配置")
    @PostMapping("/updateAdminInfo")
    @SaCheckLogin
    public JsonResult updateAdminInfo(@RequestBody AdminConfig config){

        if (Objects.nonNull(config)){
            //校验参数
            if(!config.checkParams()){
                return JsonResult.fail("参数错误");
            }

            //更新数据
            if (adminService.updateById(Admin.configToAdmin(config))) {
                return JsonResult.ok().msg("更新成功");
            }
        }
        return JsonResult.fail("更新失败");
    }

    @ApiOperation("获取当前管理员配置")
    @GetMapping("/getAdminConfig")
    @SaCheckLogin
    public JsonResult getAdminConfig(){
        Object loginId = StpUtil.getLoginId();
        if (loginId instanceof String){
            Admin admin = adminService.getById((String)loginId);
            if (Objects.nonNull(admin)){
                return JsonResult.ok(Admin.adminToConfig(admin));
            }
        }else {
            log.warn("获取管理员配置失败，登录id为null");
        }

        return JsonResult.ok();
    }

}
