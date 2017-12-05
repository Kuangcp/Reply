package com.github.kuangcp.reply.service.base;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by https://github.com/kuangcp on 17-12-5  上午10:29
 *
 * @author kuangcp
 */
public interface RoleService {
    /**
     * 登录接口，方便所有的用户登录，省去重复代码
     * @param id 用户id
     * @param password 提交的密码
     * @return 返回是否正确
     */
    String login(long id, String password, JpaRepository dao);
}
