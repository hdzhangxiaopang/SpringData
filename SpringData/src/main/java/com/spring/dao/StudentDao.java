package com.spring.dao;

import com.spring.domain.Student;

import java.util.List;

/**
 * StudentDao访问接口
 */
public interface StudentDao {
   /* 查询所有学生*/
    public List<Student> query();
    public void save(Student student);
}
