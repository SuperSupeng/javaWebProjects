package service.impl;

import service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("保存");
    }
}
