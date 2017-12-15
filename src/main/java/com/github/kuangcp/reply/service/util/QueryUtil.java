package com.github.kuangcp.reply.service.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by https://github.com/kuangcp on 17-12-8  上午10:06
 *
 * @author kuangcp
 */
@Service
public class QueryUtil {

    public PageRequest getPageRequest(int page, int size) {
        return new PageRequest(page, size);
    }

    public long getStudentId(HttpSession session){
        return (long) session.getAttribute("studentId");
    }
    public long getTeacheId(HttpSession session){
        return (long) session.getAttribute("teacherId");
    }
    public long getAdminId(HttpSession session){
        return (long) session.getAttribute("adminId");
    }

//    public long checkId(String id){
//        Long result;
//        try{
//            result = Long.parseLong(id);
//        }catch (Exception e){
//            return -1;
//        }
//        return result;
//    }
}
