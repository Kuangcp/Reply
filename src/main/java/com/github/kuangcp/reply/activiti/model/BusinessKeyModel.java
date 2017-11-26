package com.github.kuangcp.reply.activiti.model;

import lombok.*;

/**
 * businesskey数据模型.
 *
 * @author: huang
 * Date: 17-11-5
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BusinessKeyModel {

    /** 流程名. */
    private String process;
    /** 关联的业务ID. */
    private String id;

}
