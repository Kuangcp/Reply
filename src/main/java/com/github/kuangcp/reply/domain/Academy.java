package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by https://github.com/kuangcp on 17-11-26  下午9:33
 * 学院
 * @author kuangcp
 */
@Data
@Entity
public class Academy implements Serializable {
    @Id
    @GeneratedValue
    private long academyId;
    private String name;

    @OneToMany
    @JoinColumn(name = "academyId")
    private Set<Major> majorSet;


}
