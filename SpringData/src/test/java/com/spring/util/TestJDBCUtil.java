package com.spring.util;

import junit.framework.Assert;

import java.sql.Connection;

/**
 * Created by zhangguilin on 2017/5/4.
 */
public class TestJDBCUtil {
    @org.junit.Test
    public void testConnection() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }
}
