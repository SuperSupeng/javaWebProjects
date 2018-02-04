package com.superDemo.service;

import com.superDemo.commons.Page;
import com.superDemo.domain.Book;
import com.superDemo.domain.Category;
import com.superDemo.domain.Customer;

import java.util.List;

public interface BusinessService {

    /**
     * 添加分类
     * @param category 分类
     */
    void addCategory(Category category);

    /**
     * 查询所有分类
     * @return 返回查询结果
     */
    List<Category> findAllCategories();

    /**
     * 根据指定的id查询分类
     * @param categoryId 查询的分类ID
     * @return 没有则返回null
     */
    Category findCategoryById(String categoryId);

    /**
     * 添加一本图书
     * @param book
     */
    void addBook(Book book);

    /**
     * 根据用户要查看的页码，返回封装了分页信息的Page对象
     * @param pagenum 默认为1
     * @return
     */
    Page findAllBookPageRecords(String pagenum);

    /**
     * 根据用户要查看的页码，返回封装了分页信息的Page对象,按照分类进行查询的
     * @param pagenum 默认为1
     * @return
     */
    Page findAllBookPageRecords(String pagenum,String categoryId);

    /**
     * 根据id查询一本书
     * @param bookId
     * @return
     */
    Book findBookById(String bookId);

    /**
     * 用户注册
     *
     * @param c
     */
    void regitsCustomer(Customer c);

    /**
     * 根据激活码注册账号
     * @param code 激活码
     */
    void activeCustomer(String code);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 如果用户名或密码不正确或者没有激活则返回null;
     */
    Customer customerLogin(String username, String password);

}
