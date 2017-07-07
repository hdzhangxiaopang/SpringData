package com.spring.repository;

import com.spring.domain.Employee;
import com.spring.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestEmployeeJpaRepository {
    private ApplicationContext applicationContext = null;
    private EmployeeJpaRepository employeeJpaRepository = null;
    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext-springdata.xml");
        employeeJpaRepository = applicationContext.getBean(EmployeeJpaRepository.class);
    }
    @After
    public void tearDown(){
        applicationContext = null;
    }

    @Test
    public void testFind(){
        Employee employee = employeeJpaRepository.findOne(99);
        System.out.println(employee);
        System.out.println("是否存在 "+employeeJpaRepository.exists(120));
    }

}
