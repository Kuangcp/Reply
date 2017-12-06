package com.github.kuangcp.reply.dao;

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

    @Query("select t from Topic t")
    Page<Topic> listTopic(Pageable pageable);

    @Query("select t from Topic t where t.name=?1")
    Page<Topic> listTopicByName(String name, Pageable pageable);


}
