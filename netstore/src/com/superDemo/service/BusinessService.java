package com.superDemo.service;

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
}
