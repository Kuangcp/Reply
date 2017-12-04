package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by https://github.com/kuangcp on 17-12-3  下午8:07
 * 答辩评分表
 * @author kuangcp
 */
@Data
@Entity
public class DefenseScore implements Serializable{

    @Id
    @GeneratedValue
    private long scoreId;
    private String advise; //评委意见，秘书记录
    private String accessory;//评委意见拍照，附件URL

    @ManyToOne
    @JoinColumn(name = "scheduleId")
    private DefenseSchedule scheduleId;//安排表
    @ManyToOne
    @JoinColumn(name = "topicId")
    private Topic topicId;//课题id
    @ManyToOne
    @JoinColumn(name = "recorder")
    private Teacher recorder;//记录人


    // TODO 各个评委评分 分数怎么处理 第三张表
    // TODO 每次答辩都要评分，一辩过了和三辩过了怎么评分
}
