package com.github.kuangcp.reply.service.test;

import com.github.kuangcp.reply.dao.*;
import com.github.kuangcp.reply.domain.*;
import com.github.kuangcp.reply.domain.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.annotations.Test;

/**
 * Created by https://github.com/kuangcp on 17-12-27  上午9:22
 *
 * @author kuangcp
 */
@Service
public class InitDataService {
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    AdminDao adminDao;

    @Autowired
    CollegeDao collegeDao;
    @Autowired
    MajorDao majorDao;
    @Autowired
    ClassDao classDao;
    @Autowired
    TeamDao teamDao;

    @Test
    public void init(){

        College academy = new College();
        academy.setName("test1");
        collegeDao.save(academy);

        Major major = new Major();
        major.setName("test1");
        major.setCollegeId(academy);
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
        teacher.setPassword("1");
        teacherDao.save(teacher);

        Class classs = new Class();
        classs.setName("test1");
        classs.setMajorId(major);
        classs.setTeacherId(teacher);
        classDao.save(classs);

        Student student = new Student();
        student.setName("test1");
        student.setClassId(classs);
        student.setPassword("1");
        studentDao.save(student);

        Admin admin =  new Admin();
        admin.setName("admin1");
        admin.setPassword("1");
        adminDao.save(admin);
    }
}
