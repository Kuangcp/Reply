package com.github.kuangcp.reply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by https://github.com/kuangcp on 17-10-10  下午3:11
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping()
    public String defaults(){
        return "admin/admin";
    }
    @RequestMapping("/login")
    public String login(){
        return "admin/login";
    }



}
