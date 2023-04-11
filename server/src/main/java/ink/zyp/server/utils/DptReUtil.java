package ink.zyp.server.utils;

/**
 * 正则工具类
 * @author daoying
 * 封装常用的正则表达式验证
 */
public class DptReUtil {

    /**
     * 验证字符串是否满足邮箱格式
     * @param email 邮箱字符串
     * @return boolean
     */
    public static boolean isEmail(String email){
        String regex = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        return email.matches(regex);
    }

    public static boolean isPhone(String phone){
        String regex = "^1[3-9]\\d{9}$";
        return phone.matches(regex);
    }

    /**
     * 验证密码中是否包含大小写字母&数字且长度在8-16位之间
     * @param password 密码
     * @return boolean
     */
    public static boolean isSafePassword(String password){
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[^/]{8,16}$";
        return password.matches(regex);
    }
}
