package com.github.kuangcp.reply.service;

import com.github.kuangcp.reply.config.bean.MainConfig;
import com.github.kuangcp.reply.domain.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
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
    MainConfig mainConfig;
    @Autowired
    StudentService studentService;

    @Test
    public void testSave(){
        String result = studentService.saveSelect(1, 2, "df");
//        assert !"".equals(result);
        System.out.println(result);
    }

    @Test
    public void testList(){
        Page<Topic> list = studentService.listTopic(0, mainConfig.chooseTopicPageSize);
        for(Topic topic: list){
            System.out.println(topic.toString());
        }
    }
}
