package com.github.kuangcp.reply.utils;

import org.junit.Test;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by https://github.com/kuangcp on 17-12-16  下午11:29
 *
 * @author kuangcp
 */
public class JwtTokenUtilsTest {

    @Test
    public void testCreateToken() throws IOException {
        String result = JwtTokenUtils.createToken("userId");
        System.out.println(result);
        System.out.println(Arrays.toString(new BASE64Decoder().decodeBuffer(result)));
        result = JwtTokenUtils.verifyToken(result, "userId");
        System.out.println(result);
    }

    @Test
    public void testPerformance() throws InterruptedException, IOException {
        long start = System.currentTimeMillis();
        for (int i=0; i<5; i++){
            Thread.sleep(1000);
            testCreateToken();
        }
        System.out.println("耗时"+(System.currentTimeMillis()-start)+"ms");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme