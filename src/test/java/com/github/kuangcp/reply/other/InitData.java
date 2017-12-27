package com.github.kuangcp.reply.other;

import com.github.kuangcp.reply.service.test.InitDataService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by https://github.com/kuangcp on 17-12-4  下午12:31
 * 删除数据库后 初始化测试数据
 * @author kuangcp
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InitData {

    InitDataService initDataService;

    public void testinit(){
        initDataService.init();
    }
}
