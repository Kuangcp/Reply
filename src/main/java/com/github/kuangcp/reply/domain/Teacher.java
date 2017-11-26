package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by https://github.com/kuangcp on 17-11-26  下午8:51
 *
 * @author kuangcp
 */
@Data
@Entity
public class Teacher implements Serializable{
    @Id
    private long teacherId;
    private String name;
    private String identifier;
    private String password;

    @ManyToOne
    @JoinColumn(name = "majorId")
    private Major majorId;
}
