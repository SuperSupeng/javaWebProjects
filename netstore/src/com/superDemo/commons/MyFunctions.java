package com.superDemo.commons;

import com.superDemo.domain.Category;
import com.superDemo.service.BusinessService;
import com.superDemo.service.impl.BusinessServiceImpl;

public class MyFunctions {
    private static BusinessService s = new BusinessServiceImpl();
    public static String showCategoryName(String categoryId){
        Category c = s.findCategoryById(categoryId);
        if(c!=null){
            return c.getName();
        }
        return null;
    }
}
