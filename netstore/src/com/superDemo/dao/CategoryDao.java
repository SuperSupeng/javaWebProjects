package com.superDemo.dao;

import com.superDemo.domain.Category;

import java.util.List;

public interface CategoryDao {
    void save(Category category);

    List<Category> findAll();

    Category finById(String categoryId);
}
