package com.superDemo.dao.impl;

import com.superDemo.dao.UserDao;
import com.superDemo.domain.User;
import com.superDemo.util.DBCPUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

    @Override
    public User query(String username, String password) {
        try {
            return qr.query("select * from user where username=? and password=?", new BeanHandler<User>(User.class),username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
