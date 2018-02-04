package com.superDemo.dao;

import com.superDemo.domain.Customer;

public interface CustomerDao {
    void save(Customer c);

    void update(Customer customer);

    Customer findByCode(String code);

    Customer findCustomer(String username, String password);

    Customer findById(String customerId);
}
