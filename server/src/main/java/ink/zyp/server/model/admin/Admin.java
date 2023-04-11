package ink.zyp.server.model.admin;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import ink.zyp.server.dto.admin.AdminConfig;
import ink.zyp.server.dto.admin.AdminRegister;

/**
 * @author daoying
 * 管理员信息实体
 */
@TableName("sys_admin")
public class Admin {
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 账号状态 0: 未初始化; 1: 正常; -1: 禁用
     */
    private Integer status;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 头像图片URL
     */
    private String headImg;

    /**
     * 错误登录次数
     */
    private Integer errorNum;

    /**
     * 是否是子账户
     */
    private Integer subAccount;

    /**
     * 背景图片
     */
    private String backImg;

    /**
     * 签名&描述
     */
    private String motto;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    public Admin() {
    }

    public Admin( String name, String password, Integer status, String nickName, String headImg, Integer errorNum, Integer subAccount, String backImg, String motto, String email, String phone) {
        this.name = name;
        this.password = password;
        this.status = status;
        this.nickName = nickName;
        this.headImg = headImg;
        this.errorNum = errorNum;
        this.subAccount = subAccount;
        this.backImg = backImg;
        this.motto = motto;
        this.email = email;
        this.phone = phone;
    }
    public static Admin registerToAdmin(AdminRegister register){
        return new Admin(
                register.getName(),
                SecureUtil.md5(register.getPassword()),
                0,
                "",
                "",
                0,
                0,
                "",
                "",
                register.getEmail(),
                register.getPhone()
        );
    }

    public Admin(Integer id, String name, String password, Integer status, String nickName, String headImg, Integer errorNum, Integer subAccount, String backImg, String motto, String email, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.status = status;
        this.nickName = nickName;
        this.headImg = headImg;
        this.errorNum = errorNum;
        this.subAccount = subAccount;
        this.backImg = backImg;
        this.motto = motto;
        this.email = email;
        this.phone = phone;
    }

    public static Admin configToAdmin(AdminConfig config) {
        return new Admin(
                config.getId(),
                null,
                null,
                null,
                config.getNickName(),
                config.getHeadImg(),
                null,
                null,
                config.getBackImg(),
                config.getMotto(),
                config.getEmail(),
                config.getPhone()
        );
    }

    public static AdminConfig adminToConfig(Admin admin) {
        return new AdminConfig(
                admin.getId(),
                admin.getNickName(),
                admin.getHeadImg(),
                admin.getBackImg(),
                admin.getMotto(),
                admin.getEmail(),
                admin.getPhone()
        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getSubAccount() {
        return subAccount;
    }

    public void setSubAccount(Integer subAccount) {
        this.subAccount = subAccount;
    }

    public String getBackImg() {
        return backImg;
    }

    public void setBackImg(String backImg) {
        this.backImg = backImg;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
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

    public Integer getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(Integer errorNum) {
        this.errorNum = errorNum;
    }
}
