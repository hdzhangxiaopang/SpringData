package com.spring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 *
 */
public class TestDataSource {
    private ApplicationContext  applicationContext = null;
    @Before
    public void setUp(){
       applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @After
    public void tearDown(){
        applicationContext = null;
    }
    @Test
    public void testDataSource(){
        DataSource dataSource =  (DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource);
    }

    @Test
    public void testJdbcTemplate(){
        JdbcTemplate jdbcTemplate =  (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        System.out.println(jdbcTemplate);
    }

}
