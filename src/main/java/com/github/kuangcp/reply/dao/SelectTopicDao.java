package com.github.kuangcp.reply.dao;

import com.github.kuangcp.reply.domain.SelectTopic;
import com.github.kuangcp.reply.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by https://github.com/kuangcp on 17-12-4  下午9:11
 *
 * @author kuangcp
 */
public interface SelectTopicDao extends JpaRepository<SelectTopic, Long>{
    List<SelectTopic> findAllByTopicId(Topic topic);
}
