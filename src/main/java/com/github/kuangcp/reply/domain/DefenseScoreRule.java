package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by https://github.com/kuangcp on 17-12-3  下午8:19
 * 评分细则
 * @author kuangcp
 */
@Data
@Entity
public class DefenseScoreRule implements Serializable{
    @Id
    private long ruleId;
    private String title;
    private String detail;
    private int score;// 最大分值

    @ManyToOne
    @JoinColumn(name = "academyId")
    private Academy academyId;//所属学院


}
