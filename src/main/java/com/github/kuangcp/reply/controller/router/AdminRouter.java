package com.github.kuangcp.reply.controller.router;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by https://github.com/kuangcp on 17-12-30  下午8:26
 *
 * @author kuangcp
 */
@Controller
@RequestMapping("/admin")
public class AdminRouter {
    @RequestMapping()
    public String index(){
        System.out.println(908999090);
        return "admin/admin";
    }
//    @RequestMapping("/admin")
//    public String index2(){
//        return "admin/admin";
//    }

}
