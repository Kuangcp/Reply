package com.github.kuangcp.reply.config;

import com.github.kuangcp.reply.config.bean.MainConfig;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by https://github.com/kuangcp on 17-11-28  下午8:01
 *
 * @author kuangcp
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j
public class BeanConfigTest {
    @Autowired
    MainConfig mainConfig;

    @Test
    public void test(){
        log.info(mainConfig.toString());
        System.out.println(mainConfig.toString());
    }
}
