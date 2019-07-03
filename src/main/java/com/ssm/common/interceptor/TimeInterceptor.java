package com.ssm.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * 时间拦截器
 */
@Slf4j
public class TimeInterceptor implements HandlerInterceptor {

    private static final String TIME_FILED_NAME = "controller.start.time";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(TIME_FILED_NAME, System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	Long startTime = (Long)(request.getAttribute(TIME_FILED_NAME));
        Long endTime = System.currentTimeMillis();
        Long executeTime = endTime - startTime;
        log.debug("{} 执行时间 {}", request.getRequestURI(), executeTime);
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
