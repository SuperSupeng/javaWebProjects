package com.superDemo.service;

import com.superDemo.commons.Page;
import com.superDemo.domain.Book;
import com.superDemo.domain.Category;

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
     * 根据id查询一本书
     * @param bookId
     * @return
     */
    Book findBookById(String bookId);
}
