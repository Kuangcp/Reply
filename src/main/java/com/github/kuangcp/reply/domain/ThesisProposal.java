package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by https://github.com/kuangcp on 17-12-3  下午9:05
 * 开题报告表，多次提交的记录
 * @author kuangcp
 */
@Data
@Entity
public class ThesisProposal implements Serializable{

    @Id
    @GeneratedValue
    private long proposalId;
    @ManyToOne
    @JoinColumn(name = "topicId")
    private Topic topicId;
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student studentId;//冗余字段，方便查询 课题中就包含了

    private String submitDate;//提交日期
    private String comment; // 学生提交
    private String docURL; // 文件的URL
    private String reply; // 回复
    private int finished; // 是否通过 1 0
    private int score; // 评分
    // TODO 分数统一采用整数百分制？
}
