package com.github.kuangcp.reply.controller;

import com.github.kuangcp.reply.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by https://github.com/kuangcp on 17-10-10  上午9:47
 *
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping()
    public String defaults(){
        return "student/student";
    }

    @RequestMapping("/login")
    public String login(){
        return "/student/login";
    }

    // TODO 分页的简单实现
    // page 0开始 size 页大小
    @RequestMapping("/ChooseTopic/{size}/{page}")
    public ModelAndView ChooseMajor(@PathVariable("page") int page, @PathVariable("size") int size){
        ModelAndView view = new ModelAndView("student/ChooseTopic");
        view.addObject("topicList", studentService.listTopic(page, size));
        return view;
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
