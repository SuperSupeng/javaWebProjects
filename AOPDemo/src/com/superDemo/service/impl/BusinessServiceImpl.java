package com.superDemo.service.impl;

import com.superDemo.dao.AccountDao;
import com.superDemo.dao.impl.AccountDaoImpl;
import com.superDemo.service.BusinessService;

public class BusinessServiceImpl implements BusinessService{
    private AccountDao dao = new AccountDaoImpl();
    @Override
    public void transfer(String sourceAccountName, String targetAccountName, float money) {

    }
}
