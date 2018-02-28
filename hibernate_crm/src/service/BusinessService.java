package service;

import domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface BusinessService {
    void save(Customer c);

    List<Customer> findAll();

    List<Customer> findAll(DetachedCriteria dc);
}
