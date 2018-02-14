package service.impl;

import dao.UserDao;
import service.BusinessService;

public class BusinessServiceImpl implements BusinessService{
    private UserDao dao;

    public void setDao(UserDao dao) {//谁用谁传。DI：Dependent Injection依赖注入
        this.dao = dao;
    }

    @Override
    public void regist() {

    }
}
