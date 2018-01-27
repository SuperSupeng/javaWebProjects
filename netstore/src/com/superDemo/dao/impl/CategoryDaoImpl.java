package com.superDemo.dao.impl;

import com.superDemo.dao.CategoryDao;
import com.superDemo.domain.Category;
import com.superDemo.exception.DaoException;
import com.superDemo.util.DBCPUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
    public void save(Category category) {
        try {
            qr.update("insert into categorys (id,name,description) values(?,?,?)", category.getId(),category.getName(),category.getDescription());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public List<Category> findAll() {
        try {
            return qr.query("select * from categorys", new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public Category findById(String categoryId) {
        try {
            return qr.query("select * from categorys where id=?", new BeanHandler<Category>(Category.class),categoryId);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
