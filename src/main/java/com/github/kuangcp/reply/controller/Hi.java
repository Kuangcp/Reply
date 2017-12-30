package com.github.kuangcp.reply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by https://github.com/kuangcp on 17-12-30  下午8:25
 *
 * @author kuangcp
 */
@Controller
public class Hi {
    @ResponseBody
    @RequestMapping("/hi")
    public String hi(){
        return "ui";
    }
}
