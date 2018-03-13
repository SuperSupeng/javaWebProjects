package service.impl;

import dao.CustomerDao;
import entity.Customer;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao dao;

    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }

    @Override
    public Customer findById(Long id) {
        return dao.findById(id);
    }
}
