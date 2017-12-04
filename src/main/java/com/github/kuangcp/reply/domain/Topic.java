package com.github.kuangcp.reply.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by https://github.com/kuangcp on 17-11-26  下午9:27
 * 课题 将学生放在课题表中
 * @author kuangcp
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Topic implements Serializable {
    @Id
    @GeneratedValue
    private long topicId;
    private String name;
    @Column(columnDefinition = "text comment '论文要求'")
    private String attention;//论文要求
    private int publishYear;//出题年份

    private int checked;//是否审核通过 1 0 审核通过后，不能删除和修改
    private String checkAdvise;// 审核意见

    @ManyToOne
    @JoinColumn(name = "guideId")
    private Teacher guideId;//出题教师

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student studentId;//选题学生Id

    private int guideScore;//指导教师评分
    private String guideAdvise;//指导教师意见
    private int judgeScore;//评审教师评分
    private String judgeAdvise;//评审教师意见

    public Topic(long topicId) {
        this.topicId = topicId;
    }
    // TODO 这里的分数是冗余的数据，插入记得要插入两个地方

}
