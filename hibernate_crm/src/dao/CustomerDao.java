package dao;

import domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerDao {
    void save(Customer c);

    List<Customer> findAll();

    Customer getById(Long cust_id);

    List<Customer> getAll(DetachedCriteria dc);
}
