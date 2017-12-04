package com.github.kuangcp.reply.dao;

import com.github.kuangcp.reply.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by https://github.com/kuangcp on 17-12-4  下午12:33
 *
 * @author kuangcp
 */
public interface StudentDao extends JpaRepository<Student, Long>{
}
