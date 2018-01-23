package com.superDemo.service.impl;

import com.superDemo.dao.AccountDao;
import com.superDemo.dao.impl.AccountDaoImpl;
import com.superDemo.domain.Account;
import com.superDemo.service.BusinessService;

/**
 * 只有业务层空集具体逻辑
 */
public class BusinessServiceImpl implements BusinessService{
    private AccountDao dao = new AccountDaoImpl();
    @Override
    public void transfer(String sourceAccountName, String targetAccountName, float money) {
        Account sAccount = dao.findByName(sourceAccountName);
        Account tAccount = dao.findByName(targetAccountName);
        sAccount.setMoney(sAccount.getMoney() - money);
        tAccount.setMoney(tAccount.getMoney() + money);
        dao.update(sAccount);
        dao.update(tAccount);
    }
}
