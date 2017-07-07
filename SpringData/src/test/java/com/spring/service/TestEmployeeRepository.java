package com.spring.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestEmployeeRepository {
    private ApplicationContext applicationContext = null;
    private EmployeeService employeeService = null;
    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext-springdata.xml");
        employeeService = applicationContext.getBean(EmployeeService.class);
    }
    @After
    public void tearDown(){
        applicationContext = null;
    }

    @Test
    public void testUpdateEmployeeAgeById(){
        employeeService.updateEmployeeAgeById(8,22);

    }
}
