package service.impl;

import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import domain.Customer;
import service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
    private CustomerDao dao = new CustomerDaoImpl();

    @Override
    public void save(Customer c) {
        dao.save(c);
    }
}
