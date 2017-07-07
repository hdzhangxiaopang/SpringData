package com.spring.repository;

import com.spring.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestEmployeeRepository {
    private ApplicationContext applicationContext = null;
    private EmployeeRepository employeeRepository = null;
    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext-springdata.xml");
        employeeRepository = applicationContext.getBean(EmployeeRepository.class);
    }
    @After
    public void tearDown(){
        applicationContext = null;
    }
    @Test
    public void testEmployeeFindByName(){
        Employee employee = employeeRepository.findByName("lisi");
        System.out.println(employee);
    }
    @Test
    public void testFindByNameStartingWithAndAgeLessThan(){
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("zhangsan",20);
        for (Employee employee:employees) {
            System.out.println(employee);
        }
    }
    @Test
    public void testFindByNameEndingWithAndAgeLessThan(){
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("1",20);
        for (Employee employee:employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testFindByNameInOrAgeLessThan(){
        List<String> names = new ArrayList<String>();
        names.add("zhangsan1");
        names.add("lisi2");
        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names,20);
        for (Employee employee:employees) {
            System.out.println(employee);
        }
    }
    @Test
    public void testFindByNameInAndgeLessThan(){
        List<String> names = new ArrayList<String>();
        names.add("zhangsan1");
        names.add("lisi2");
        List<Employee> employees = employeeRepository.findByNameInAndAgeLessThan(names,19);
        for (Employee employee:employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testGetMaxIDEmployee(){

        Employee employee = employeeRepository.getMaxIDEmployee();
            System.out.println(employee);
    }
    @Test
    public void testFindEmployeeByNameAndAge(){
        List<Employee> employees = employeeRepository.findEmployeeByNameAndAge("zhangsan",18);
        for (Employee employee:employees) {
            System.out.println(employee);
        }

    }

    @Test
    public void testFindEmployeeByNameAndAgeTwo(){
        List<Employee> employees = employeeRepository.findEmployeeByNameAndAgeTwo("zhangsan",18);
        for (Employee employee:employees) {
            System.out.println(employee);
        }

    }

    @Test
    public void testFindEmployeeLikeName(){
        List<Employee> employees = employeeRepository.findEmployeeLikeName("lisi");
        for (Employee employee:employees) {
            System.out.println(employee);
        }

    }

    @Test
    public void testFindEmployeeLikeNameTwo(){
        List<Employee> employees = employeeRepository.findEmployeeLikeNameTwo("lisi1");
        for (Employee employee:employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testGetCount(){
        long count  = employeeRepository.getCount();
        System.out.println(count);
    }

    @Test
    public void testUpdateEmployeeAgeById(){
        employeeRepository.updateEmployeeAgeById(8,22);

    }
}
