package com.github.kuangcp.reply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by https://github.com/kuangcp on 17-10-10  上午9:07
 */
@Controller
@RequestMapping("/teacher")
public class TeacherRouteController {

    @RequestMapping()
    public String teacher(){
        return "teacher/teacher";
    }
    @RequestMapping("/PublishMajor")
    public String push(){
        return "teacher/PublishMajor";
    }
    @RequestMapping("/init")
    public String init(){
        return "teacher/init";
    }
    @RequestMapping("/DealMajor")
    public String deal(){
        return "teacher/DealMajor";
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
