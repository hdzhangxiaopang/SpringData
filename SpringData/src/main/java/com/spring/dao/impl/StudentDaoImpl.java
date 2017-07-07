package com.spring.dao.impl;

import com.spring.dao.StudentDao;
import com.spring.domain.Student;
import com.spring.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDao访问接口实现类
 */
public class StudentDaoImpl implements StudentDao {
    public List<Student> query() {
        List<Student> students = new ArrayList<Student>();
        Connection connection = null ;
        PreparedStatement preparedStatement = null ;
        ResultSet resultSet = null;
        String sql = "select id,name,age from student";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Student student=null;
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
                JDBCUtil.release(resultSet,preparedStatement,connection);
        }
        return students;
    }

    public void save(Student student) {

    }
}
