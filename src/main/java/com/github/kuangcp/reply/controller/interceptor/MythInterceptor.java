package com.github.kuangcp.reply.controller.interceptor;

import lombok.extern.log4j.Log4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mythos on 17-4-26.
 * 拦截所有请求进行记录
 */
@Log4j
public class MythInterceptor extends HandlerInterceptorAdapter{
    //请求进入前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }

    //请求结束后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long)request.getAttribute("startTime");
        request.removeAttribute("startTime");
        Long endTime = System.currentTimeMillis();
        log.info(request.getRequestURL()+"发起请求耗时:[ "+ (endTime - startTime) +" ms] ");
    }


}
