package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by https://github.com/kuangcp on 17-12-3  下午7:35
 * 答辩安排表
 * @author kuangcp
 */
@Data
@Entity
public class DefenseSchedule implements Serializable{
    @Id
    @GeneratedValue
    private long scheduleId;
    private String name;
    private String batch;// 一二三辩 批次
    private Date date;//答辩时间
    private String place;//地点
    private String attention;//注意事项
    private int status;//是否结束 0 1

    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team teamId;
    @ManyToOne
    @JoinColumn(name = "judgeTeam")
    private Team judgeTeam;// 评委团队
    @ManyToOne
    @JoinColumn(name = "secretary")
    private Teacher secretary;//秘书
}
