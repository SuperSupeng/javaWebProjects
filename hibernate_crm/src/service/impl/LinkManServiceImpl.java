package service.impl;

import dao.CustomerDao;
import dao.LinkManDao;
import dao.impl.CustomerDaoImpl;
import dao.impl.LinkManDaoImpl;
import domain.Customer;
import domain.LinkMan;
import org.hibernate.Session;
import service.LinkManService;
import utils.HibernateUtils;

public class LinkManServiceImpl implements LinkManService {
    private CustomerDao cd = new CustomerDaoImpl();
    private LinkManDao lmd = new LinkManDaoImpl();

    @Override
    public void save(LinkMan linkMan) {
        Long cust_id = linkMan.getCust_id();
        Customer customer = cd.getById(cust_id);
        linkMan.setCustomer(customer);
        lmd.save(linkMan);
    }
}
