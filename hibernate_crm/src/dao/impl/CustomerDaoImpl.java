package dao.impl;

import dao.CustomerDao;
import domain.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void save(Customer c) {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        HibernateUtils.release();
    }
}
