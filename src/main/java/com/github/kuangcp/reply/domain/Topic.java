package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private String limit;//论文要求
    private int year;//出题年份

    private int Checked;//是否审核通过 1 0
    private String checkAdvise;// 审核意见

    @ManyToOne
    @JoinColumn(name = "leaderId")
    private Teacher guideId;//出题教师

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student studentId;//选题学生Id

    private int guideScore;//指导教师评分
    private String guideAdvise;//指导教师意见
    private int judgeScore;//评审教师评分
    private String judgeAdvise;//评审教师意见
    // TODO 这里的分数是冗余的数据，插入记得要插入两个地方

}
