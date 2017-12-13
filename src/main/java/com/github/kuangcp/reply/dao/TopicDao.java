package com.github.kuangcp.reply.dao;

import com.github.kuangcp.reply.domain.Student;
import com.github.kuangcp.reply.domain.Teacher;
import com.github.kuangcp.reply.domain.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by https://github.com/kuangcp on 17-12-4  下午12:17
 *
 * @author kuangcp
 */
public interface TopicDao extends JpaRepository<Topic, Long>{

    List<Topic> findAllByGuideId(Teacher guideId);

    /**
     * 列出没有被确定好的题目 学生id非默认 采用一次制，先到先得，一个题目只能一个人选，选完题目就没了，而且不能继续选
     * @param studentId 默认学生的Id
     * @param pageable
     * @return
     */
    @Query(value = "select t from Topic t where t.studentId = ?1 and t.topicId not in (select topicId from SelectTopic)")
    Page<Topic> listTopic(Student studentId, Pageable pageable);

    // 查询课题 没有选好学生的才会出现
    @Query("select t from Topic t where t.name like %?1% and t.studentId = ?2 and t.topicId not in (select topicId from SelectTopic)")
    Page<Topic> listTopicByName(String name, Student studentId, Pageable pageable);


}
