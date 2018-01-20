package com.superDemo.dao;

import com.superDemo.domain.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> findAll();

    void save(Customer c);

    Customer findById(String cusromerId);

    void update(Customer c);

    void delete(String customerId);
}
