package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by https://github.com/kuangcp on 17-11-26  下午9:27
 *
 * @author kuangcp
 */
@Data
@Entity
public class Major implements Serializable{
    @Id
    private long majorId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "academyId")
    private Academy academyId;

    @OneToMany
    @JoinColumn(name = "majorId")
    private Set<Class> classSet;


}
