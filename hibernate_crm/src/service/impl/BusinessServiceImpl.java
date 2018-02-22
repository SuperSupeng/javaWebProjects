package service.impl;

import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import domain.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.BusinessService;
import utils.HibernateUtils;

import java.util.List;

public class BusinessServiceImpl implements BusinessService {
    private CustomerDao dao = new CustomerDaoImpl();

    @Override
    public void save(Customer c) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            dao.save(c);
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
    }

    @Override
    public List<Customer> findAll() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Customer> list = dao.findAll();
        transaction.commit();
        return list;
    }
}
