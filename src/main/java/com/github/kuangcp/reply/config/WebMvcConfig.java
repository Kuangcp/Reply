package com.github.kuangcp.reply.config;

import com.github.kuangcp.reply.controller.interceptor.AdminInterceptor;
import com.github.kuangcp.reply.controller.interceptor.MythInterceptor;
import com.github.kuangcp.reply.controller.interceptor.StudentInterceptor;
import com.github.kuangcp.reply.controller.interceptor.TeacherInterceptor;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Myth on 2017/4/23
 * MVC 配置
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/ws").setViewName("ws");
//        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/chat").setViewName("chat");
//    }

    //自定义拦截器bean
    @Bean
    public MythInterceptor mythInterceptor(){return new MythInterceptor();}
    @Bean
    public AdminInterceptor adminInterceptor(){return new AdminInterceptor();}
    @Bean
    public TeacherInterceptor teacherInterceptor(){return new TeacherInterceptor();}
    @Bean
    public StudentInterceptor studentInterceptor(){return new StudentInterceptor();}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminInterceptor()).addPathPatterns("/admin/**");
        registry.addInterceptor(teacherInterceptor()).addPathPatterns("/teacher/**");
        registry.addInterceptor(studentInterceptor()).addPathPatterns("/student/**");
        registry.addInterceptor(mythInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    // 自定义错误页面 需要放在静态资源下面
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.FORBIDDEN, "/500.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }
}
