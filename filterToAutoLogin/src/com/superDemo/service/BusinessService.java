package com.superDemo.service;

import com.superDemo.domain.User;

public interface BusinessService {
    /**
     * 用户登录
     * @param username
     * @param passowrd
     * @return 用户名或密码错误返回null
     */
    User login(String username, String password);
}
