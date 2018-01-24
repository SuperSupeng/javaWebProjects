package com.superDemo.dao;

import com.superDemo.domain.User;

public interface UserDao {
    User query(String username, String password);
}
