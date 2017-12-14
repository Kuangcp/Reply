package com.github.kuangcp.reply.service;

import com.github.kuangcp.reply.config.bean.MainConfig;
import com.github.kuangcp.reply.dao.SelectTopicDao;
import com.github.kuangcp.reply.dao.StudentDao;
import com.github.kuangcp.reply.dao.TopicDao;
import com.github.kuangcp.reply.domain.SelectTopic;
import com.github.kuangcp.reply.domain.Student;
import com.github.kuangcp.reply.domain.Topic;
import com.github.kuangcp.reply.service.base.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by https://github.com/kuangcp on 17-12-5  上午9:35
 *
 * @author kuangcp
 */
@Service
public class StudentService {

    @Autowired
    MainConfig mainConfig;
    @Autowired
    RoleService roleService;
    @Autowired
    StudentDao studentDao;
    @Autowired
    TopicDao topicDao;

    @Autowired
    SelectTopicDao selectTopicDao;

    public String login(long id, String password){
        return roleService.login(id, password, studentDao);
    }

    /**
     * 分页查询出所有
     */
    public Page<Topic> listTopic(int page, int size){
        Pageable pageable = new PageRequest(page, size);
        return topicDao.listTopic(new Student(mainConfig.defaultTopicStudentId), pageable);
    }
    public List<SelectTopic> listTopicAlready(long studentId){
//        Pageable pageable = new PageRequest(page, size);
        return selectTopicDao.findAllByStudentId(new Student(studentId));
    }

    /**
     * 按名字查询
     */
    public Page<Topic> listTopicByName(int page, int size, String name){
        Pageable pageable = new PageRequest(page, size);
        return topicDao.listTopicByName(name,new Student(mainConfig.defaultTopicStudentId), pageable);
    }

    /**
     * 学生选题 判断是否有选题,然后回复相应的消息
     * @return Already/id 已经选了一个题目/选题成功
     */
    public String saveSelect(long studentId, long topicId, String comment){
        Student student = new Student(studentId);
        Topic topic = new Topic(topicId);
        // 更改选题机制,由原先的限制重复提交改成了只能选一个题目
        //        SelectTopic selectTopic = selectTopicDao.findByStudentIdAndTopicId(student, topic);
        SelectTopic selectTopic = selectTopicDao.findByStudentId(student);
        if(selectTopic!=null){
            return "Already";
        }else{
            return selectTopicDao.save(new SelectTopic(student, topic, comment)).getSelectId()+"";
        }
    }
}
