package com.github.kuangcp.reply.service;

import com.github.kuangcp.reply.dao.SelectTopicDao;
import com.github.kuangcp.reply.dao.TopicDao;
import com.github.kuangcp.reply.domain.SelectTopic;
import com.github.kuangcp.reply.domain.Teacher;
import com.github.kuangcp.reply.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by https://github.com/kuangcp on 17-12-4  下午4:06
 *
 * @author kuangcp
 */
@Service
public class TopicService {

    @Autowired
    private TopicDao topicDao;
    @Autowired
    private SelectTopicDao selectTopicDao;


    public List<Topic> listTopicByTeacher(long teacherId){
        return topicDao.findAllByGuideId(new Teacher(teacherId));
    }
    public List<SelectTopic> listSelectTopicByTopic(long topicId){
        return selectTopicDao.findAllByTopicId(new Topic(topicId));

    }
}
