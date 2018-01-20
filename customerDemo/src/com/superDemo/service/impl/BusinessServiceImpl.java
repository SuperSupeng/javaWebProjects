package com.superDemo.service.impl;

import com.superDemo.dao.CustomerDao;
import com.superDemo.dao.impl.CustomerDaoImpl;
import com.superDemo.domain.Customer;
import com.superDemo.exception.IdIsNullException;
import com.superDemo.service.BusinessService;
import com.superDemo.util.IdGenertor;

import java.util.List;

public class BusinessServiceImpl implements BusinessService {
    private CustomerDao dao = new CustomerDaoImpl();

    @Override
    public List<Customer> findAllCustomers() {
        return dao.findAll();
    }

    @Override
    public void saveCustomer(Customer c) {
        if(c == null){
            throw new IllegalArgumentException("参数不全");
        }
        c.setId(IdGenertor.genGUID());
        dao.save(c);
    }

    @Override
    public Customer findCustomerById(String cusromerId) {
        return dao.findById(cusromerId);
    }

    @Override
    public void updateCustomer(Customer c) throws IdIsNullException {
        if(c == null){
            throw new IllegalArgumentException("参数不全");
        }
        if(c.getId() == null || c.getId().equals("")){
            throw new IdIsNullException("更新的客户信息，id不能为空");
        }
        dao.update(c);
    }

    @Override
    public void deleteCustomerById(String customerId) {
        if(customerId == null || customerId.equals("")){
            throw new IllegalArgumentException("id不能为空");
        }
        dao.delete(customerId);
    }
}
