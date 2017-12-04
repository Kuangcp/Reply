package com.github.kuangcp.reply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by https://github.com/kuangcp on 17-10-10  上午9:07
 * 仅仅负责模板的跳转
 */
@Controller
@RequestMapping("/teacher")
public class TeacherRouteController {

    @RequestMapping()
    public String teacher(){
        return "teacher/teacher";
    }
    @RequestMapping("/PublishTopic")
    public String push(){
        return "teacher/PublishTopic";
    }
    @RequestMapping("/init")
    public String init(){
        return "teacher/init";
    }
    @RequestMapping("/DealTopic")
    public String deal(){
        return "teacher/DealTopic";
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
