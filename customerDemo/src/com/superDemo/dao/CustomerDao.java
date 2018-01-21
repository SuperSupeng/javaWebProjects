package com.superDemo.dao;

import com.superDemo.domain.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> findAll();

    void save(Customer c);

    Customer findById(String cusromerId);

    void update(Customer c);

    void delete(String customerId);

    /**
     * 获取总记录条数
     * @return
     */
    int getTotalRecordsNum();

    /**
     * 分页查询
     * @param startIndex
     * @param pageSize
     * @return
     */
    List getPageRecords(int startIndex, int pageSize);
}
