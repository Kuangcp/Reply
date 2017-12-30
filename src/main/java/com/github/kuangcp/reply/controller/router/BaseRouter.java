package com.github.kuangcp.reply.controller.router;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by https://github.com/kuangcp on 17-12-30  下午8:33
 *
 * @author kuangcp
 */
@Controller
public class BaseRouter {

    @RequestMapping("/")
    public String indexs(){
        return "index";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
