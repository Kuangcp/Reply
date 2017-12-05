package com.github.kuangcp.reply.service.impl;

import com.github.kuangcp.reply.config.bean.MainConfig;
import com.github.kuangcp.reply.domain.user.Role;
import com.github.kuangcp.reply.service.base.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by https://github.com/kuangcp on 17-12-5  上午10:30
 *
 * @author kuangcp
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    MainConfig mainConfig;

    /**
     * 实现方法
     * @param id 用户id
     * @param password 提交的密码
     * @param dao Jpa的dao
     * @return 用户名， 失败就是Fail
     */
    @Override
    public String login(long id, String password, JpaRepository dao) {
        Role role = (Role) dao.findOne(id);
        if(role!=null && role.getPassword().equals(password)){
            return role.getName();
        }
        return mainConfig.loginFail;
    }
}
