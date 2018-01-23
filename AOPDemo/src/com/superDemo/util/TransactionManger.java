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
}
