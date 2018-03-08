package service;

import dao.AccountDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
public class AccountServiceImpl implements AccountService {
    private AccountDao ad ;

    @Override
    public void transfer(Integer from, Integer to, Double money) {
        //减钱
        ad.decreaseMoney(from, money);
        //加钱
        ad.increaseMoney(to, money);
    }

    public void setAd(AccountDao ad) {
        this.ad = ad;
    }
}
