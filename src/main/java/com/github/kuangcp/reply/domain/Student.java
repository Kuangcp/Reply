package com.github.kuangcp.reply.domain;

import com.github.kuangcp.reply.domain.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by https://github.com/kuangcp on 17-11-26  下午8:51
 * 学生表
 * TODO 同样的使用OID还是学号
 * @author kuangcp
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable, Role{
    @Id
    @GeneratedValue
    private long studentId;
    private String name;
    private String identifier;//学号，账号
    private String password;
    private String email;
    private int year;//届

    @ManyToOne
    @JoinColumn(name = "classId")
    private Class classId;

    public Student(long studentId){
        this.studentId = studentId;
    }
}
