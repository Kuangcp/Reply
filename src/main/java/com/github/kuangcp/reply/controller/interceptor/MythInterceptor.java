package com.github.kuangcp.reply.controller.interceptor;

import lombok.extern.log4j.Log4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by mythos on 17-4-26.
 * 自定义拦截器，这个是可以拦截所有请求，记录请求URL，时间等信息
 */
@Log4j
public class MythInterceptor extends HandlerInterceptorAdapter{
    //请求进入前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);

        String path = request.getServletPath();
        HttpSession session = request.getSession();
        if(path.startsWith("/admin") && !path.equals("/admin/login")){
            if(session.getAttribute("adminId") == null){
                request.getRequestDispatcher("/admin/login").forward(request, response);
            }
        }
//        else if(path.startsWith("/student") && !path.equals("/student/login")){
//            if(session.getAttribute("studentId") == null){
//                request.getRequestDispatcher("/myth/student/login").forward(request, response);
//            }
//        }else if(path.startsWith("/teacher") && !path.equals("/teacher/login")){
//            System.out.println(session.getAttribute("teacherId"));
//            if(session.getAttribute("teacherId") == null){
//                request.getRequestDispatcher("/myth/teacher/login").forward(request, response);
//            }
//        }
        return true;
    }

    //请求结束后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long)request.getAttribute("startTime");
        request.removeAttribute("startTime");
        Long endTime = System.currentTimeMillis();
        log.info(request.getRequestURL()+"发起请求耗时:[ "+ (endTime - startTime) +" ms] "+request.getServletPath());
    }


}
