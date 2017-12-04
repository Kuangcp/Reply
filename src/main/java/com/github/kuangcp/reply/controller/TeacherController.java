package com.github.kuangcp.reply.controller;

import com.github.kuangcp.reply.dao.TopicDao;
import com.github.kuangcp.reply.domain.Topic;
import com.github.kuangcp.reply.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by https://github.com/kuangcp on 17-12-4  上午10:57
 * 教师业务控制器
 * @author kuangcp
 */
@Slf4j
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    TopicDao topicDao;

    @RequestMapping("/addTopic")
    public String addTopic(Topic topic, HttpSession session){

        long teacherId = 1L;
//        long teacherId = (long) session.getAttribute("teacherId");
        log.info(teacherService.saveTopic(topic, teacherId).toString());
        return "redirect:/teacher/PublishTopic";
    }
    @RequestMapping("/editTopic/{topicId}")
    public ModelAndView editTopic(@PathVariable("topicId") Long topicId){
        ModelAndView view = new ModelAndView("/teacher/PublishTopic");
        Topic topic = topicDao.getOne(topicId);
        view.addObject("topicId", topicId);
        view.addObject("name", topic.getName());
        view.addObject("content", topic.getAttention());
        return view;
    }
    @ResponseBody
    @RequestMapping("/del/topic/{topicId}")
    public String deleteTopic(@PathVariable("topicId")Long topicId){
        topicDao.delete(topicId);
        return "1";
    }


}
