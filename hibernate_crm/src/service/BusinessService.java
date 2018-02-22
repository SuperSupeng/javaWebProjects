package service;

import domain.Customer;

import java.util.List;

public interface BusinessService {
    void save(Customer c);

    List<Customer> findAll();
}
