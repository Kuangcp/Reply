package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by https://github.com/kuangcp on 17-11-26  下午9:27
 *
 * @author kuangcp
 */
@Data
@Entity
public class Topic implements Serializable {
    @Id
    private long topicId;
    private String name;
}
