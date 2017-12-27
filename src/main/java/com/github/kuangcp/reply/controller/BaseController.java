package com.github.kuangcp.reply.controller;

import com.github.kuangcp.reply.config.bean.MainConfig;
import com.github.kuangcp.reply.service.AdminService;
import com.github.kuangcp.reply.service.StudentService;
import com.github.kuangcp.reply.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by https://github.com/kuangcp on 17-12-4  下午3:18
 *
 * @author kuangcp
 */
@Slf4j
@Controller
public class BaseController {

    @Autowired
    MainConfig mainConfig;
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;
    @Autowired
    AdminService adminService;


    @RequestMapping("/")
    public String index1(){
        return "index";
    }
    @RequestMapping("/index")
    public String index2(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 登录，一个入口登录三个角色
     * @param name 用户名
     * @param password 密码
     * @param session serssion
     * @return 跳转页面
     */
    @RequestMapping("/signin/{type}")
    public String login(@PathVariable("type") String type, String name, String password, HttpSession session) {
        log.info("登录："+type+":" + name + ":" + password);
        long id;
        try {
            id = Long.parseLong(name);
        } catch (Exception e) {
            return "redirect:/"+type+"/login?error=true";
        }
        String username;
        if (mainConfig.loginTypeTea.equals(type)) {
            username = teacherService.login(id, password);
            if (!mainConfig.loginFail.equals(username)) {
                session.setAttribute("teacherId", id);
                session.setAttribute("teacherName", username);
                return "redirect:/teacher";
            }else {
                return "redirect:/teacher/login?error=true";
            }
        } else if (mainConfig.loginTypeStu.equals(type)) {
            username = studentService.login(id, password);
            if (!mainConfig.loginFail.equals(username)) {
                session.setAttribute("studentId", id);
                session.setAttribute("studentName", username);
                return "redirect:/student";
            }else {
                return "redirect:/student/login?error=true";
            }
        } else if (mainConfig.loginTypeAdmin.equals(type)) {
            username = adminService.login(id, password);
            if (!mainConfig.loginFail.equals(username)) {
                session.setAttribute("adminId", id);
                session.setAttribute("adminName", username);
                return "redirect:/admin";
            }else{
                return "redirect:/admin/login?error=true";
            }
        }
        return "/";
    }
    @RequestMapping("/logout/{type}")
    public String logout(@PathVariable("type")String type){
        return "index";
    }
}
