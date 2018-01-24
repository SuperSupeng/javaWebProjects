package com.superDemo.service.impl;

import com.superDemo.dao.UserDao;
import com.superDemo.dao.impl.UserDaoImpl;
import com.superDemo.domain.User;
import com.superDemo.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        return dao.query(username, password);
    }
}
