package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by https://github.com/kuangcp on 17-11-26  下午8:51
 * 学生表
 * TODO 同样的使用OID还是学号
 * @author kuangcp
 */
@Data
@Entity
public class Student implements Serializable{
    @Id
    private long studentId;
    private String name;
    private String identifier;//学号，账号
    private String password;
    private String email;

}
