package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by https://github.com/kuangcp on 17-11-26  下午9:27
 * 团队
 * @author kuangcp
 */
@Data
@Entity
public class Team implements Serializable{

    @Id
    @GeneratedValue
    private long teamId;
    private String name;
    private String field;//研究领域
//    private String year;
    // TODO 需不需要
    private long leader;//负责人

    @ManyToOne
    @JoinColumn(name = "majorId")
    private Major majorId;
}
