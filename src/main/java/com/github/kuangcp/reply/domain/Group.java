package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by https://github.com/kuangcp on 17-11-26  下午8:57
 *
 * @author kuangcp
 */
@Data
@Entity
public class Group implements Serializable{
    @Id
    private long groupId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "majorId")
    private Major majorId;
}
