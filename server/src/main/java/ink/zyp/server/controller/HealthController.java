package ink.zyp.server.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 健康检查Controller
 * @author daoying
 */
@RestController
@RequestMapping("/health")
@Api("健康检查")
public class HealthController {

    @PostMapping("/check")
    public String check(){
        return "ok";
    }
}
