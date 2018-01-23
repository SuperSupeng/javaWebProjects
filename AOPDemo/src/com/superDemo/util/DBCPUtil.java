package com.superDemo.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DBCPUtil {
    private static DataSource dataSource;

    static {
        try{
            InputStream in = DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            Properties properties = new Properties();
            properties.load(in);
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection(){
        try{
            return dataSource.getConnection();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
