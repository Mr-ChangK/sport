package com.graduation.sportstest.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
@Component("loginInterceptor")
@Slf4j
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("调用拦截器");
        Object session = request.getSession().getAttribute("user");
        if(Objects.isNull(session)){
            response.sendRedirect("/index");
            return false;
        }
        return true;
    }
}
