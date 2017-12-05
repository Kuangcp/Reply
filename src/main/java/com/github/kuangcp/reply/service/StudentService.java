package com.github.kuangcp.reply.service;

import com.github.kuangcp.reply.dao.StudentDao;
import com.github.kuangcp.reply.service.base.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by https://github.com/kuangcp on 17-12-5  上午9:35
 *
 * @author kuangcp
 */
@Service
public class StudentService {

    @Autowired
    RoleService roleService;
    @Autowired
    StudentDao studentDao;

    public String login(long id, String password){
        return roleService.login(id, password, studentDao);
    }
}
