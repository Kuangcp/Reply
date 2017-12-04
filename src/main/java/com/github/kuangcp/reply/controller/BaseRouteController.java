package com.github.kuangcp.reply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by https://github.com/kuangcp on 17-12-4  下午2:49
 *
 * @author kuangcp
 */
@Controller
public class BaseRouteController {

    @RequestMapping("/login")
    public String login(){
        return "/login";
    }
}
