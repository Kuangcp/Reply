package com.github.kuangcp.reply.controller.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by https://github.com/kuangcp on 17-12-5  下午3:23
 *
 * @author kuangcp
 */
@Slf4j
public class AdminInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return super.preHandle(request, response, handler);
    }
}
