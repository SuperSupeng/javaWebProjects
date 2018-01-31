package com.superDemo.dao;

import com.superDemo.domain.Book;

import java.util.List;

public interface BookDao {
    void save(Book book);

    Book findById(String bookId);

    int findAllBooksNumber();

    List findPageBooks(int startIndex, int pageSize);
}
