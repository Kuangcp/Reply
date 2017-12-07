package com.github.kuangcp.reply.service;

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

/**
 * Created by https://github.com/kuangcp on 17-12-5  上午9:35
 *
 * @author kuangcp
 */
@Service
public class StudentService {

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
        return topicDao.listTopic(pageable);
    }

    /**
     * 按名字查询
     */
    public Page<Topic> listTopicByName(int page, int size, String name){
        Pageable pageable = new PageRequest(page, size);
        return topicDao.listTopicByName(name, pageable);
    }
    // 选题
    public SelectTopic saveSelect(long studentId, long topicId, String comment){
        return selectTopicDao.save(new SelectTopic(new Student(studentId), new Topic(topicId), comment));
    }



}
