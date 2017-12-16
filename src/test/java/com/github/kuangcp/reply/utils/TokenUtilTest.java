package com.github.kuangcp.reply.utils;

import org.junit.Test;

/**
 * Created by https://github.com/kuangcp on 17-12-16  下午10:04
 *
 * @author kuangcp
 */
public class TokenUtilTest {

    @Test
    public void testVerifyToken() {
        String token = TokenUtil.createToken("userId");
        System.out.println(token);
        String result = TokenUtil.verifyToken(token, "userId");
        System.out.println("校验结果: "+result);
    }

    @Test
    public void testPerformance() throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i=0; i<5; i++){
            Thread.sleep(1000);
            testVerifyToken();
        }
        System.out.println("耗时"+(System.currentTimeMillis()-start)+"ms");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme