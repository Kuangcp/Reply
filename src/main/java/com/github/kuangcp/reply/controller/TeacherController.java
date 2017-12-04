package com.github.kuangcp.reply.controller;

import com.github.kuangcp.reply.domain.Topic;
import com.github.kuangcp.reply.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/addTopic")
    public String addTopic(Topic topic, HttpSession session){
        long teacherId = 0L;
//        long teacherId = (long) session.getAttribute("teacherId");
        log.info(teacherService.saveTopic(topic, teacherId).toString());
        return "redirect:teacher/PublishTopic";
    }
}
