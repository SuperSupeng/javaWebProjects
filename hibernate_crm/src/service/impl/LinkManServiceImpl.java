package service.impl;

import dao.CustomerDao;
import dao.LinkManDao;
import dao.impl.CustomerDaoImpl;
import dao.impl.LinkManDaoImpl;
import domain.Customer;
import domain.LinkMan;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.LinkManService;
import utils.HibernateUtils;

public class LinkManServiceImpl implements LinkManService {
    private CustomerDao cd = new CustomerDaoImpl();
    private LinkManDao lmd = new LinkManDaoImpl();

    @Override
    public void save(LinkMan linkMan) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try{
            Long cust_id = linkMan.getCust_id();
            Customer customer = cd.getById(cust_id);
            linkMan.setCustomer(customer);
            lmd.save(linkMan);
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }

        transaction.commit();
    }
}
