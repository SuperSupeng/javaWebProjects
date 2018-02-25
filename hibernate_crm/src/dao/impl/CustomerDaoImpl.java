package dao.impl;

import dao.CustomerDao;
import domain.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void save(Customer c) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(c);
    }

    @Override
    public List<Customer> findAll() {
        Session session = HibernateUtils.getCurrentSession();
        Criteria criteria = session.createCriteria(Customer.class);
        return criteria.list();
    }

    @Override
    public Customer getById(Long cust_id) {
        Session session = HibernateUtils.getCurrentSession();
        return session.get(Customer.class, cust_id);
    }
}
