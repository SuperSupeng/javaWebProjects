package com.superDemo.dao;

import com.superDemo.domain.Book;

import java.util.List;

public interface BookDao {
    void save(Book book);

    Book findById(String bookId);

    int findAllBooksNumber();

    List findPageBooks(int startIndex, int pageSize);

    /**
     * 某类书籍的总条数
     * @return
     */
    int findCategoryBooksNumber(String categoryId);

    /**
     * 按照分类查询书籍的分页数据
     * @param startIndex
     * @param pageSize
     * @return
     */
    List findPageBooks(int startIndex, int pageSize, String categoryId);
}
