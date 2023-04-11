package ink.zyp.server.dto.admin;

import cn.dev33.satoken.stp.StpUtil;
import ink.zyp.server.utils.DptReUtil;
import io.swagger.annotations.ApiParam;

/**
 * 管理员信息配置请求实体
 * @author daoying
 */
public class AdminConfig {

    @ApiParam(value = "用户id",required = true)
    private Integer id;

    @ApiParam(value = "用户昵称")
    private String nickName;

    @ApiParam(value = "头像图片URL")
    private String headImg;

    @ApiParam(value = "背景图片")
    private String backImg;

    @ApiParam(value = "签名&描述")
    private String motto;

    @ApiParam(value = "邮箱")
    private String email;

    @ApiParam(value = "手机号")
    private String phone;


    public AdminConfig() {
    }

    public AdminConfig(Integer id, String nickName, String headImg, String backImg, String motto, String email, String phone) {
        this.id = id;
        this.nickName = nickName;
        this.headImg = headImg;
        this.backImg = backImg;
        this.motto = motto;
        this.email = email;
        this.phone = phone;
    }

    public boolean checkParams(){
        return DptReUtil.isEmail(email) && DptReUtil.isPhone(phone) && id.equals(StpUtil.getLoginId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
