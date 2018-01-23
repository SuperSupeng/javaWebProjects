package com.superDemo.service;

public interface BusinessService {

    /**
     * 转账
     * @param sourceAccountName 转出账户
     * @param targetAccountName 转入账户
     * @param money 交易金额
     */
    void transfer(String sourceAccountName, String targetAccountName, float money);
}
