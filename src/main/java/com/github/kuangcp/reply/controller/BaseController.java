package com.github.kuangcp.reply.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by https://github.com/kuangcp on 17-12-4  下午3:18
 *
 * @author kuangcp
 */
@Slf4j
@Controller
public class BaseController {

    @RequestMapping("/loginin")
    public String login(String name, String password){
        log.info(name+":"+password);
        return "redirect:/teacher";
    }
}
