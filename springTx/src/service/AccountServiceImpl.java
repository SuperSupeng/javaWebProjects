package service;

import dao.AccountDao;

public class AccountServiceImpl implements AccountService {
    private AccountDao ad ;

    @Override
    public void transfer(Integer from, Integer to, Double money) {
        //减钱
        ad.decreaseMoney(from, money);
        int i = 1 / 0;
        //加钱
        ad.increaseMoney(to, money);
    }
}
