package com.github.kuangcp.reply.domain;

import com.github.kuangcp.reply.domain.user.Role;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by https://github.com/kuangcp on 17-11-26  下午8:51
 * TODO 管理员，负责数据的导入？ 直接放置成秘书？
 * @author kuangcp
 */
@Data
@Entity
public class Admin implements Serializable, Role{
    @Id
    @GeneratedValue
    private long adminId;

    private String name;
    private String password;

}
