package com.github.kuangcp.reply.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by https://github.com/kuangcp on 17-12-4  下午5:36
 *
 * @author kuangcp
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    private String reply;// 是否通过申请 1  0
    private String replyComment;

    // 快速新增
    public SelectTopic(Student studentId, Topic topicId, String comment){
        this.studentId = studentId;
        this.topicId = topicId;
        this.comment = comment;

    }



}
