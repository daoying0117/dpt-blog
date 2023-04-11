package ink.zyp.server.config;

import cn.dev33.satoken.exception.NotLoginException;
import ink.zyp.server.common.JsonResult;
import ink.zyp.server.controller.admin.AdminController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author daoying
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public JsonResult notLoginException(NotLoginException e){
        log.warn("NotLoginException : ",e);
        return JsonResult.fail("当前账户未登录,请登录后再试",401);
    }

    @ExceptionHandler
    public JsonResult exceptionHandler(Exception e){
        log.error("global except : ",e);
        return JsonResult.fail(e.getMessage());
    }
}
