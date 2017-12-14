package com.github.kuangcp.reply.controller;

import com.github.kuangcp.reply.config.bean.MainConfig;
import com.github.kuangcp.reply.domain.SelectTopic;
import com.github.kuangcp.reply.domain.Topic;
import com.github.kuangcp.reply.service.StudentService;
import com.github.kuangcp.reply.service.TopicService;
import com.github.kuangcp.reply.service.util.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    QueryUtil queryUtil;

    @Autowired
    StudentService studentService;
    @Autowired
    TopicService topicService;

    @RequestMapping()
    public String defaults(){
        return "student/student";
    }

    @RequestMapping("/login")
    public String login(){
        return "/student/login";
    }

    // 页面跳转进入的数据填充
    //page 0开始 size 页大小
    @RequestMapping("/ChooseTopic")
    public ModelAndView ChooseTopicInit(){
        return choosePage(0);
    }
    @RequestMapping("/ChooseTopic/{page}")
    public ModelAndView ChooseTopic(@PathVariable("page") int page){
        return choosePage(page);
    }
    // 查询课题进行选题
    @ResponseBody
    @RequestMapping("/ChooseTopic/q/{page}")
    public Page<Topic> queryTopic(@PathVariable("page") int page, String name){
        name = name.replace(' ', '%');
        return studentService.listTopicByName(page, mainConfig.chooseTopicPageSize, name);
    }
    @ResponseBody
    @RequestMapping("/AlreadyChoose/a")
    public List<SelectTopic> alreadySelect(HttpSession session){
        return studentService.listTopicAlready(queryUtil.getStudentId(session));
    }
    @ResponseBody
    @RequestMapping("/ReadReply/{topicId}")
    public SelectTopic readReply(@PathVariable("topicId") long topicId, HttpSession session){
        return topicService.findSelectTopic(queryUtil.getStudentId(session), topicId);
    }
    //学生选题 返回: Already failed id 表示: 已经选 失败 成功
    @ResponseBody
    @RequestMapping("/ChooseTopic/s/{topicId}")
    public String choose(@PathVariable("topicId") long topicId, String comment, HttpSession session){
        String result = studentService.saveSelect(queryUtil.getStudentId(session), topicId, comment);
        if(result==null || "".equals(result)){
            return mainConfig.loginFail;
        }else{
            return result;
        }
    }

    @RequestMapping("/SearchTopic")
    public String SearchTopic(){
        return "student/SearchTopic";
    }
    @RequestMapping("/DefenseProgress")
    public String DefenseProgress(){
        return "student/DefenseProgress";
    }
    @RequestMapping("/AlreadyChoose")
    public String AlreadyChoose(){
        return "student/AlreadyChoose";
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
        if(page < 0){page = 0;}
        ModelAndView view = new ModelAndView("student/ChooseTopic");
        Page<Topic> lists = studentService.listTopic(page, mainConfig.chooseTopicPageSize);
        view.addObject("topicList", lists);
        view.addObject("pageNum", page+1);
        view.addObject("pageTotal", lists.getTotalPages());
        return view;
    }
}
