package com.github.kuangcp.reply.service;

import com.github.kuangcp.reply.dao.SelectTopicDao;
import com.github.kuangcp.reply.dao.TopicDao;
import com.github.kuangcp.reply.domain.SelectTopic;
import com.github.kuangcp.reply.domain.Student;
import com.github.kuangcp.reply.domain.Teacher;
import com.github.kuangcp.reply.domain.Topic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by https://github.com/kuangcp on 17-12-4  下午4:06
 *
 * @author kuangcp
 */
@Slf4j
@Service
public class TopicService {

    @Autowired
    private TopicDao topicDao;
    @Autowired
    private SelectTopicDao selectTopicDao;


    public List<Topic> listTopicByTeacher(long teacherId){
        return topicDao.findAllByGuideId(new Teacher(teacherId));
    }

    /**
     * 查询某topic所有的学生申请,一旦有申请通过的,就不返回数据,返回null
     * @param topicId  课题
     * @return list or nul
     */
    public List<SelectTopic> listSelectTopicByTopic(long topicId){
//        List<SelectTopic> list = selectTopicDao.findAllByTopicId(new Topic(topicId));
        //        if(list!=null) {
//            for (SelectTopic selectTopic : list) {
//                if ("1".equals(selectTopic.getReply())) {
//                    return null;
//                }
                // 会出现并发异常
//                if ("2".equals(selectTopic.getReply()) || "0".equals(selectTopic.getReply())) {
//                    list.remove(selectTopic);
//                }
//            }
//        }
        return selectTopicDao.findAllByTopicId(new Topic(topicId));
    }
    public SelectTopic findSelectTopic(long studentId, long topicId) {
        Student student = new Student(studentId);
        Topic topic = new Topic(topicId);
        return selectTopicDao.findByStudentIdAndTopicId(student, topic);
    }

    /**
     * 选择某学生,拒绝其他学生
     * @param studentId
     * @param topicId
     * @param comment
     * @return
     */
    public String selectStudent(long studentId, long topicId, String comment){
        Topic topic = new Topic(topicId);
        Student student = new Student(studentId);
        SelectTopic result = selectTopicDao.findByStudentIdAndTopicId(student,topic);
        if(result!=null) {
            result.setReply("1");
            result.setReplyComment(comment);
            log.info(topic.getName() + " 拒绝其他选择学生:" + selectTopicDao.rejectOther(topicId) + "个");
            selectTopicDao.save(result);
            return "success";
        }else{
            return "fail";
        }
    }
    // 拒绝某学生
    public String rejectStudent(long studentId, long topicId, String comment){
        int result = selectTopicDao.rejectStudent(topicId, studentId, comment);
        if(result == 0 ){
            return "fail";
        }else{
            return "success";
        }
    }
}
