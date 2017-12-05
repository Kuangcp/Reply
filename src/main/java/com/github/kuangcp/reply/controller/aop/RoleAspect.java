package com.github.kuangcp.reply.controller.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by https://github.com/kuangcp on 17-12-5  下午12:34
 *
 * @author kuangcp
 */
@Slf4j
@Aspect
public class RoleAspect {

//    @Pointcut("execution(* com.github.kuangcp.reply.controller.AdminController.*(..))")
//    private void adminLogin(){
//
//    }
//    @Before("adminLogin()")
//    private Object validate(ProceedingJoinPoint point){
//
//        Object[] args = point.getArgs();
//        for (Object arg : args){
//            if(arg instanceof HttpServletRequest){
//                HttpSession session  = ((HttpServletRequest) arg).getSession();
//                if(session.getAttribute("adminId") == null){
//
//                    return "8";
//                }
//                try {
//                    point.proceed();
//                } catch (Throwable throwable) {
//                    throwable.printStackTrace();
//                }
//
//
//            }
//        }
//    }
}
