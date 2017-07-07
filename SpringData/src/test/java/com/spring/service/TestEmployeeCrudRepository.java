package com.spring.service;

import com.spring.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class TestEmployeeCrudRepository {
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
    public void testSave(){
        List<Employee> employees =  new ArrayList<Employee>();
        Employee employee = null;
        for (int i = 0;i<100;i++){
            employee = new Employee();
            employee.setName("test"+i);
            employee.setAge(100-i);
            employees.add(employee);
        }
        employeeService.save(employees);

    }
}
