package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by https://github.com/kuangcp on 17-11-26  下午9:27
 * 专业
 * @author kuangcp
 */
@Data
@Entity
public class Major implements Serializable{
    @Id
    @GeneratedValue
    private long majorId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "collegeId")
    private College collegeId;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "majorId")
//    private Set<Class> classSet;


}
