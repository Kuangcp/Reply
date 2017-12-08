package com.github.kuangcp.reply.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by https://github.com/kuangcp on 17-12-8  上午9:43
 *
 * @author kuangcp
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
    @Autowired
    StudentService studentService;

    @Test
    public void testSave(){
        String result = studentService.saveSelect(1, 2, "df");
//        assert !"".equals(result);
        System.out.println(result);
    }
}
