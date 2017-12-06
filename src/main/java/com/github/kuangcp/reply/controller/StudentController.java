package com.github.kuangcp.reply.controller;

import com.github.kuangcp.reply.config.bean.MainConfig;
import com.github.kuangcp.reply.domain.Topic;
import com.github.kuangcp.reply.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    MainConfig mainConfig;
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

    // page 0开始 size 页大小
//    @RequestMapping("/ChooseTopic")
//    public ModelAndView ChooseTopicInit(){
//        return choosePage(0);
//    }
    @RequestMapping("/ChooseTopic/{page}")
    public ModelAndView ChooseTopic(@PathVariable("page") int page){
        return choosePage(page);
    }
    @RequestMapping("/ChooseTopic/q")
    public ModelAndView queryTopic(){
        int page = 0;
        String name = "<>>>>><<<<";
        ModelAndView view = new ModelAndView("student/SearchTopic");
        Page<Topic> lists = studentService.listTopicByName(page, mainConfig.chooseTopicPageSize, name);
        view.addObject("topicList", lists);
        view.addObject("pageNum", page+1);
        view.addObject("pageTotal", lists.getTotalPages());
        return view;
    }
    // 搜索
    @RequestMapping("/ChooseTopic/q/{page}")
    public ModelAndView queryTopic(@PathVariable("page") int page, String name){
        ModelAndView view = new ModelAndView("student/SearchTopic");
        Page<Topic> lists = studentService.listTopicByName(page, mainConfig.chooseTopicPageSize, name);
        view.addObject("topicList", lists);
        view.addObject("pageNum", page+1);
        view.addObject("pageTotal", lists.getTotalPages());
        return view;
    }

    // TODO 学生选题
    @RequestMapping("/ChooseTopic/f/{topicId}")
    public String choose(@PathVariable("topicId") long topicId){

        return "";
    }

    @RequestMapping("/SearchTopic")
    public String SearchTopic(){
        return "student/SearchTopic";
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

    private ModelAndView choosePage(int page){
        if(page < 0){
            page = 0;
        }
        ModelAndView view = new ModelAndView("student/ChooseTopic");
        Page<Topic> lists = studentService.listTopic(page, mainConfig.chooseTopicPageSize);
        view.addObject("topicList", lists);
        view.addObject("pageNum", page+1);
        view.addObject("pageTotal", lists.getTotalPages());
        return view;
    }
}
