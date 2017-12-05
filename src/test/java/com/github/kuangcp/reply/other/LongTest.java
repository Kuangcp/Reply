package com.github.kuangcp.reply.other;

import org.junit.Test;

import java.util.Calendar;

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
}
