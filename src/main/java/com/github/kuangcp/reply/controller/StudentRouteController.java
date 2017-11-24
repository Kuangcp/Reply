package com.github.kuangcp.reply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by https://github.com/kuangcp on 17-10-10  上午9:47
 */
@Controller
@RequestMapping("/student")
public class StudentRouteController {
    @RequestMapping()
    public String defaults(){
        return "student/student";
    }

    @RequestMapping("/ChooseMajor")
    public String ChooseMajor(){
        return "student/ChooseMajor";
    }

    @RequestMapping("/DefenseProgress")
    public String DefenseProgress(){
        return "student/DefenseProgress";
    }

    @RequestMapping("/init")
    public String init(){
        return "student/init";
    }
    @RequestMapping("/QueryScore")
    public String QueryScore(){
        return "student/QueryScore";
    }

    @RequestMapping("/ThesisDefense")
    public String ThesisDefense(){
        return "student/ThesisDefense";
    }
}
