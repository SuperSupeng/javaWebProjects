package com.superDemo.util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 封装与事务操作有关的操作
 */
public class TransactionManger {
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();
    public static Connection getConnection(){
        Connection conn = tl.get();
        if(conn == null){
            conn = DBCPUtil.getConnection();
            tl.set(conn);
        }
        return conn;
    }

    /**
     * 开启事务
     */
    public static void startTransaction(){
        try {
            Connection connection = getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 事务回滚
     */
    public static void rollback(){
        try {
            Connection conn = getConnection();
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 事务提交
     */
    public static void commit(){
        try {
            Connection conn = getConnection();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     */
    public static void release(){
        try {
            Connection conn = getConnection();
            conn.close();
            tl.remove();//从当前线程中解绑。  与服务器实现有关：服务器采用线程池。
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
