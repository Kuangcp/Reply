package com.github.kuangcp.reply.controller;

import com.github.kuangcp.reply.domain.SelectTopic;
import com.github.kuangcp.reply.domain.Topic;
import com.github.kuangcp.reply.service.TeacherService;
import com.github.kuangcp.reply.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by https://github.com/kuangcp on 17-10-10  上午9:07
 * 仅仅负责模板的跳转
 */
@Controller
@RequestMapping("/teacher")
public class TeacherRouteController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    TopicService topicService;

    @RequestMapping()
    public String teacher(){
        return "teacher/teacher";
    }
    @RequestMapping("/PublishTopic")
    public String publish(){


        return "/teacher/PublishTopic";
    }
    @RequestMapping("/init")
    public String init(){
        return "teacher/init";
    }

    /**
     * 展示课题
     * @param session
     */
    @RequestMapping("/DealTopic")
    public ModelAndView deal(HttpSession session){
//        long teacherId = (long) session.getAttribute("teacherId");
        long teacherId = 1L;
        List<Topic> topicList = topicService.listTopicByTeacher(teacherId);
        ModelAndView view = new ModelAndView("teacher/DealTopic");

        Map<Long, List<SelectTopic>> studentList = new HashMap<>();
        for(Topic topic:topicList){
            studentList.put(topic.getTopicId(), topicService.listSelectTopicByTopic(topic.getTopicId()));
        }

        view.addObject("topicList", topicList);
        view.addObject("stuList", studentList);
        return view;
//        return "teacher/DealTopic";
    }
    @RequestMapping("/ThesisProposal")
    public String ThesisProposal(){
        return "teacher/ThesisProposal";
    }

    @RequestMapping("/ThesisProposalScore")
    public String ThesisProposalScore(){
        return "teacher/ThesisProposalScore";
    }

    @RequestMapping("/ThesisDefense")
    public String ThesisDefense(){
        return "/teacher/ThesisDefense";
    }
    @RequestMapping("/ThesisDefenseScore")
    public String ThesisDefenseScore(){
        return "/teacher/ThesisDefenseScore";
    }
}
