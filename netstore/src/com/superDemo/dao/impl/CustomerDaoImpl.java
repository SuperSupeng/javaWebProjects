package com.superDemo.dao.impl;

import com.superDemo.dao.CustomerDao;
import com.superDemo.domain.Customer;
import com.superDemo.exception.DaoException;
import com.superDemo.util.DBCPUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class CustomerDaoImpl implements CustomerDao {
    private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
    public void save(Customer c) {
        try {
            qr.update("insert into customers (id,username,password,phone,address,email,actived,code) values (?,?,?,?,?,?,?,?)",
                    c.getId(),
                    c.getUsername(),
                    c.getPassword(),
                    c.getPhone(),
                    c.getAddress(),
                    c.getEmail(),
                    c.isActived(),
                    c.getCode());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Customer findByCode(String code) {
        try {
            return qr.query("select * from customers where code=?", new BeanHandler<Customer>(Customer.class),code);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void update(Customer c) {
        try {
            qr.update("update customers set username=?,password=?,phone=?,address=?,email=?,actived=?,code=? where id=?",
                    c.getUsername(),
                    c.getPassword(),
                    c.getPhone(),
                    c.getAddress(),
                    c.getEmail(),
                    c.isActived(),
                    c.getCode(),
                    c.getId());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Customer findCustomer(String username, String password) {
        try {
            return qr.query("select * from customers where username=? and password=?", new BeanHandler<Customer>(Customer.class),username,password);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Customer findById(String customerId) {
        try {
            return qr.query("select * from customers where id=?", new BeanHandler<Customer>(Customer.class),customerId);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
