package com.github.kuangcp.reply.other;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by https://github.com/kuangcp on 17-12-3  下午7:28
 *
 * @author kuangcp
 */
public class LongTest {

    @Test
    public void testLong(){
        long tetst = 3892164647826746382L;
        System.out.println(tetst);
    }

    @Test
    public void getYear(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DATE));
    }

    @Test
    public void parseLong(){
        try{
            System.out.println(Long.parseLong("890895y0"));
        }catch (Exception e){
            System.out.println(9);
        }
    }

    // 对比表明 Lamda表达式性能要差一些,但是语法简单,但是!域内只能用final变量?
    @Test
    public void testMap(){
        long start = System.currentTimeMillis();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<900000;i++){
            map.put(i+"", i);
        }
        int r  = 0;
        map.forEach((k,v)->{
            int result = v*10;
        });
        System.out.println("耗时"+(System.currentTimeMillis()-start)+"ms");
    }
    @Test
    public void testUsually(){
        long start = System.currentTimeMillis();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<900000;i++){
            map.put(i+"", i);
        }
        for(String key: map.keySet()){
            int result = map.get(key)*10;
        }
        System.out.println("耗时"+(System.currentTimeMillis()-start)+"ms");
    }
}
