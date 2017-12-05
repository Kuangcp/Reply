package com.github.kuangcp.reply.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by https://github.com/kuangcp on 17-12-5  上午10:37
 *
 * @author kuangcp
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    TeacherService teacherService;
    //测试使用接口简化代码的登录方式
    @Test
    public void loginTest(){
        String result = teacherService.login(1, "d");
        System.out.println(result);
        result = teacherService.login(1, "3");
        System.out.println(result);
    }
}
