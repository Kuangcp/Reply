package com.github.kuangcp.reply.service.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by https://github.com/kuangcp on 17-12-8  上午10:06
 *
 * @author kuangcp
 */
@Service
public class QueryUtil {

    public PageRequest pageRequest;


    public PageRequest getPageRequest(int page, int size) {
        return new PageRequest(page, size);
    }
}
