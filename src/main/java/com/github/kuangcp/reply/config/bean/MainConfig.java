package com.github.kuangcp.reply.config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by https://github.com/kuangcp on 17-11-28  下午7:36
 *
 * @author kuangcp
 */
@Data
@Component
@ConfigurationProperties(prefix = "reply.main")
public class MainConfig {
    public String loginFail;
    public String loginCheck;
    public String loginTypeStu;
    public String loginTypeTea;
    public String loginTypeAdmin;
    public int chooseTopicPageSize;

    //因为课题topic是外键引用学生,所以刚开始要有一个缺省值 所以也就需要一个空的学生进来

    public int defaultTopicStudentId;

}
