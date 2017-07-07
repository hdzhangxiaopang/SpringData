package com.spring.dao;


import com.spring.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestStudentDaoJDBCTemplateImpl {
    private ApplicationContext applicationContext = null;
    private StudentDao studentDao = null;
    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentDao = (StudentDao) applicationContext.getBean("StudentDaoJDBCTemplateImpl");

    }
    @After
    public void tearDown(){
        applicationContext = null;
    }
    @Test
    public void testQuery(){
        List<Student> studnets  = studentDao.query();
        for (Student student:studnets) {
            System.out.println(student);
        }
    }
    @Test
    public void testSave(){
        Student student = new Student();
        student.setName("wangwu");
        student.setAge(20);
        studentDao.save(student);
    }
}
