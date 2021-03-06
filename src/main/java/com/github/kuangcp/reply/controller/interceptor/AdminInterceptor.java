package com.github.kuangcp.reply.controller.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by https://github.com/kuangcp on 17-12-5  下午3:23
 *
 * @author kuangcp
 */
@Slf4j
public class AdminInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        if(path.startsWith("/admin") && !path.equals("/admin/login")){
            if(session.getAttribute("adminId") == null){
                request.getRequestDispatcher("/admin/login").forward(request, response);
            }
        }
        return super.preHandle(request, response, handler);
    }
}
