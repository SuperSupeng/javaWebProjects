package com.superDemo.test;

import com.superDemo.domain.Category;
import com.superDemo.service.BusinessService;
import com.superDemo.service.impl.BusinessServiceImpl;
import org.junit.Test;

public class CategoryTest {
    BusinessService businessService = new BusinessServiceImpl();


    @Test
    public void testAddCategory(){
        Category category = new Category();
        category.setName("java");
        category.setDescripiton("java相关书籍");
        businessService.addCategory(category);
    }

}
