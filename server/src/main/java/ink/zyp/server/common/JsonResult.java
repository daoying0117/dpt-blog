package ink.zyp.server.common;

import com.alibaba.fastjson.JSON;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author daoying
 * 返回结果封装
 * TODO 代码重构
 */
public class JsonResult {

    /**
     * 是否查询成功
     */
    private boolean ok = false;

    /**
     * 返回码
     */
    private Object code = 200;

    /**
     * 错误消息
     */
    private String msg;

    /**
     * 查询结果
     */
    private Object data;

    /**
     * data 使用
     */
    private Map<String, Object> map;

    /**
     * 私有化构造
     */
    private JsonResult(boolean ok) {
        this.ok = ok;
    }

    // ==================get重写======================
    public boolean isOk() {
        return ok;
    }

    public Object getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    // ==================链式函数======================
    public JsonResult setOk(boolean ok) {
        this.ok = ok;
        return this;
    }

    public JsonResult code(Object code) {
        if (Objects.nonNull(code)) {
            this.code = code;
        }
        return this;
    }

    public JsonResult msg(String msg) {
        this.msg = msg;
        return this;
    }

    public JsonResult data(Object data) {
        this.data = data;
        return this;
    }

    public JsonResult data(String key, Object value) {
        if (Objects.isNull(this.map)) {
            if (Objects.nonNull(this.data)) {
                this.map = (Map<String, Object>) this.data;
            } else {
                this.map = new LinkedHashMap<>();
            }
            this.data = this.map;
        }
        map.put(key, value);
        return this;
    }

    // ==================工具方法======================
    public static JsonResult create(boolean ok) {
        return new JsonResult(ok).code(200);
    }

    public static JsonResult ok() {
        return new JsonResult(true).code(200);
    }

    public static JsonResult ok(Object data) {
        return ok().data(data);
    }

    public static JsonResult fail() {
        return new JsonResult(false).code(400);
    }

    public static JsonResult fail(String msg) {
        return fail().msg(msg);
    }

    public static JsonResult fail(String msg, Object code) {
        return new JsonResult(false).msg(msg).code(code);
    }


    public String toJson() {
        return JSON.toJSONString(this);
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "ok=" + ok +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", map=" + map +
                '}';
    }
}
