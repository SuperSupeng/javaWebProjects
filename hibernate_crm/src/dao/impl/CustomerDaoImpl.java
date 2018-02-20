package dao.impl;

import dao.CustomerDao;
import domain.Customer;
import org.hibernate.Session;
import utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void save(Customer c) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(c);
    }
}
