package com.github.kuangcp.reply.dao;

import com.github.kuangcp.reply.domain.SelectTopic;
import com.github.kuangcp.reply.domain.Student;
import com.github.kuangcp.reply.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by https://github.com/kuangcp on 17-12-4  下午9:11
 *
 * @author kuangcp
 */
public interface SelectTopicDao extends JpaRepository<SelectTopic, Long>{
    List<SelectTopic> findAllByTopicId(Topic topic);
    SelectTopic findByStudentIdAndTopicId(Student studentId, Topic topicId);
    List<SelectTopic> findAllByStudentId(Student student);

    @Transactional
    @Modifying
    @Query(value = "update select_topic set reply='2' where topic_id=?1", nativeQuery = true)
    int rejectOther(long topicId);
    @Transactional
    @Modifying
    @Query(value = "update select_topic set reply='2' where topic_id=?1 and student_id=?2", nativeQuery = true)
    int rejectStudent(long topicId, long studentId);
}
