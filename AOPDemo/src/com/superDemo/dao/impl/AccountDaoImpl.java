package com.superDemo.dao.impl;

import com.superDemo.dao.AccountDao;
import com.superDemo.domain.Account;
import com.superDemo.util.TransactionManger;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {
    private QueryRunner qr = new QueryRunner();
    @Override
    public Account findByName(String accountName) {
        try {
            return qr.query(TransactionManger.getConnection(),"select * from account where name=?", new BeanHandler<Account>(Account.class), accountName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Account account) {
        try {
            qr.update(TransactionManger.getConnection(),"update account set money=? where id=?", account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
