package com.graduation.sportstest.config;

import com.graduation.sportstest.interceptor.SessionInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@Configuration
@Slf4j
public class SessionConfig extends WebMvcConfigurerAdapter {
    @Resource(name="loginInterceptor")
    private SessionInterceptor sessionInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("SessionConfig used");
        registry.addInterceptor(sessionInterceptor)
//                .excludePathPatterns("/sports")
                .addPathPatterns("/sports/*")
                .excludePathPatterns("/assetslogin/*");
        super.addInterceptors(registry);
    }
}
