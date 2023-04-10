package ink.zyp.server.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * SaToken配置
 * @author daoying
 * @date 2023-04-10
 */
@Configuration
public class SaTokenConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(new SaInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login","/admin/register");
    }
}
