package com.spring.dao.impl;

import com.spring.dao.StudentDao;
import com.spring.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoJDBCTemplateImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;
     /*  通过get和set方法注入JDBCTemplate*/
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> query() {
        final List<Student> students = new ArrayList<Student>();
        String sql = "select id,name,age from student";
        jdbcTemplate.query(sql,new RowCallbackHandler(){

            public void processRow(ResultSet resultSet) throws SQLException {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    Student  student = new Student();
                    student.setId(id);
                    student.setName(name);
                    student.setAge(age);
                    students.add(student);
                }
        });
        return students;
    }

    public void save(Student student) {
        String sql = "insert into student(name,age) value(?,?)";
        jdbcTemplate.update(sql,new Object[]{student.getName(),student.getAge()} );
    }
}
