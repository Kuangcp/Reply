package com.github.kuangcp.reply.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by https://github.com/kuangcp on 17-12-9  上午10:29
 *
 * @author kuangcp
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicServiceTest {
    @Autowired
    TopicService topicService;

    // 测试选择通过学生
    @Test
    public void testSelect(){
        topicService.selectStudent(1L, 2L, "恭喜");
    }
    @Test
    public void testReject(){
        topicService.rejectStudent(1L, 2L, "你太丑了");
    }

    @Test
    public void testSelectNum(){
        int result = topicService.getTopicSelectNum(2L);
        System.out.println(result);

    }

    // 测试重置课题的选题
    @Test
    public void testReset(){
        String result = topicService.resetStudent(2L);
        System.out.println(result);
    }
}
