package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by https://github.com/kuangcp on 17-12-4  下午5:36
 *
 * @author kuangcp
 */
@Data
@Entity
public class SelectTopic {

    @Id
    @GeneratedValue
    private long selectId;
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student studentId;
    @ManyToOne
    @JoinColumn(name = "topicId")
    private Topic topicId;
    private String comment;//注释

    private String reply;// 1  0
    private String replyComment;

}
