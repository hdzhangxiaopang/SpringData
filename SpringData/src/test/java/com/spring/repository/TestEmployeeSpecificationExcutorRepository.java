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
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class TestEmployeeSpecificationExcutorRepository {
    private ApplicationContext applicationContext = null;
    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository = null;
    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext-springdata.xml");
        employeeJpaSpecificationExecutorRepository = applicationContext.getBean(EmployeeJpaSpecificationExecutorRepository.class);
    }
    @After
    public void tearDown(){
        applicationContext = null;
    }

    /*分页、排序、年龄大于50*/

    @Test
    public void testPage(){

        /*降序*/
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);

        Pageable pageable = new PageRequest(0,5,sort);

       /*
        root：就是要查询的类型
        criteriaQuery：添加查询条件
        criteriaBuilder：构建Predicate

        */


        Specification<Employee> specification = new Specification<Employee>() {
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
             /*   root(employee (age)) */
                Path path = root.get("age");
                return criteriaBuilder.gt(path,50);
            }
        };

        Page<Employee> page = employeeJpaSpecificationExecutorRepository.findAll(specification,pageable);
        System.out.println("总共分多少页"+page.getTotalPages());
        System.out.println("查询的总记录数"+page.getTotalElements());
        System.out.println("当前第几页"+page.getNumber()+1);
        System.out.println("当前页面的集合"+page.getContent());
        System.out.println("当前页面记录数"+page.getNumberOfElements());

    }

}
