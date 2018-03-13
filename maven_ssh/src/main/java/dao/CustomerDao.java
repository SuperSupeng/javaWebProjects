package dao;

import entity.Customer;

public interface CustomerDao {

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    public Customer findById(Long id);
}
