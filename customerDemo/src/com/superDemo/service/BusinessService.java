package com.superDemo.service;

import com.superDemo.domain.Customer;
import com.superDemo.exception.IdIsNullException;

import java.util.List;

public interface BusinessService {
    /**
     * 查询所有的用户信息
     * @return
     */
    List<Customer> findAllCustomers();

    /**
     * 添加客户信息
     */
    void saveCustomer(Customer c);

    /**
     * 更新用户信息
     * @param cusromerId
     * @return
     */
    Customer findCustomerById(String cusromerId);

    /**
     * 更新客户信息
     * @param c
     * @throws IdIsNullException
     */
    void updateCustomer(Customer c) throws IdIsNullException;

    /**
     * 根据指定id删除客户信息
     * @param customerId
     */
    void deleteCustomerById(String customerId);
}
