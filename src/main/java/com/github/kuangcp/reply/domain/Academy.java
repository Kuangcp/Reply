package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by https://github.com/kuangcp on 17-11-26  下午9:33
 *
 * @author kuangcp
 */
@Data
@Entity
public class Academy implements Serializable {
    @Id
    private long academyId;
    private String name;

    @OneToMany
    @JoinColumn(name = "academyId")
    private Set<Major> majorSet;
}
