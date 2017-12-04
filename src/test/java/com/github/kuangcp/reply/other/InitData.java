package com.github.kuangcp.reply.other;

import com.github.kuangcp.reply.dao.*;
import com.github.kuangcp.reply.domain.*;
import com.github.kuangcp.reply.domain.Class;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by https://github.com/kuangcp on 17-12-4  下午12:31
 *
 * @author kuangcp
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InitData {

    @Autowired
    TeacherDao teacherDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    AcademyDao academyDao;
    @Autowired
    MajorDao majorDao;
    @Autowired
    ClassDao classDao;
    @Autowired
    TeamDao teamDao;

    @Test
    public void init(){

        Academy academy = new Academy();
        academy.setName("test1");
        academyDao.save(academy);

        Major major = new Major();
        major.setName("test1");
        major.setAcademyId(academy);
        majorDao.save(major);

        Team team = new Team();
        team.setName("test1");
//        team.setLeader();
        team.setMajorId(major);
        teamDao.save(team);

        Teacher teacher = new Teacher();
        teacher.setName("test1");
        teacher.setMajorId(major);
        teacher.setTeamId(team);
        teacherDao.save(teacher);

        Class classs = new Class();
        classs.setName("test1");
        classs.setMajorId(major);
        classs.setTeacherId(teacher);
        classDao.save(classs);

        Student student = new Student();
        student.setName("test1");
        student.setClassId(classs);
        studentDao.save(student);
    }



}
