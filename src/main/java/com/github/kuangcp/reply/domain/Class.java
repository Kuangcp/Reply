package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by https://github.com/kuangcp on 17-11-26  下午8:57
 * 班级，但是注意类不要引用错了，因为同名类
 * @author kuangcp
 */
@Data
@Entity
public class Class implements Serializable{
    @Id
    private long classId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "majorId")
    private Major majorId;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private Teacher teacherId;//班主任

}
