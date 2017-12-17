package com.github.kuangcp.reply.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by https://github.com/kuangcp on 17-12-16  下午11:20
 * 默认采用HS256加密,将JWT的三段数据格式,去除掉第一部分,减轻传输压力
 * 增加角色字段
 * @author kuangcp
 */
public class JwtTokenUtils {
    private static String SECRET = "kuangcp";
    public static final String CREATE_FAIL = "CREATE_FAIL";
    public static final String VERIFY_FAIL = "VERIFY_FAIL";
    public static final String VERIFY_SUCCESS = "VERIFY_SUCCESS";
    public static final SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 过期时间的设置,过期后Token就会失效
    private static long EXPIRE_WEEK = 1000 * 60 * 60 * 24 * 7;
    private static long EXPIRE_DAY = 1000 * 60 * 60 * 24;


    /**
     * 根据id生成token
     * @param userId 用户id
     * @return token
     */
    public static String createToken(String userId) {
        String token;
        long seconds = System.currentTimeMillis()+EXPIRE_WEEK;
        Date date = new Date(seconds);
//        System.out.println("附属参数: "+smf.format(date));
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            token = JWT.create()
                    .withIssuer(userId)
                    .withExpiresAt(date)
//                    .wi
                    .sign(algorithm);
        } catch (UnsupportedEncodingException | JWTCreationException exception) {
            return CREATE_FAIL;
        }
        return token.substring(37,token.length());
    }

    /**
     * 对token进行解析,如果有效就返回正确
     * @param token token字符串
     * @param userId 用户id
     * @return 校验结果 success/failed 成功/失败
     */
    public static String verifyToken(String token, String userId){
        // 第一部分,如果更改了加密协议,这里也要改
        token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9."+token;
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(userId)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            Date expire = jwt.getExpiresAt();
//            return VERIFY_SUCCESS;
            return smf.format(expire);
        } catch (UnsupportedEncodingException | JWTVerificationException exception){
            return VERIFY_FAIL;
        }
    }
}
