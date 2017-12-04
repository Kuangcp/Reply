package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by https://github.com/kuangcp on 17-11-26  下午9:33
 * 学院
 * @author kuangcp
 */
@Data
@Entity
public class College implements Serializable {
    @Id
    @GeneratedValue
    private long collegeId;
    private String name;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "collegeId")
//    private Set<Major> majorSet;


}
