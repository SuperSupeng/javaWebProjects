package com.superDemo.service.impl;

import com.superDemo.dao.CategoryDao;
import com.superDemo.dao.impl.CategoryDaoImpl;
import com.superDemo.domain.Category;
import com.superDemo.service.BusinessService;

import java.util.List;
import java.util.UUID;

public class BusinessServiceImpl implements BusinessService {
    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public void addCategory(Category category) {
        category.setId(UUID.randomUUID().toString());
        categoryDao.save(category);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryDao.findAll();
    }

    @Override
    public Category findCategoryById(String categoryId) {
        return categoryDao.findById(categoryId);
    }
}
