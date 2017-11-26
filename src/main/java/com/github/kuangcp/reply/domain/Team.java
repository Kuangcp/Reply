package com.github.kuangcp.reply.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by https://github.com/kuangcp on 17-11-26  下午9:27
 *
 * @author kuangcp
 */
@Data
@Entity
public class Team implements Serializable{

    @Id
    private long teamId;
    private String name;
    private String year;
}
