package ink.zyp.server.controller.admin;

import cn.dev33.satoken.stp.StpUtil;
import ink.zyp.server.common.JsonResult;
import ink.zyp.server.model.admin.Admin;
import ink.zyp.server.request.admin.AdminRegister;
import ink.zyp.server.service.admin.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @Resource
    private AdminService adminService;

    /**
     * 读取是否开启验证码
     */
    @Value("${system.verification:false}")
    private boolean verificationCode;

    @ApiOperation("管理员注册")
    @PostMapping("/register")
    public JsonResult register(AdminRegister admin){

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
            return JsonResult.ok("注册成功");
        }

        return JsonResult.fail("注册失败");
    }

    @ApiOperation("管理员登录")
    @GetMapping("/login")
    public JsonResult login(
            @RequestParam(name = "用户名") String name,
            @RequestParam(value = "密码") String password,
            @RequestParam(value = "验证码",required = false) String code
    ){
        if (verificationCode){
            //TODO 验证码校验
        }

        //登录校验
        Admin admin = adminService.checkLogin(name, password);
        if (Objects.isNull(admin)){
            return JsonResult.fail("账号或密码错误");
        }

        //登录
        StpUtil.login(admin.getId());

        return JsonResult.ok("登录成功");
    }

}
