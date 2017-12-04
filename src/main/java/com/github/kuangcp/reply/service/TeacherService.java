package com.github.kuangcp.reply.service;

import com.github.kuangcp.reply.dao.TopicDao;
import com.github.kuangcp.reply.domain.Student;
import com.github.kuangcp.reply.domain.Teacher;
import com.github.kuangcp.reply.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * Created by https://github.com/kuangcp on 17-12-4  下午12:16
 *
 * @author kuangcp
 */
@Service
public class TeacherService {

    @Autowired
    private TopicDao topicDao;

    public Topic saveTopic(Topic topic, long teacherId){
        topic.setGuideId(new Teacher(teacherId));
        topic.setPublishYear(Calendar.getInstance().get(Calendar.YEAR));
        topic.setStudentId(new Student(1L));
        return topicDao.save(topic);
    }


}
