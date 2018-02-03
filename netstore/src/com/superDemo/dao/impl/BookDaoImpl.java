package com.superDemo.dao.impl;

import com.superDemo.dao.BookDao;
import com.superDemo.domain.Book;
import com.superDemo.exception.DaoException;
import com.superDemo.util.DBCPUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class BookDaoImpl implements BookDao {
    private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
    @Override
    public void save(Book book) {
        try{
            qr.update("insert into books (id,name,author,price,path,photoFileName,description,categoryId) values (?,?,?,?,?,?,?,?)",
                    book.getId(),
                    book.getName(),
                    book.getAuthor(),
                    book.getPrice(),
                    book.getPath(),
                    book.getPhotoFileName(),
                    book.getDescription(),
                    book.getCategoryId());
        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public Book findById(String bookId) {
        try{
            return qr.query("select * from books where id=?", new BeanHandler<Book>(Book.class),bookId);
        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public int findAllBooksNumber() {
        try{
            Object obj = qr.query("select count(*) from books", new ScalarHandler(1));
            Long num = (Long)obj;
            return num.intValue();
        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public List findPageBooks(int startIndex, int pageSize) {
        try{
            return qr.query("select * from books limit ?,?", new BeanListHandler<Book>(Book.class),startIndex,pageSize);
        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public int findCategoryBooksNumber(String categoryId) {
        try{
            Object obj = qr.query("select count(*) from books where categoryId=?", new ScalarHandler(1),categoryId);
            Long num = (Long)obj;
            return num.intValue();
        }catch(Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public List findPageBooks(int startIndex, int pageSize, String categoryId) {
        try{
            return qr.query("select * from books where categoryId=? limit ?,?", new BeanListHandler<Book>(Book.class),categoryId,startIndex,pageSize);
        }catch(Exception e){
            throw new DaoException(e);
        }
    }
}
