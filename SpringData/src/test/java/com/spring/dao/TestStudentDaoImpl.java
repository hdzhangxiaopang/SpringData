package com.spring.dao;

import com.spring.dao.impl.StudentDaoImpl;
import com.spring.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * 测试查询所有的方法
 */
public class TestStudentDaoImpl {
    @Test
    public void testQuery(){
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> studnets  = studentDao.query();
        for (Student student:studnets) {
            System.out.println(student);
        }
    }
}
