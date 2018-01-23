package com.superDemo.dao;

import com.superDemo.domain.Account;

//DAO层：不能牵扯到任何业务有关的逻辑。
//DAO:只负责CRUD
public interface AccountDao {
    /**
     * 根据用户名查询账户
     * @param accountName 账户名
     * @return 返回具体的账户
     */
    Account findByName(String accountName);

    /**
     * 更新账户
     * @param account 要更新的账户
     */
    void update(Account account);
}
