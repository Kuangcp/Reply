package com.github.kuangcp.reply.config;

import com.github.kuangcp.reply.config.bean.MainConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by https://github.com/kuangcp on 17-11-28  下午7:37
 *
 * @author kuangcp
 */
@Configuration
@EnableConfigurationProperties(MainConfig.class)
public class AutoConfig {
}
