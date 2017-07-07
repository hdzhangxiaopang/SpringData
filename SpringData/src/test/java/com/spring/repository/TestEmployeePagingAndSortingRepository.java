package com.spring.repository;


import com.spring.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class TestEmployeePagingAndSortingRepository {
    private ApplicationContext applicationContext = null;
    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository = null;
    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext-springdata.xml");
        employeePagingAndSortingRepository = applicationContext.getBean(EmployeePagingAndSortingRepository.class);
    }
    @After
    public void tearDown(){
        applicationContext = null;
    }

    @Test
    public void testPage(){

        /*降序*/
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);

        Pageable pageable = new PageRequest(0,5,sort);
        Page<Employee> page = employeePagingAndSortingRepository.findAll(pageable);
        System.out.println("总共分多少页"+page.getTotalPages());
        System.out.println("查询的总记录数"+page.getTotalElements());
        System.out.println("当前第几页"+page.getNumber()+1);
        System.out.println("当前页面的集合"+page.getContent());
        System.out.println("当前页面记录数"+page.getNumberOfElements());

    }
}
