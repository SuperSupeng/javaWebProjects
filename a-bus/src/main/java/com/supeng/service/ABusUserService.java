package com.supeng.service;

import com.supeng.model.ABusUser;

import java.util.List;

public interface ABusUserService {

    List<ABusUser> selectUserList();

    void deleteUser(int id);

    ABusUser selectUserById(int id);

    int insert(ABusUser record);

    void updateUser(ABusUser user);
}
