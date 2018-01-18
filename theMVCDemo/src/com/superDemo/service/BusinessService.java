package com.superDemo.service;

import com.superDemo.domain.User;
import com.superDemo.execption.UserExistExecption;

public interface BusinessService {
    /**
     * 注册新用户
     * @param user 封装了用户信息的user对象
     * @throws UserExistExecption 如果用户名已经存在，抛出此异常
     */
    void register(User user) throws UserExistExecption;

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 用户名或密码错误返回null
     */
    User login(String username, String password);
}
