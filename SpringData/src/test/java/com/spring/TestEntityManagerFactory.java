package com.spring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by zhangguilin on 2017/5/5.
 */
public class TestEntityManagerFactory {
    private ApplicationContext applicationContext = null;
    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext-springdata.xml");
    }
    @After
    public void tearDown(){
        applicationContext = null;
    }
    @Test
    public void testEntityManagerFactory(){

    }


}
